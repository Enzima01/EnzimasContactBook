package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQL_Connection {

    public Connection getConnection() {
       

        try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/YOUR URL", "YOUR USER", "YOUR PASSWORD");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Database driver not found: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
}
