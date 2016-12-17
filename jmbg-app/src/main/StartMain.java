package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class StartMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMain frame = new StartMain();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartMain() {
		setTitle("Jedinstven matièni broj graðana - JMBG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 703);
		setIcon();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmPregledMatinihBrojeva = new JMenuItem("Pregled mati\u010Dnih brojeva");
		mntmPregledMatinihBrojeva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PregledJmbg pregled = new PregledJmbg();
				pregled.setVisible(true);
			}
		});
		mnFile.add(mntmPregledMatinihBrojeva);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartMain.class.getResource("/main/15184089_10207779020055208_703513471_o.jpg")));
		contentPane.add(label, BorderLayout.CENTER);
	}

	
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..//..//test/jmbg-app/src/main/rsz_1rsz_1rsz_1rsz_115175360_10207778959653698_959675822_n.jpg"));
	}

}
