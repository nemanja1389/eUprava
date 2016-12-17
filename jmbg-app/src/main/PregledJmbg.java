package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JRViewer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PregledJmbg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private CrudOperation getData = new CrudOperation();
	private JPopupMenu popup = new JPopupMenu();
	private JMenuItem detailItem = new JMenuItem("Detalji");
	private JMenuItem deleteItem = new JMenuItem("Obriši");
	private JMenuItem modidyItem = new JMenuItem("Modifikuj");
	private final SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
	private final Locale serbian = new Locale("sr", "RS");
	private final SimpleDateFormat sd = new SimpleDateFormat("EEEEEE, d MMMMMMMMMM YYYY", serbian);
	private int   currentSecond;
	private Calendar calendar;
	private JLabel lblTime;
	
	private void reset(){
		calendar = Calendar.getInstance();
		currentSecond = calendar.get(Calendar.SECOND);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Create the dialog.
	 */
	public PregledJmbg() {
		setIcon();
		setTitle("Pregled JMBG");
		setBounds(100, 100, 600, 400);
		setModal(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		popup.add(detailItem);
		popup.add(deleteItem);
		popup.add(modidyItem);
		modidyItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jmbgModifikacija();
				
			}
		});
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jmbgBrisanje();
				table.setModel(new CrudOperation().getAllData());
			}
		});
		detailItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jmbgDetails();
			}
		});
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						try {
							Point point = arg0.getPoint();
							int currentRow = table.rowAtPoint(point);
							table.setRowSelectionInterval(currentRow, currentRow);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				table.setComponentPopupMenu(popup);
				table.setModel(getData.getAllData());
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						UnosJmbg unos = new UnosJmbg(table);
						unos.setVisible(true);
						
					}
				});
				buttonPane.add(btnDodaj);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblDatum = new JLabel("Datum:");
				panel.add(lblDatum);
			}
			{
				JLabel lblDate = new JLabel("\u043F\u043E\u043D\u0435\u0434\u0435\u0459\u0430\u043A, 12 \u0434\u0435\u0446\u0435\u043C\u0431\u0430\u0440 2016");
				panel.add(lblDate);
			}
			{
				lblTime = new JLabel("");
				panel.add(lblTime);
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnFile = new JMenu("File");
				menuBar.add(mnFile);
				{
					JMenu mnIzvestaj = new JMenu("Izvestaj");
					mnFile.add(mnIzvestaj);
					{
						JMenuItem mntmSpisakSvihMatinih = new JMenuItem("Spisak svih mati\u010Dnih brojeva");
						mntmSpisakSvihMatinih.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ReportFrame reportFrame = new ReportFrame();
								Map parametars = new HashMap();
								parametars.put(JRParameter.REPORT_LOCALE, serbian);
								try {
									JasperReport report = JasperCompileManager
											.compileReport("..//..//test/jmbg-app/src/reports/Jmbg.jrxml");
									CrudOperation co = new CrudOperation();
									Connection conn = DriverManager.getConnection(co.getConnString(), co.getUser(),
											co.getPass());
									JasperPrint print = JasperFillManager.fillReport(report, parametars, conn);
									reportFrame.getContentPane().add(new JRViewer(print));
									reportFrame.setTitle("Matièni brojevi");
									reportFrame.setVisible(true);
								} catch (JRException ex) {
									ex.printStackTrace();
								} catch (SQLException ex1) {
									// TODO Auto-generated catch block
									ex1.printStackTrace();
								}
							}
						});
						mnIzvestaj.add(mntmSpisakSvihMatinih);
					}
					{
						JMenuItem mntmSpisakMatinihBrojeva = new JMenuItem("Spisak mati\u010Dnih brojeva prema regionu");
						mntmSpisakMatinihBrojeva.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ReportFrame reportFrame = new ReportFrame();
								Map parametars = new HashMap();
								parametars.put(JRParameter.REPORT_LOCALE, serbian);
								try {
									JasperReport report = JasperCompileManager
											.compileReport("..//..//test/jmbg-app/src/reports/JmbgByRegion.jrxml");
									CrudOperation co = new CrudOperation();
									Connection conn = DriverManager.getConnection(co.getConnString(), co.getUser(),
											co.getPass());
									JasperPrint print = JasperFillManager.fillReport(report, parametars, conn);
									reportFrame.getContentPane().add(new JRViewer(print));
									reportFrame.setTitle("Matièni brojevi");
									reportFrame.setVisible(true);
								} catch (JRException ex) {
									ex.printStackTrace();
								} catch (SQLException ex1) {
									// TODO Auto-generated catch block
									ex1.printStackTrace();
								}
							}
						});
						mnIzvestaj.add(mntmSpisakMatinihBrojeva);
					}
				}
			}
		}
	}

	public void jmbgDetails() {
		DetaljiJmbg detalji = new DetaljiJmbg();
		String ime = (String) table.getValueAt(table.getSelectedRow(), 0);
		String prezime = (String) table.getValueAt(table.getSelectedRow(), 1);
		String jmbg = (String) table.getValueAt(table.getSelectedRow(), 2);
		int a = Integer.parseInt(String.valueOf(jmbg.charAt(0)));
		int b = Integer.parseInt(String.valueOf(jmbg.charAt(1)));
		int v = Integer.parseInt(String.valueOf(jmbg.charAt(2)));
		int g = Integer.parseInt(String.valueOf(jmbg.charAt(3)));
		int d = Integer.parseInt(String.valueOf(jmbg.charAt(4)));
		int dj = Integer.parseInt(String.valueOf(jmbg.charAt(5)));
		int e = Integer.parseInt(String.valueOf(jmbg.charAt(6)));
		int z = Integer.parseInt(String.valueOf(jmbg.charAt(7)));
		int zz = Integer.parseInt(String.valueOf(jmbg.charAt(8)));
		int i = Integer.parseInt(String.valueOf(jmbg.charAt(9)));
		int j = Integer.parseInt(String.valueOf(jmbg.charAt(10)));
		int k = Integer.parseInt(String.valueOf(jmbg.charAt(11)));
		String godina = "";
		if (d == 9) {
			godina = godina + 1;
		} else {
			godina = godina + 2;
		}
		godina = godina + String.valueOf(d) + String.valueOf(dj) + String.valueOf(e);
		String datumRodjenja = (String.valueOf(a) + String.valueOf(b) + "." + String.valueOf(v) + String.valueOf(g)
				+ "." + godina);
		String region = String.valueOf(z) + String.valueOf(zz);
		String pol = null;
		if (i < 5) {
			pol = "Muško";
		} else if ((i >= 5) && (i < 10)) {
			pol = "Žensko";
		}
		String detePoRedu = String.valueOf(j) + String.valueOf(k);
		int dete = Integer.parseInt(detePoRedu)+1;
		detalji.setTxt(ime, prezime, jmbg, datumRodjenja, region, pol, String.valueOf(dete));
		detalji.setLocationRelativeTo(null);
		detalji.setModal(true);
		detalji.setVisible(true);
	}
	
	public void jmbgBrisanje() {
		BrisanjeJmbg detalji = new BrisanjeJmbg();
		String ime = (String) table.getValueAt(table.getSelectedRow(), 0);
		String prezime = (String) table.getValueAt(table.getSelectedRow(), 1);
		String jmbg = (String) table.getValueAt(table.getSelectedRow(), 2);
		int a = Integer.parseInt(String.valueOf(jmbg.charAt(0)));
		int b = Integer.parseInt(String.valueOf(jmbg.charAt(1)));
		int v = Integer.parseInt(String.valueOf(jmbg.charAt(2)));
		int g = Integer.parseInt(String.valueOf(jmbg.charAt(3)));
		int d = Integer.parseInt(String.valueOf(jmbg.charAt(4)));
		int dj = Integer.parseInt(String.valueOf(jmbg.charAt(5)));
		int e = Integer.parseInt(String.valueOf(jmbg.charAt(6)));
		int z = Integer.parseInt(String.valueOf(jmbg.charAt(7)));
		int zz = Integer.parseInt(String.valueOf(jmbg.charAt(8)));
		int i = Integer.parseInt(String.valueOf(jmbg.charAt(9)));
		int j = Integer.parseInt(String.valueOf(jmbg.charAt(10)));
		int k = Integer.parseInt(String.valueOf(jmbg.charAt(11)));
		String godina = "";
		if (d == 9) {
			godina = godina + 1;
		} else {
			godina = godina + 2;
		}
		godina = godina + String.valueOf(d) + String.valueOf(dj) + String.valueOf(e);
		String datumRodjenja = (String.valueOf(a) + String.valueOf(b) + "." + String.valueOf(v) + String.valueOf(g)
				+ "." + godina);
		String region = String.valueOf(z) + String.valueOf(zz);
		String pol = null;
		if (i < 5) {
			pol = "Muško";
		} else if ((i >= 5) && (i < 10)) {
			pol = "Žensko";
		}
		String detePoRedu = String.valueOf(j) + String.valueOf(k);
		int dete = Integer.parseInt(detePoRedu)+1;
		detalji.setTxt(ime, prezime, jmbg, datumRodjenja, region, pol, String.valueOf(dete));
		detalji.setLocationRelativeTo(null);
		detalji.setModal(true);
		detalji.setVisible(true);
	}
	
	public void jmbgModifikacija() {
		ModifikacijaJmbg modifikacija = new ModifikacijaJmbg(table);
		String ime = (String) table.getValueAt(table.getSelectedRow(), 0);
		String prezime = (String) table.getValueAt(table.getSelectedRow(), 1);
		String jmbg = (String) table.getValueAt(table.getSelectedRow(), 2);
		int a = Integer.parseInt(String.valueOf(jmbg.charAt(0)));
		int b = Integer.parseInt(String.valueOf(jmbg.charAt(1)));
		int v = Integer.parseInt(String.valueOf(jmbg.charAt(2)));
		int g = Integer.parseInt(String.valueOf(jmbg.charAt(3)));
		int d = Integer.parseInt(String.valueOf(jmbg.charAt(4)));
		int dj = Integer.parseInt(String.valueOf(jmbg.charAt(5)));
		int e = Integer.parseInt(String.valueOf(jmbg.charAt(6)));
		int z = Integer.parseInt(String.valueOf(jmbg.charAt(7)));
		int zz = Integer.parseInt(String.valueOf(jmbg.charAt(8)));
		int i = Integer.parseInt(String.valueOf(jmbg.charAt(9)));
		int j = Integer.parseInt(String.valueOf(jmbg.charAt(10)));
		int k = Integer.parseInt(String.valueOf(jmbg.charAt(11)));
		String godina = "";
		if (d == 9) {
			godina = godina + 1;
		} else {
			godina = godina + 2;
		}
		godina = godina + String.valueOf(d) + String.valueOf(dj) + String.valueOf(e);
		String datumRodjenja = (String.valueOf(a) + String.valueOf(b) + "." + String.valueOf(v) + String.valueOf(g)
				+ "." + godina);
		String region = String.valueOf(z) + String.valueOf(zz);
		String pol = null;
		if (i < 5) {
			pol = "Muško";
		} else if ((i >= 5) && (i < 10)) {
			pol = "Žensko";
		}
		String detePoRedu = String.valueOf(j) + String.valueOf(k);
		int dete = Integer.parseInt(detePoRedu)+1;
		modifikacija.setTxt(ime, prezime, jmbg, datumRodjenja, region, pol, String.valueOf(dete));
		modifikacija.setRegionId(new CrudOperation().getRegionId(region));
		modifikacija.setPersonId(new CrudOperation().getPerosnId(jmbg));
		modifikacija.setLocationRelativeTo(null);
		modifikacija.setModal(true);
		modifikacija.setVisible(true);
		
	}
	
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..//..//test/jmbg-app/src/main/rsz_1rsz_1rsz_1rsz_115175360_10207778959653698_959675822_n.jpg"));
	}
	
	

}
