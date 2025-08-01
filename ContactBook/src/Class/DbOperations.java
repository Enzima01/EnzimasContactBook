package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DbOperations {

	private Connection connection;

	public DbOperations() {
		this.connection = new MySQL_Connection().getConnection();

	}

	public void Register(BookData obj) {

		try {
			String sqlInfo = "INSERT INTO register_table(username, telephone, email, address, birthdate, children) "
		               + "VALUES (?, ?, ?, ?, ?, ?)";


			PreparedStatement recordInfo = connection.prepareStatement(sqlInfo);
			recordInfo.setString(1, obj.getUsername());
			recordInfo.setString(2, obj.getTelephone());
			recordInfo.setString(3, obj.getEmail());
			recordInfo.setString(4, obj.getAddress());
			recordInfo.setString(5, obj.getBirthdate());
			recordInfo.setString(6, obj.getChildren());

			recordInfo.execute();

			recordInfo.close();

			JOptionPane.showMessageDialog(null, "Data registered successfully!", "Data Registered",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error registering Data!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public List<BookData> listItens() {

		try {
			List<BookData> list = new ArrayList<>();
			String sqlDataBase = "Select * from register_table";
			PreparedStatement readInfo = connection.prepareStatement(sqlDataBase);
			
			ResultSet result = readInfo.executeQuery();
			
			while(result.next()) {
				BookData line = new BookData();
				line.setId(result.getInt("id"));
				line.setUsername(result.getString("username"));
				line.setTelephone(result.getString("telephone"));
				line.setEmail(result.getString("email"));
				line.setAddress(result.getString("address"));
				line.setBirthdate(result.getString("birthdate"));
				line.setChildren(result.getString("children"));
				
				list.add(line);
			}
			
			return list;
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Error loading data!: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}

		return null;
	}
	
	public List<BookData> FilterData(String name){
		
		try {
			List<BookData> list = new ArrayList<>();
			String sqlDataBase = "Select * from register_table where username like ?";
			PreparedStatement readInfo = connection.prepareStatement(sqlDataBase);
			
			readInfo.setString(1, name);
			
			ResultSet result = readInfo.executeQuery();
			
			while(result.next()) {
				BookData line = new BookData();
				line.setId(result.getInt("id"));
				line.setUsername(result.getString("username"));
				line.setTelephone(result.getString("telephone"));
				line.setEmail(result.getString("email"));
				line.setAddress(result.getString("address"));
				line.setBirthdate(result.getString("birthdate"));
				line.setChildren(result.getString("children"));
				
				list.add(line);
			}
			
			return list;
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Error loading data!: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
	
	public void Edit(BookData obj) {
		
		try {
			String sqlInfo = "UPDATE register_table set username=?, telephone=?, email=?, address=?, birthdate=?, children=?"
		               + "WHERE id=?";


			PreparedStatement recordInfo = connection.prepareStatement(sqlInfo);
			recordInfo.setString(1, obj.getUsername());
			recordInfo.setString(2, obj.getTelephone());
			recordInfo.setString(3, obj.getEmail());
			recordInfo.setString(4, obj.getAddress());
			recordInfo.setString(5, obj.getBirthdate());
			recordInfo.setString(6, obj.getChildren());
			recordInfo.setInt(7, obj.getId());

			recordInfo.execute();

			recordInfo.close();

			JOptionPane.showMessageDialog(null, "Data edited successfully!", "Data Edit",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error editing Data!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void Delete(BookData obj) {
		
		try {
			String sqlInfo = "DELETE from register_table WHERE id=?";


			PreparedStatement deleteInfo = connection.prepareStatement(sqlInfo);
			
			deleteInfo.setInt(1, obj.getId());

			deleteInfo.execute();

			deleteInfo.close();

			JOptionPane.showMessageDialog(null, "Data deleted successfully!", "Data Registered",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error deleting Data!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
