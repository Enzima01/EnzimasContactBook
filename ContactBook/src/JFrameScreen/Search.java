package JFrameScreen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Class.BookData;
import Class.DbOperations;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;

public class Search extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuery;
	private JTextField txtItenQuantity;
	private JTable bookTable;

	EditData sendText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Search.class.getResource("/Images/lupa.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				LoadItens();

			}
		});
		setTitle("Search");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

		int width = 800;
		int height = 540;

		setBounds(center.x - width / 2, center.y - height / 2, 800, 540);

		setContentPane(contentPane);

		this.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
			public void windowGainedFocus(java.awt.event.WindowEvent e) {
				LoadItens(); // atualiza os dados toda vez que a tela recebe foco
			}

			public void windowLostFocus(java.awt.event.WindowEvent e) {
				// Não precisa fazer nada aqui
			}
		});

		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(455, 45, 139, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Register openScreen = new Register();
				openScreen.setVisible(true);

			}
		});
		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon(Search.class.getResource("/Images/new.png")));
		btnNewButton.setMnemonic('N');
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Type to Search:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 150, 33);
		contentPane.add(lblNewLabel);

		txtQuery = new JTextField();
		txtQuery.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String name = "%" + txtQuery.getText() + "%";

				DbOperations itens = new DbOperations();
				List<BookData> itensList = itens.FilterData(name);

				DefaultTableModel data = (DefaultTableModel) bookTable.getModel();

				data.setNumRows(0);

				for (BookData line : itensList) {
					data.addRow(new Object[] { line.getId(), line.getUsername(), line.getTelephone(), line.getEmail(),
							line.getAddress(), line.getBirthdate(), line.getChildren() });
				}
				countTableLines();
			}
		});

		txtQuery.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtQuery.setBounds(10, 43, 411, 38);
		contentPane.add(txtQuery);
		txtQuery.setColumns(10);

		txtItenQuantity = new JTextField();
		txtItenQuantity.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtItenQuantity.setColumns(10);
		txtItenQuantity.setBounds(10, 92, 226, 43);
		txtItenQuantity.setEditable(false);
		txtItenQuantity.setBackground(new Color(240, 240, 240));
		contentPane.add(txtItenQuantity);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 146, 764, 344);
		contentPane.add(scrollPane);

		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.getClickCount() == 2) {
					DefaultTableModel model = (DefaultTableModel) bookTable.getModel();

					int selectLineNumber = bookTable.getSelectedRow();

					if (sendText == null) {

						sendText = new EditData();
						sendText.setVisible(true);
						sendText.receive(model.getValueAt(selectLineNumber, 0).toString(),
								model.getValueAt(selectLineNumber, 1).toString(),
								model.getValueAt(selectLineNumber, 2).toString(),
								model.getValueAt(selectLineNumber, 3).toString(),
								model.getValueAt(selectLineNumber, 4).toString(),
								model.getValueAt(selectLineNumber, 5).toString(),
								model.getValueAt(selectLineNumber, 6).toString());
					} else {

						sendText.setState(EditData.NORMAL);
						sendText.setVisible(true);
						sendText.receive(model.getValueAt(selectLineNumber, 0).toString(),
								model.getValueAt(selectLineNumber, 1).toString(),
								model.getValueAt(selectLineNumber, 2).toString(),
								model.getValueAt(selectLineNumber, 3).toString(),
								model.getValueAt(selectLineNumber, 4).toString(),
								model.getValueAt(selectLineNumber, 5).toString(),
								model.getValueAt(selectLineNumber, 6).toString());
					}

				}

			}
		});
		bookTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Telephone", "E-mail", "Address", "Birth Date", "Children" }));

		bookTable.setRowHeight(30);
		bookTable.setDefaultEditor(Object.class, null);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(Search.class.getResource("/Images/excluir.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel data = (DefaultTableModel) bookTable.getModel();

				int answer = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete the selected register?", "Delete Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (answer == 1) {
					return;
				} else {

					try {

						int selectLineNumber = bookTable.getSelectedRow();

						BookData obj = new BookData();

						int id = Integer.parseInt(data.getValueAt(selectLineNumber, 0).toString());
						obj.setId(id);

						DbOperations deleteData = new DbOperations();
						deleteData.Delete(obj);

						LoadItens();

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "There is no register selected!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnDelete.setMnemonic('D');
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(607, 45, 139, 38);
		contentPane.add(btnDelete);

		/*
		 * JButton btnNewButton_1_1 = new JButton("Export");
		 * btnNewButton_1_1.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { } }); btnNewButton_1_1.setIcon(new
		 * ImageIcon(Search.class.getResource("/Images/excel.png")));
		 * btnNewButton_1_1.setMnemonic('E'); btnNewButton_1_1.setFont(new
		 * Font("Tahoma", Font.PLAIN, 20)); btnNewButton_1_1.setBounds(530, 94, 139,
		 * 38); contentPane.add(btnNewButton_1_1);
		 */

		LoadItens();
	}

	public void LoadItens() {

		DbOperations itens = new DbOperations();
		List<BookData> itensList = itens.listItens();

		DefaultTableModel data = (DefaultTableModel) bookTable.getModel();

		data.setNumRows(0);

		for (BookData line : itensList) {
			data.addRow(new Object[] { line.getId(), line.getUsername(), line.getTelephone(), line.getEmail(),
					line.getAddress(), line.getBirthdate(), line.getChildren() });
		}

		bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(86);
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);

		countTableLines();

	}

	public void countTableLines() {
		int qtdLines = bookTable.getRowCount();
		txtItenQuantity.setText("Total Registers: " + Integer.toString(qtdLines));

	}
}
