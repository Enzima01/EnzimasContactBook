package HomeScreen;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Class.MySQL_Connection;
import JFrameScreen.Search;

public class Main {

	private JFrame frmContactBook;
	private JTextField txtStatusWaitingFor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmContactBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private boolean isConnected = false;

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContactBook = new JFrame();
		frmContactBook.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/agenda.png")));
		frmContactBook.setTitle("Contact Book");
		frmContactBook.setBounds(100, 100, 900, 640);
		frmContactBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContactBook.getContentPane().setLayout(null);
		frmContactBook.setResizable(false);
		frmContactBook.setLocationRelativeTo(null);

		txtStatusWaitingFor = new JTextField();
		txtStatusWaitingFor.setEditable(false);
		txtStatusWaitingFor.setBackground(new Color(240, 240, 240));
		txtStatusWaitingFor.setForeground(Color.RED);
		txtStatusWaitingFor.setText("Status: Waiting for connection...");
		txtStatusWaitingFor.setBounds(346, 316, 179, 20);
		frmContactBook.getContentPane().add(txtStatusWaitingFor);
		txtStatusWaitingFor.setColumns(10);
		txtStatusWaitingFor.setBorder(null);

		JButton btnConnectionTest = new JButton("Connect to Database");
		btnConnectionTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection connection = new MySQL_Connection().getConnection();

				if (connection != null) {

					isConnected = true;
					JOptionPane.showMessageDialog(null, "Database connection successful!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					txtStatusWaitingFor.setForeground(Color.GREEN);
					txtStatusWaitingFor.setBounds(370, 316, 179, 20);
					txtStatusWaitingFor.setText("Status: Connected!");

				} else {
					txtStatusWaitingFor = new JTextField();
					txtStatusWaitingFor.setEditable(false);
					txtStatusWaitingFor.setBackground(new Color(240, 240, 240));
					txtStatusWaitingFor.setForeground(Color.RED);
					txtStatusWaitingFor.setText("Status: Waiting for connection...");
					txtStatusWaitingFor.setBounds(346, 316, 179, 20);
					frmContactBook.getContentPane().add(txtStatusWaitingFor);
					txtStatusWaitingFor.setColumns(10);
					txtStatusWaitingFor.setBorder(null);
				}
			}
		});

		btnConnectionTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConnectionTest.setBounds(293, 241, 259, 64);
		frmContactBook.getContentPane().add(btnConnectionTest);

		JLabel lblNewLabel = new JLabel("Made by Enzima01");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/Images/01_16x16.png")));
		lblNewLabel.setLabelFor(frmContactBook);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(350, 540, 158, 28);
		frmContactBook.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enzima's Contact Book");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/Images/cadastro.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(265, 67, 312, 47);
		frmContactBook.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Manage your contacts and stay organized!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(281, 109, 285, 33);
		frmContactBook.getContentPane().add(lblNewLabel_2);

		JMenuBar menuBar = new JMenuBar();
		frmContactBook.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setIcon(new ImageIcon(Main.class.getResource("/Images/arquivo.png")));
		menuBar.add(mnFile);

		JMenuItem SUBmnContacts = new JMenuItem("Contacts");
		SUBmnContacts.setIcon(new ImageIcon(Main.class.getResource("/Images/contato.png")));
		SUBmnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!isConnected) {
					JOptionPane.showMessageDialog(null, "Please connect to the database first!", "Warning",
							JOptionPane.WARNING_MESSAGE);

					int answer = JOptionPane.showConfirmDialog(null, "Do you want to continue without a database?",
							"No database", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (answer != JOptionPane.YES_OPTION) {

						return;
					}

				}

				Search searchScreen = new Search();
				searchScreen.setVisible(true);
			}
		});
		mnFile.add(SUBmnContacts);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		mnHelp.setIcon(new ImageIcon(Main.class.getResource("/Images/ajuda.png")));
		menuBar.add(mnHelp);

		JMenuItem SUBmnExit = new JMenuItem("Exit");
		SUBmnExit.setIcon(new ImageIcon(Main.class.getResource("/Images/sair.png")));
		SUBmnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmContactBook.dispose();
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Contact Book is a Java desktop application created to manage your personal or professional contacts. \r\n"
								+ "You can add, edit, delete, and search through a list of contacts stored in a MySQL database.\r\n"
								+ "\r\n" + "To use the program:\r\n" + "1. Click on \"Connect to Database\" first.\r\n"
								+ "2. Once connected, go to the \"Contacts\" menu to manage your entries.\r\n" + "\r\n"
								+ "If you try to access the Contacts section without connecting to the database, \r\n"
								+ "a warning will be shown reminding you to connect first.",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Main.class.getResource("/Images/info.png")));
		mnHelp.add(mntmNewMenuItem);
		frmContactBook.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				frmContactBook.getContentPane(), btnConnectionTest, lblNewLabel, lblNewLabel_1, menuBar, mnFile,
				SUBmnContacts, mnHelp, SUBmnExit, lblNewLabel_2, txtStatusWaitingFor, mntmNewMenuItem }));
		mnHelp.add(SUBmnExit);
	}
}
