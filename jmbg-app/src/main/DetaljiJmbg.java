package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DetaljiJmbg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtDatum;
	private JTextField txtDrzava;
	private JTextField txtPol;
	private JLabel lblDetePoRedu;
	private JTextField txtPoRedu;
	private JTextField txtRegion;

	/**
	 * Create the dialog.
	 */
	public DetaljiJmbg() {
		setIcon();
		setTitle("Detalji JMBG");
		setBounds(100, 100, 300, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		

		JLabel lblIme = new JLabel("Ime:");
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja:");
		
		txtDatum = new JTextField();
		txtDatum.setColumns(10);
		
		JLabel lblRegion = new JLabel("Region:");
		
		txtRegion = new JTextField();
		txtRegion.setColumns(10);
		
		JLabel lblDrzava = new JLabel("Drzava:");
		
		txtDrzava = new JTextField();
		txtDrzava.setColumns(10);
		
		JLabel lblPol = new JLabel("Pol:");
		
		txtPol = new JTextField();
		txtPol.setColumns(10);
		
		lblDetePoRedu = new JLabel("Dete po redu:");
		
		txtPoRedu = new JTextField();
		txtPoRedu.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPanel);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPrezime)
									.addComponent(lblIme)
									.addComponent(lblJmbg))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtJmbg, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
									.addComponent(txtPrezime)
									.addComponent(txtIme)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDatumRodjenja)
									.addComponent(lblRegion)
									.addComponent(lblDrzava))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtRegion, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addComponent(txtDatum)
									.addComponent(txtDrzava, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addComponent(txtPol, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addComponent(txtPoRedu, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))))
						.addComponent(lblPol)
						.addComponent(lblDetePoRedu))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIme)
						.addComponent(txtIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrezime)
						.addComponent(txtPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJmbg)
						.addComponent(txtJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatumRodjenja)
						.addComponent(txtDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegion)
						.addComponent(txtRegion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDrzava, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDrzava))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPol)
						.addComponent(txtPol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDetePoRedu)
						.addComponent(txtPoRedu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPane);
	}
	
	public void setTxt(String ime, String prezime, String jmbg, String datum, String region, String pol, String detePoRedu){
		txtIme.setText(ime);
		txtIme.setEditable(false);
		txtPrezime.setText(prezime);
		txtPrezime.setEditable(false);
		txtJmbg.setText(jmbg);
		txtJmbg.setEditable(false);
		txtDatum.setText(datum);
		txtDatum.setEditable(false);
		txtRegion.setText(new CrudOperation().getRegion(region));
		txtRegion.setEditable(false);
		txtDrzava.setText(new CrudOperation().getDrzava(region));
		txtDrzava.setEditable(false);
		txtPol.setText(pol);
		txtPol.setEditable(false);
		txtPoRedu.setText(detePoRedu);
		txtPoRedu.setEditable(false);
	}
	
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..//..//test/jmbg-app/src/main/rsz_1rsz_1rsz_1rsz_115175360_10207778959653698_959675822_n.jpg"));
	}
}
