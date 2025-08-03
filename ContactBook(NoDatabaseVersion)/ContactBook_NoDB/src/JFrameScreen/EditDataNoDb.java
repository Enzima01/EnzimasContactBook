package JFrameScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
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

import Class.Person;
import Class.PersonRepository;

public class EditDataNoDb extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDataNoDb frame = new EditDataNoDb(null);
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
	public EditDataNoDb(Person person) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditDataNoDb.class.getResource("/Images/editar.png")));
		setTitle("Edit Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

		int width = 700;
		int height = 440;

		setBounds(center.x - width / 2, center.y - height / 2, 700, 440);

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 684, 401);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 30, 25);
		contentPane_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 34, 218, 36);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 108, 462, 36);
		contentPane_1.add(textField_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 81, 67, 25);
		contentPane_1.add(lblName);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelephone.setBounds(10, 155, 111, 25);
		contentPane_1.add(lblTelephone);
		
		JFormattedTextField txtChange_Telephone = new JFormattedTextField((AbstractFormatter) null);
		txtChange_Telephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Telephone.setBounds(10, 179, 176, 36);
		contentPane_1.add(txtChange_Telephone);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(196, 179, 276, 36);
		contentPane_1.add(textField_2);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(196, 155, 67, 25);
		contentPane_1.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(10, 251, 462, 36);
		contentPane_1.add(textField_3);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(10, 226, 77, 25);
		contentPane_1.add(lblAddress);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBirthDate.setBounds(10, 298, 98, 25);
		contentPane_1.add(lblBirthDate);
		
		JFormattedTextField txtChange_Birthdate = new JFormattedTextField((AbstractFormatter) null);
		txtChange_Birthdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChange_Birthdate.setBounds(10, 321, 123, 36);
		contentPane_1.add(txtChange_Birthdate);
		
		JLabel lblChildren = new JLabel("Children:");
		lblChildren.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChildren.setBounds(165, 298, 98, 25);
		contentPane_1.add(lblChildren);
		
		JComboBox<String> cmbChange_Children = new JComboBox<String>();
		cmbChange_Children.setModel(new DefaultComboBoxModel<String>(new String[] {"-", "Yes", "No"}));
		cmbChange_Children.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbChange_Children.setBounds(164, 321, 83, 36);
		contentPane_1.add(cmbChange_Children);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String name = textField_1.getText().trim();
		        String telephone = txtChange_Telephone.getText().trim();
		        String email = textField_2.getText().trim();
		        String address = textField_3.getText().trim();
		        String birthdate = txtChange_Birthdate.getText().trim();
		        String children = cmbChange_Children.getSelectedItem().toString();

		        if (name.isEmpty() ||
		            telephone.contains("_") || telephone.isEmpty() ||
		            email.isEmpty() ||
		            address.isEmpty() ||
		            birthdate.contains("_") || birthdate.isEmpty() ||
		            children.equals("-")) {

		        	JOptionPane.showMessageDialog(null, "Please fill in all required fields before saving!",
							"Missing Information", JOptionPane.WARNING_MESSAGE);
		        }else {

		        person.setName(name);
		        person.setTelephone(telephone);
		        person.setEmail(email);
		        person.setAddress(address);
		        person.setBirthDate(birthdate);
		        person.setChildren(children);

		        PersonRepository.updatePerson(person);
		        JOptionPane.showMessageDialog(null, "Data edited successfully!", "Data Edit",
						JOptionPane.INFORMATION_MESSAGE);
		        dispose();
		        }
		    }
		});
		btnEdit.setIcon(new ImageIcon(EditDataNoDb.class.getResource("/Images/salvar.png")));
		btnEdit.setMnemonic('S');
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(505, 301, 152, 74);
		contentPane_1.add(btnEdit);
		
		 textField.setText(String.valueOf(person.getId()));
		    textField_1.setText(person.getName());
		    txtChange_Telephone.setText(person.getTelephone());
		    textField_2.setText(person.getEmail());
		    textField_3.setText(person.getAddress());
		    txtChange_Birthdate.setText(person.getBirthDate());
		    cmbChange_Children.setSelectedItem(person.getChildren());
		
	}

}
