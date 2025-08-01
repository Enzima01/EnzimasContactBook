package JFrameScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Class.BookData;
import Class.DbOperations;
import java.awt.Toolkit;

public class EditData extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtChange_ID;
	private JTextField txtChange_Name;
	private JTextField txtChange_Email;
	private JTextField txtChange_Address;
	private JFormattedTextField txtChange_Telephone;
	private JFormattedTextField txtChange_Birthdate;
	private JComboBox<String> cmbChange_Children;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditData frame = new EditData();
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
	public EditData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditData.class.getResource("/Images/editar.png")));
		setTitle("Edit Data");
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

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 30, 25);
		contentPane.add(lblNewLabel);

		txtChange_ID = new JTextField();
		txtChange_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_ID.setEnabled(false);
		txtChange_ID.setEditable(false);
		txtChange_ID.setColumns(10);
		txtChange_ID.setBounds(10, 34, 218, 36);
		contentPane.add(txtChange_ID);

		txtChange_Name = new JTextField();
		txtChange_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Name.setColumns(10);
		txtChange_Name.setBounds(10, 108, 462, 36);
		contentPane.add(txtChange_Name);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 81, 67, 25);
		contentPane.add(lblName);

		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelephone.setBounds(10, 155, 111, 25);
		contentPane.add(lblTelephone);

		txtChange_Telephone = new JFormattedTextField((AbstractFormatter) null);
		txtChange_Telephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Telephone.setBounds(10, 179, 176, 36);
		contentPane.add(txtChange_Telephone);

		txtChange_Email = new JTextField();
		txtChange_Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Email.setColumns(10);
		txtChange_Email.setBounds(196, 179, 276, 36);
		contentPane.add(txtChange_Email);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(196, 155, 67, 25);
		contentPane.add(lblEmail);

		txtChange_Address = new JTextField();
		txtChange_Address.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Address.setColumns(10);
		txtChange_Address.setBounds(10, 251, 462, 36);
		contentPane.add(txtChange_Address);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 226, 77, 25);
		contentPane.add(lblAddress);

		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBirthDate.setBounds(10, 298, 98, 25);
		contentPane.add(lblBirthDate);

		txtChange_Birthdate = new JFormattedTextField((AbstractFormatter) null);
		txtChange_Birthdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Birthdate.setBounds(10, 321, 123, 36);
		contentPane.add(txtChange_Birthdate);

		JLabel lblChildren = new JLabel("Children:");
		lblChildren.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChildren.setBounds(165, 298, 98, 25);
		contentPane.add(lblChildren);

		cmbChange_Children = new JComboBox<String>();
		cmbChange_Children.setModel(new DefaultComboBoxModel<String>(new String[] { "-", "Yes", "No" }));
		cmbChange_Children.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbChange_Children.setBounds(164, 321, 83, 36);
		contentPane.add(cmbChange_Children);

		btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon(EditData.class.getResource("/Images/salvar.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtChange_Name.getText().trim();
				String telephone = txtChange_Telephone.getText().trim();
				String email = txtChange_Email.getText().trim();
				String address = txtChange_Address.getText().trim();
				String birthdate = txtChange_Birthdate.getText().trim();
				String children = cmbChange_Children.getSelectedItem().toString();

				// Verificação de campos obrigatórios
				if (name.isEmpty() || telephone.isEmpty() || email.isEmpty() || address.isEmpty() || birthdate.isEmpty()
						|| children.equals("-")) {

					JOptionPane.showMessageDialog(null, "Please fill in all required fields before saving!",
							"Missing Information", JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Se tudo estiver ok, salva
				try {
					BookData obj = new BookData();
					obj.setId(Integer.parseInt(txtChange_ID.getText()));
					obj.setUsername(name);
					obj.setTelephone(telephone);
					obj.setEmail(email);
					obj.setAddress(address);
					obj.setBirthdate(birthdate);
					obj.setChildren(children);

					DbOperations editData = new DbOperations();
					editData.Edit(obj);

					dispose(); // Fecha a tela

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error editing data!\n" + ex, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEdit.setMnemonic('S');
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(505, 301, 152, 74);
		contentPane.add(btnEdit);
	}

	public void receive(String id, String name, String telephone, String email, String address, String birthdate,
			String children) {
		txtChange_ID.setText(id);
		txtChange_Name.setText(name);
		txtChange_Telephone.setText(telephone);
		txtChange_Email.setText(email);
		txtChange_Address.setText(address);
		txtChange_Birthdate.setText(birthdate);
		cmbChange_Children.setSelectedItem(children);
	}

}
