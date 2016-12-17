package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ModifikacijaJmbg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDete;
	private JTextField txtPol;
	private JTextField txtDrzava;
	private JTextField txtRegion;
	private JTextField txtDatum;
	private JTextField txtJmbg;
	private JTextField txtPrezime;
	private JTextField txtIme;
	private JTable table;
	private int personId;
	private int regionId;
	
	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * Create the dialog.
	 */
	public ModifikacijaJmbg(JTable table) {
		setIcon();
		setTitle("Modifikacija JMBG");
		this.table = table;
		setBounds(100, 100, 347, 380);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel label = new JLabel("Dete po redu:");
		txtDete = new JTextField();
		txtDete.setEditable(false);
		txtDete.setColumns(10);
		txtPol = new JTextField();
		txtPol.setColumns(10);
		txtPol.setEditable(false);
		JLabel label_1 = new JLabel("Pol:");
		JLabel label_2 = new JLabel("Drzava:");
		txtDrzava = new JTextField();
		txtDrzava.setEditable(false);
		txtDrzava.setColumns(10);
		txtRegion = new JTextField();
		txtRegion.setEditable(false);
		txtRegion.setColumns(10);
		JLabel label_3 = new JLabel("Region:");
		JLabel label_4 = new JLabel("Datum rodjenja:");
		txtDatum = new JTextField();
		txtDatum.setEditable(false);
		txtDatum.setColumns(10);
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		JLabel label_5 = new JLabel("JMBG:");
		JLabel label_6 = new JLabel("Prezime:");
		txtPrezime = new JTextField();
		txtPrezime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar())) {
					JOptionPane.showMessageDialog(null, "Prezime moze da sadrzi samo slova.", "Informacija",
							JOptionPane.INFORMATION_MESSAGE);
					e.consume();
				}
			}
		});
		txtPrezime.setColumns(10);
		txtIme = new JTextField();
		txtIme.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (Character.isDigit(arg0.getKeyChar())) {
					JOptionPane.showMessageDialog(null, "Ime moze da sadrzi samo slova.", "Informacija",
							JOptionPane.INFORMATION_MESSAGE);
					arg0.consume();
				}
			}
		});
		txtIme.setColumns(10);
		JLabel label_7 = new JLabel("Ime:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
						.createSequentialGroup().addGap(10).addGroup(gl_contentPanel
								.createParallelGroup(Alignment.LEADING).addGroup(
										gl_contentPanel
												.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(label_5,
														GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
												.addComponent(txtJmbg, GroupLayout.PREFERRED_SIZE,
														165, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
										.addGap(187))
								.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_4, GroupLayout.DEFAULT_SIZE,
																				126, Short.MAX_VALUE)
																		.addComponent(label_7).addComponent(label_6,
																				GroupLayout.DEFAULT_SIZE, 126,
																				Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.UNRELATED))
														.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 136,
																Short.MAX_VALUE)))
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 52,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(label, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtDete, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtPol, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDrzava, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtRegion, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDatum, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtIme, GroupLayout.PREFERRED_SIZE, 165,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtPrezime, GroupLayout.PREFERRED_SIZE, 165,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(4)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_7).addComponent(
						txtIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_6).addComponent(
						txtPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_5).addComponent(
						txtJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_4).addComponent(
						txtDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(
						txtRegion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(
						txtDrzava, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						txtPol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						txtDete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(3)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String ime1 = txtIme.getText();
						String prezime = txtPrezime.getText();
						String jmbg = txtJmbg.getText();
						if (ime1.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Unesite ime", "Informacija",
									JOptionPane.INFORMATION_MESSAGE);
						} else if (prezime.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Unesite prezime", "Informacija",
									JOptionPane.INFORMATION_MESSAGE);
						} else if (jmbg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Unesite JMBG", "Informacija",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							if (jmbg.length() != 13) {
								JOptionPane.showMessageDialog(null,
										"Maticni broj " + jmbg
												+ " ima manje ili vise cifara od 13. Unesite ponovo maticni broj.",
										"Upozorenje", JOptionPane.WARNING_MESSAGE);
								System.out
										.println("Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
							} else {
								try {
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
									int l = Integer.parseInt(String.valueOf(jmbg.charAt(12)));
									int zzz = 0;
									int raz = 0;
									int ost = 0;
									int dan = Integer.valueOf(String.valueOf(a) + String.valueOf(b));
									int mesec = Integer.valueOf(String.valueOf(v) + String.valueOf(g));
									int godina = Integer
											.valueOf(String.valueOf(d) + String.valueOf(dj) + String.valueOf(e));
									String r = String.valueOf(z) + String.valueOf(zz);
									int region = Integer.parseInt(r);
									if (a < 1 && b < 1) {
										JOptionPane.showMessageDialog(null,
												"Maticni broj  " + jmbg
														+ "  je neispravan. Prva i druga cifra su neispravne. Prva i treca cifra ne smeju da budu nule. Unesite ponovo maticni broj.",
												"Upozorenje", JOptionPane.WARNING_MESSAGE);
										System.out.println(
												"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
									} else if (a > 3) {
										JOptionPane.showMessageDialog(null,
												"Maticni broj  " + jmbg
														+ "  je neispravan. Prva cifra je neispravna. Prva cifra ne sme biti veca od 3. Unesite ponovo maticni broj.",
												"Upozorenje", JOptionPane.WARNING_MESSAGE);
										System.out.println(
												"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
									} else if ((a == 3) && (b > 1)) {
										JOptionPane.showMessageDialog(null,
												"Maticni broj  " + jmbg
														+ "  je neispravan. Druga cifra je neispravna. Druga ne sme biti veca od 1. Unesite ponovo maticni broj.",
												"Upozorenje", JOptionPane.WARNING_MESSAGE);
										System.out.println(
												"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
									} else {
										if (v > 1) {
											JOptionPane.showMessageDialog(null,
													"Maticni broj  " + jmbg
															+ "  je neispravan. Treca cifra je neispravna. Treca cifra ne sme biti veca od 1. Unesite ponovo maticni broj.",
													"Upozorenje", JOptionPane.WARNING_MESSAGE);
											System.out.println(
													" Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
										} else if ((v == 1) && (g > 2)) {
											JOptionPane.showMessageDialog(null,
													"Maticni broj  " + jmbg
															+ "  je neispravan. Cetvrta cifra je neispravna. Cetvrta cifra ne sme biti veca od 2. Unesite ponovo maticni broj.",
													"Upozorenje", JOptionPane.WARNING_MESSAGE);
											System.out.println(
													"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
										} else if ((v == 0) && (g == 0)) {
											JOptionPane.showMessageDialog(null,
													"Maticni broj  " + jmbg
															+ "  je neispravan. Treca i cetvrta cifra su neispravne. Treca i cetvrta cifra ne smeju biti 0. Unesite ponovo maticni broj.",
													"Upozorenje", JOptionPane.WARNING_MESSAGE);
											System.out.println(
													"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
										} else {
											if((godina<900)&&(godina>16)){
												JOptionPane.showMessageDialog(null,
														"Maticni broj  " + jmbg
																+ "  je neispravan. Peta, sesta i sedma cifra su neispravne. Unesite ponovo maticni broj.",
														"Upozorenje", JOptionPane.WARNING_MESSAGE);
											} else {
												if (((region > 10) && (region < 22)) || (region == 26) || (region == 29)
														|| ((region > 29) && (region < 40))
														|| ((region > 40) && (region < 51))
														|| ((region > 70) && (region < 83))
														|| ((region > 84) && (region < 96))) {
													if ((mesec == 1) || (mesec == 3) || (mesec == 5) || (mesec == 7)
															|| (mesec == 8) || (mesec == 10) || (mesec == 12)) {
														if (dan <= 31) {
															zzz = (a * 7) + (b * 6) + (v * 5) + (g * 4) + (d * 3) + (dj * 2)
																	+ (e * 7) + (z * 6) + (zz * 5) + (i * 4) + (j * 3)
																	+ (k * 2);
															System.out.println(zzz);
															ost = zzz % 11;
															System.out.println(ost);
															raz = 11 - ost;
															System.out.println(raz);
															if ((ost == 1) || (raz == 10)) {
																JOptionPane.showMessageDialog(null,
																		"Maticni broj  " + jmbg
																				+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																		"Upozorenje", JOptionPane.WARNING_MESSAGE);
																System.out.println(
																		"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
															} else if (ost == 0) {
																if (l == ost) {
																	new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																	dispose();
																	table.setModel(new CrudOperation().getAllData());
																} else {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(

																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																}
															} else if ((1 < ost) && (ost < 11)) {
																if (l == raz) {
																	new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																	dispose();
																	table.setModel(new CrudOperation().getAllData());
																} else {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(
																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																}
															} else {
																JOptionPane.showMessageDialog(null,
																		"Maticni broj  " + jmbg
																				+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																		"Upozorenje", JOptionPane.WARNING_MESSAGE);
																System.out.println(
																		"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
															}
														} else {
															JOptionPane.showMessageDialog(null,
																	"Maticni broj  " + jmbg
																			+ "  je neispravan. Prva i druga cifra su neispravne. Unesite ponovo maticni broj.",
																	"Upozorenje", JOptionPane.WARNING_MESSAGE);
															System.out.println(
																	"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
														}
													} else if ((mesec == 4) || (mesec == 6) || (mesec == 9)
															|| (mesec == 11)) {
														if (dan <= 30) {
															zzz = (a * 7) + (b * 6) + (v * 5) + (g * 4) + (d * 3) + (dj * 2)
																	+ (e * 7) + (z * 6) + (zz * 5) + (i * 4) + (j * 3)
																	+ (k * 2);
															System.out.println(zzz);
															ost = zzz % 11;
															System.out.println(ost);
															raz = 11 - ost;
															System.out.println(raz);
															if ((ost == 1) || (raz == 10)) {
																JOptionPane.showMessageDialog(null,
																		"Maticni broj  " + jmbg
																				+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																		"Upozorenje", JOptionPane.WARNING_MESSAGE);
																System.out.println(
																		"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
															} else if (ost == 0) {
																if (l == ost) {
																	new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																	dispose();
																	table.setModel(new CrudOperation().getAllData());
																} else {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(

																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																}
															} else if ((1 < ost) && (ost < 11)) {
																if (l == raz) {
																	new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																	dispose();
																	table.setModel(new CrudOperation().getAllData());
																} else {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(
																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																}
															} else {
																JOptionPane.showMessageDialog(null,
																		"Maticni broj  " + jmbg
																				+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																		"Upozorenje", JOptionPane.WARNING_MESSAGE);
																System.out.println(
																		"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
															}
														} else {
															JOptionPane.showMessageDialog(null,
																	"Maticni broj  " + jmbg
																			+ "  je neispravan. Prva i druga cifra su neispravne. Unesite ponovo maticni broj.",
																	"Upozorenje", JOptionPane.WARNING_MESSAGE);
															System.out.println(
																	"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
														}
													} else {
														if (isPrestupna(godina)) {
															if (dan <= 29) {
																zzz = (a * 7) + (b * 6) + (v * 5) + (g * 4) + (d * 3) + (dj * 2)
																		+ (e * 7) + (z * 6) + (zz * 5) + (i * 4) + (j * 3)
																		+ (k * 2);
																System.out.println(zzz);
																ost = zzz % 11;
																System.out.println(ost);
																raz = 11 - ost;
																System.out.println(raz);
																if ((ost == 1) || (raz == 10)) {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(
																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																} else if (ost == 0) {
																	if (l == ost) {
																		new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																		dispose();
																		table.setModel(new CrudOperation().getAllData());
																	} else {
																		JOptionPane.showMessageDialog(null,
																				"Maticni broj  " + jmbg
																						+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																				"Upozorenje", JOptionPane.WARNING_MESSAGE);
																		System.out.println(

																				"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																	}
																} else if ((1 < ost) && (ost < 11)) {
																	if (l == raz) {
																		new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																		dispose();
																		table.setModel(new CrudOperation().getAllData());
																	} else {
																		JOptionPane.showMessageDialog(null,
																				"Maticni broj  " + jmbg
																						+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																				"Upozorenje", JOptionPane.WARNING_MESSAGE);
																		System.out.println(
																				"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																	}
																} else {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(
																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																}
															} else {
																JOptionPane.showMessageDialog(null,
																		"Maticni broj  " + jmbg
																				+ "  je neispravan. Prva i druga cifra su neispravne. Unesite ponovo maticni broj.",
																		"Upozorenje", JOptionPane.WARNING_MESSAGE);
																System.out.println(
																		"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
															}
														} else {
															if (dan <= 28) {
																zzz = (a * 7) + (b * 6) + (v * 5) + (g * 4) + (d * 3) + (dj * 2)
																		+ (e * 7) + (z * 6) + (zz * 5) + (i * 4) + (j * 3)
																		+ (k * 2);
																System.out.println(zzz);
																ost = zzz % 11;
																System.out.println(ost);
																raz = 11 - ost;
																System.out.println(raz);
																if ((ost == 1) || (raz == 10)) {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(
																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																} else if (ost == 0) {
																	if (l == ost) {
																		new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																		dispose();
																		table.setModel(new CrudOperation().getAllData());
																	} else {
																		JOptionPane.showMessageDialog(null,
																				"Maticni broj  " + jmbg
																						+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																				"Upozorenje", JOptionPane.WARNING_MESSAGE);
																		System.out.println(

																				"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																	}
																} else if ((1 < ost) && (ost < 11)) {
																	if (l == raz) {
																		new CrudOperation().updatePerson(personId, txtIme.getText(), txtPrezime.getText(), txtJmbg.getText(), region);
																		dispose();
																		table.setModel(new CrudOperation().getAllData());
																	} else {
																		JOptionPane.showMessageDialog(null,
																				"Maticni broj  " + jmbg
																						+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																				"Upozorenje", JOptionPane.WARNING_MESSAGE);
																		System.out.println(
																				"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																	}
																} else {
																	JOptionPane.showMessageDialog(null,
																			"Maticni broj  " + jmbg
																					+ "  je neispravan. Trinaesta cifra je neispravna. Unesite ponovo maticni broj.",
																			"Upozorenje", JOptionPane.WARNING_MESSAGE);
																	System.out.println(
																			"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
																}
															} else {
																JOptionPane.showMessageDialog(null,
																		"Maticni broj  " + jmbg
																				+ "  je neispravan. Prva i druga cifra su neispravne. Unesite ponovo maticni broj.",
																		"Upozorenje", JOptionPane.WARNING_MESSAGE);
																System.out.println(
																		"Maticni broj je neispravan. Molomo Vas unesite ponovo maticni broj");
															}
														}
													}
												}else{
													JOptionPane.showMessageDialog(null, "Maticni broj neispravan. Osma i deveta cifra su neispravne. Unesite ponovo maticni broj", "Informacija", JOptionPane.INFORMATION_MESSAGE);
												}
											}
											
										}
									}

								} catch (Exception e) {
									JOptionPane.showMessageDialog(null,
											"Maticni broj " + jmbg
													+ " sadrzi slova. Maticni broj mora da sadrzi samo brojeve.",
											"Upozorenje", JOptionPane.WARNING_MESSAGE);
								}
							}
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

		public void setTxt(String ime, String prezime, String jmbg, String datum, String region, String pol, String detePoRedu) {
			txtIme.setText(ime);
			txtPrezime.setText(prezime);
			txtJmbg.setText(jmbg);
			txtDatum.setText(datum);
			txtDatum.setEditable(false);
			txtRegion.setText(new CrudOperation().getRegion(region));
			txtRegion.setEditable(false);
			txtDrzava.setText(new CrudOperation().getDrzava(region));
			txtDrzava.setEditable(false);
			txtPol.setText(pol);
			txtPol.setEditable(false);
			txtDete.setText(detePoRedu);
			txtDete.setEditable(false);
		}

		public static Boolean isPrestupna(int godina) {
			if (godina % 400 == 0) {
				return true;
			} else if ((godina % 100 != 0) && (godina % 4 == 0)) {
				return true;
			} else
				return false;
		}

		private void setIcon() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("..//..//test/jmbg-app/src/main/rsz_1rsz_1rsz_1rsz_115175360_10207778959653698_959675822_n.jpg"));
		}
}
