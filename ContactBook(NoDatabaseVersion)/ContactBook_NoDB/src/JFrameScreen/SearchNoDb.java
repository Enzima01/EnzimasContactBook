package JFrameScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Class.Person;
import Class.PersonRepository;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchNoDb extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuery;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchNoDb frame = new SearchNoDb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private JTable table;
	private DefaultTableModel tableModel;
	/**
	 * Create the frame.
	 */
	public SearchNoDb() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchNoDb.class.getResource("/Images/lupa.png")));
		setTitle("Search");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

		int width = 800;
		int height = 540;

		setBounds(center.x - width / 2, center.y - height / 2, 800, 540);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type to Search:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 150, 33);
		contentPane.add(lblNewLabel);
		
		txtQuery = new JTextField();
		txtQuery.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String searchTerm = txtQuery.getText().trim().toLowerCase();

		       
		        tableModel.setRowCount(0);

		        
		        for (Person person : PersonRepository.getAll()) {
		            if (person.getName().toLowerCase().contains(searchTerm)) {
		                tableModel.addRow(new Object[] {
		                    person.getId(),
		                    person.getName(),
		                    person.getTelephone(),
		                    person.getEmail(),
		                    person.getAddress(),
		                    person.getBirthDate(),
		                    person.getChildren()
		                });
		            }
		        }
		    }
		});
		txtQuery.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtQuery.setColumns(10);
		txtQuery.setBounds(10, 43, 411, 38);
		contentPane.add(txtQuery);
		
		textField_1 = new JTextField();
		textField_1.setText("Total Registers: 0");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setBounds(10, 92, 226, 43);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				RegisterNoDb register = new RegisterNoDb(SearchNoDb.this);
				register.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(SearchNoDb.class.getResource("/Images/new.png")));
		btnNewButton.setMnemonic('N');
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(455, 45, 139, 38);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(SearchNoDb.class.getResource("/Images/excluir.png")));
		btnDelete.setMnemonic('D');
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(607, 45, 139, 38);
		contentPane.add(btnDelete);
		
		
		
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setBounds(10, 150, 764, 340);
	        contentPane.add(scrollPane);
	        String[] columns = { "ID", "Name", "Telephone", "E-mail", "Address", "Birth Date", "Children" };
	        tableModel = new DefaultTableModel(columns, 0);
	        table = new JTable(tableModel);
	        table.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                if (e.getClickCount() == 2) {
	                    int row = table.getSelectedRow();
	                    int id = (int) table.getValueAt(row, 0);
	                    Person selected = PersonRepository.getById(id);
	                    EditDataNoDb editor = new EditDataNoDb(selected);
	                    editor.setVisible(true);
	                    editor.addWindowListener(new java.awt.event.WindowAdapter() {
	                        @Override
	                        public void windowClosed(java.awt.event.WindowEvent e) {
	                            refreshTable(); 
	                        }
	                    });
	                }
	            }
	        });
	        
	        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPane.setViewportView(table);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(150);
			table.getColumnModel().getColumn(5).setPreferredWidth(86);
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			
			
			
			
			table.setRowHeight(30);
			table.setDefaultEditor(Object.class, null);

			btnDelete.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        int row = table.getSelectedRow();

			        if (row == -1) {
			            JOptionPane.showMessageDialog(null, 
			                "Please select a contact to delete.", 
			                "No Selection", 
			                JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        int confirm = JOptionPane.showConfirmDialog(null, 
			            "Are you sure you want to delete this contact?", 
			            "Confirm Deletion", 
			            JOptionPane.YES_NO_OPTION);

			        if (confirm == JOptionPane.YES_OPTION) {
			            int id = (int) tableModel.getValueAt(row, 0);
			            PersonRepository.removePerson(PersonRepository.getById(id));
			            refreshTable();
			        }
			    }
			});
	    }

	    
	    
	public void refreshTable() {
	    tableModel.setRowCount(0);
	    for (Person p : PersonRepository.getAll()) {
	        tableModel.addRow(new Object[]{
	            p.getId(),
	            p.getName(),
	            p.getTelephone(),
	            p.getEmail(),
	            p.getAddress(),
	            p.getBirthDate(),
	            p.getChildren()
	        });
	    }
	    textField_1.setText("Total Registers: " + PersonRepository.getAll().size());
	}

	

	

}



