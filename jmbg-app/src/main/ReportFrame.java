package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReportFrame extends JFrame {

	private JPanel contentPane;

	public ReportFrame() {
		setIcon();
		setTitle("Izveštaj");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..//..//test/jmbg-app/src/main/rsz_1rsz_1rsz_1rsz_115175360_10207778959653698_959675822_n.jpg"));
	}

}
