package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class herramientas {

	conectar con;

	public Boolean verificarLogin(String user, String contraseña) {
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

	public String simpleUpdateSQL(String sql) {
		con = new conectar();
		Connection reg = con.conexion();
		String devolver = "";
		try {
			Statement st = reg.createStatement();
			int update = st.executeUpdate(sql);

			if (update == 1) {

				// System.out.println("actualizado");
			}

		} catch (Exception e) {
			devolver = e.toString();
		}
		return devolver;
	}

	public String simpleDeleteSQL(String sql, String borrar) {
		String devolver = "";
		con = new conectar();
		Connection reg = con.conexion();
		try {
			// String query = "delete from users where id = ?";
			PreparedStatement preparedStmt = reg.prepareStatement(sql);
			preparedStmt.setString(1, borrar);
			preparedStmt.execute();
			reg.close();

		} catch (Exception e) {
			devolver = e.toString();
		}
		return devolver;
	}

	public Boolean llenarTablaDesdeBaseDeDatos(String sql, DefaultTableModel modelo) {
		con = new conectar();
		Connection reg = con.conexion();
		Boolean bandera = false;
		try {
			Statement st = reg.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// String col = rs.getMetaData().getColumnLabel();

			Object[] datos = new Object[numberOfColumns];

			while (rs.next()) {
				for (int i = 0; i < numberOfColumns; i++) {
					datos[i] = rs.getObject(i + 1);
					bandera = true;
				}
				modelo.addRow(datos);
			}
			st.close();
		} catch (SQLException ex) {
			Logger.getLogger(herramientas.class.getName()).log(Level.SEVERE, null, ex);
		}
		return bandera;
	}

	public Object[] SelectMYSQL(String sql) {

		utilidades.conectar con = new conectar();
		Connection reg = con.conexion();
		Object[] datos = null;
		try {
			Statement pst = reg.createStatement();
			ResultSet rs = pst.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();
			
			datos = new Object[numberOfColumns];

			int i = 0;
			while (rs.next()) {
				datos[i] =  rs.getObject(i + 1);
				i++;
			}

			reg.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return datos;
	}

	public void simpleSelectMYSQL(String tabla, Object[] datosTabla, Object[] datosAIngresar) {
		con = new conectar();
		Connection reg = con.conexion();

		String sql = preparaSQLSentencia(tabla, datosTabla);

		try {
			PreparedStatement pst = reg.prepareStatement(sql);
			// System.out.println("sql: " + sql);
			int sum = 1;
			for (Object object : datosAIngresar) {
				if (object instanceof String) {
					pst.setString(sum, object.toString());
				} else if (object instanceof Integer) {
					pst.setInt(sum, (Integer) object);
				}
				sum++;
			}
			int n = pst.executeUpdate();
			if (n > 0) {
				// JOptionPane.showMessageDialog(null, "Registrado con Exito");
			}

		} catch (SQLException ex) {
			Logger.getLogger(herramientas.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void borrarTodaLaTabla(DefaultTableModel dm) {

		int rowCount = dm.getRowCount();
		// Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);

		}
	}

	protected String preparaSQLSentencia(String tabla, Object[] datosTabla) {
		String cantidadDeSignosDePreguntas = "";
		String cantidadDeDatosEnTabla = "";

		for (Object object : datosTabla) {
			cantidadDeDatosEnTabla = cantidadDeDatosEnTabla + object + ",";
		}
		cantidadDeDatosEnTabla = cantidadDeDatosEnTabla.substring(0, cantidadDeDatosEnTabla.length() - 1);

		for (int i = 0; i < datosTabla.length; i++) {
			cantidadDeSignosDePreguntas = cantidadDeSignosDePreguntas + "?,";
		}

		cantidadDeSignosDePreguntas = cantidadDeSignosDePreguntas.substring(0,
				cantidadDeSignosDePreguntas.length() - 1);

		String sql = "INSERT INTO " + tabla + " (" + cantidadDeDatosEnTabla + ")VALUES (" + cantidadDeSignosDePreguntas
				+ " )";

		return sql;
	}

}
