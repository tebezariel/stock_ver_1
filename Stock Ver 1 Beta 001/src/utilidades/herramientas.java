package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class herramientas {

	conectar con;

	public Boolean login(String user, String contraseña) {
		con = new conectar();
		Boolean bandera = false;

		String sql = "SELECT usuario,contrasena FROM stock.tb_usuarios WHERE usuario = \"" + user + "\"";
		
		Connection reg = con.conexion();
		try {
			Statement st = reg.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				if (rs.getString("contrasena").equals(contraseña)) {

					bandera = true;

				}

			}
			st.close();
		} catch (SQLException ex) {
			Logger.getLogger(herramientas.class.getName()).log(Level.SEVERE, null, ex);
		}
		return bandera;
	}

}
