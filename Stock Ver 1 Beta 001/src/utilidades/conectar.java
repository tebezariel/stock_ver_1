package utilidades;

import java.sql.*;

import javax.swing.JOptionPane;

public class conectar {
	Connection con = null;

	public Connection conexion() {
		try {
			// cargar nuestro driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/stock", "root", "1234");
			System.out.println("conexion establecida");
			// JOptionPane.showMessageDialog(null, "conexion establecida");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("err: " + e);
		}
		return con;
	}
}
