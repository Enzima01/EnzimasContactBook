package JFrameScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Class.BookData;
import Class.DbOperations;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtAddress;

	public static MaskFormatter txtTelephone;
	public static MaskFormatter txtBirthdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/Images/new.png")));

		setTitle("Register User Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

		int width = 700;
		int height = 440;

		setBounds(center.x - width / 2, center.y - height / 2, 700, 440);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setBounds(10, 11, 30, 25);
		contentPane.add(lblID);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 81, 67, 25);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(10, 108, 462, 36);
		contentPane.add(txtName);

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtID.setColumns(10);
		txtID.setBounds(10, 34, 218, 36);
		txtID.setEnabled(false);
		txtID.setEditable(false);
		contentPane.add(txtID);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(196, 179, 276, 36);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(196, 155, 67, 25);
		contentPane.add(lblEmail);

		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelephone.setBounds(10, 155, 111, 25);
		contentPane.add(lblTelephone);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 226, 77, 25);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAddress.setColumns(10);
		txtAddress.setBounds(10, 251, 462, 36);
		contentPane.add(txtAddress);

		JFormattedTextField txtTelephone = new JFormattedTextField(telephoneMask());
		txtTelephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelephone.setBounds(10, 179, 176, 36);
		contentPane.add(txtTelephone);

		JFormattedTextField txtBirthdate = new JFormattedTextField(birthdateMask());
		txtBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBirthdate.setBounds(10, 321, 123, 36);
		contentPane.add(txtBirthdate);

		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBirthDate.setBounds(10, 298, 98, 25);
		contentPane.add(lblBirthDate);

		JComboBox<String> comboBox_Children = new JComboBox<>();
		comboBox_Children.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_Children.setModel(new DefaultComboBoxModel<String>(new String[] { "-", "Yes", "No" }));
		comboBox_Children.setBounds(164, 321, 83, 36);
		contentPane.add(comboBox_Children);

		JLabel lblChildren = new JLabel("Children:");
		lblChildren.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChildren.setBounds(165, 298, 98, 25);
		contentPane.add(lblChildren);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = txtName.getText().trim();
				String telephone = txtTelephone.getText().trim();
				String email = txtEmail.getText().trim();
				String address = txtAddress.getText().trim();
				String birthdate = txtBirthdate.getText().trim();
				String children = comboBox_Children.getSelectedItem().toString();

				// Verificação
				if (name.isEmpty() || telephone.isEmpty() || email.isEmpty() || address.isEmpty() || birthdate.isEmpty()
						|| children.equals("-")) {

					JOptionPane.showMessageDialog(null, "Please fill in all required fields!", "Missing Information",
							JOptionPane.WARNING_MESSAGE);
					return; // não continua o salvamento
				}

				try {
					BookData obj = new BookData();
					obj.setUsername(txtName.getText());
					obj.setTelephone(txtTelephone.getText());
					obj.setEmail(txtEmail.getText());
					obj.setAddress(txtAddress.getText());
					obj.setBirthdate(txtBirthdate.getText());
					obj.setChildren(comboBox_Children.getSelectedItem().toString());

					DbOperations saveData = new DbOperations();
					saveData.Register(obj);

					dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error saving data! \n" + e1, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setMnemonic('S');
		btnSave.setIcon(new ImageIcon(Register.class.getResource("/Images/salvar.png")));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSave.setBounds(505, 301, 152, 74);
		contentPane.add(btnSave);

	}

	public static MaskFormatter telephoneMask() {

		try {
			txtTelephone = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		txtTelephone.setPlaceholderCharacter('_');

		return txtTelephone;
	}

	public static MaskFormatter birthdateMask() {

		try {
			txtBirthdate = new MaskFormatter("##/##/####");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		txtBirthdate.setPlaceholderCharacter('_');

		return txtBirthdate;
	}
}
