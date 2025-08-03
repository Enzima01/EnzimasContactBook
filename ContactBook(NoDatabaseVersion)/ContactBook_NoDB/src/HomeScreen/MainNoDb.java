package HomeScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import JFrameScreen.SearchNoDb;
import java.awt.Color;

public class MainNoDb {

	private JFrame frmContactBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainNoDb window = new MainNoDb();
					window.frmContactBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainNoDb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContactBook = new JFrame();
		frmContactBook.setIconImage(Toolkit.getDefaultToolkit().getImage(MainNoDb.class.getResource("/Images/agenda.png")));
		frmContactBook.setTitle("Contact Book (No Database Version)");
		frmContactBook.setBounds(100, 100, 900, 640);
		frmContactBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContactBook.getContentPane().setLayout(null);
		frmContactBook.getContentPane().setLayout(null);
		frmContactBook.setResizable(false);
		frmContactBook.setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enzima's Contact Book");
		lblNewLabel_1.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/cadastro.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(276, 218, 312, 47);
		frmContactBook.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Manage your contacts and stay organized!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(293, 292, 285, 33);
		frmContactBook.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Made by Enzima01");
		lblNewLabel.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/01_16x16.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(360, 444, 139, 28);
		frmContactBook.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("No Database Version");
		lblNewLabel_3.setForeground(new Color(87, 174, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setBounds(371, 267, 121, 14);
		frmContactBook.getContentPane().add(lblNewLabel_3);
		
		JMenuBar menuBar = new JMenuBar();
		frmContactBook.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		mnFile.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/arquivo.png")));
		mnFile.setMnemonic('F');
		
		JMenuItem SUBmnContacts = new JMenuItem("Contacts");
		SUBmnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchNoDb searchScreen = new SearchNoDb();
				searchScreen.setVisible(true);
				
			}
		});
		SUBmnContacts.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/contato.png")));
		mnFile.add(SUBmnContacts);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/ajuda.png")));
		menuBar.add(mnHelp);
		mnHelp.setMnemonic('H');
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Contact Book - No Database Version\r\n"
						+ "\r\n"
						+ "This version of the Contact Book was created as a demonstration of how the system works without the need for a database connection.\r\n"
						+ "\r\n"
						+ "All data is stored in memory temporarily and will be lost once the program is closed.\r\n"
						+ "\r\n"
						+ "This application was built using Java Swing and is ideal for testing or showing how the interface and basic logic behave before connecting it to a real database.","Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/info.png")));
		mnHelp.add(mntmNewMenuItem);
		
		JMenuItem SUBmnExit = new JMenuItem("Exit");
		SUBmnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmContactBook.dispose();
			}
		});
		SUBmnExit.setIcon(new ImageIcon(MainNoDb.class.getResource("/Images/sair.png")));
		mnHelp.add(SUBmnExit);
	}
}
