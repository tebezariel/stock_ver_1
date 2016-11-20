package forms.mantenimiento;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import utilidades.conectar;
import utilidades.herramientas;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Articulos {
	private JLabel lbl_CodigoArticulo, lbl_Descripcion;
	private JPanel panel;
	private JTextField textField_Codigo;
	private JTextField textField_Descripcion;
	private JTable tabla;
	DefaultTableModel modelo;
	utilidades.herramientas herr;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JInternalFrame crearVentanaArticulos() {
		herr = new herramientas();

		JInternalFrame ventanaArticulos = new JInternalFrame("Articulos", false, true, false);
		panel = new JPanel();
		panel.setLayout(null);

		lbl_CodigoArticulo = new JLabel("Codigo");
		lbl_CodigoArticulo.setBounds(36, 5, 54, 14);
		panel.add(lbl_CodigoArticulo);

		lbl_Descripcion = new JLabel("Descripcion");
		lbl_Descripcion.setBounds(177, 5, 89, 14);
		panel.add(lbl_Descripcion);

		textField_Codigo = new JTextField();
		textField_Codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					// borramos tabla
					herr.borrarTodaLaTabla(modelo);

					// cargamos el codigo a buscar
					int codigoABuscar = Integer.valueOf(textField_Codigo.getText());

					// funcion que trae el sql
					String sql = sentenciaSQL_ListarArticulos(codigoABuscar);

					// llenamos la tabla
					if (herr.llenarTablaDesdeBaseDeDatos(sql, modelo)) {

						// llenamos la descripcion
						String buscar = "SELECT descripcion FROM stock.tb_articulos where codigo=" + codigoABuscar + "";

						Object cargarDesc[] = herr.SelectMYSQL(buscar);
						
						textField_Descripcion.setText(cargarDesc[0].toString());
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Codigo Inexistente: " + codigoABuscar);
						textField_Codigo.setText(null);
						textField_Descripcion.setText(null);

					}
				}
			}
		});
		textField_Codigo.setBounds(77, 2, 86, 20);
		panel.add(textField_Codigo);
		textField_Codigo.setColumns(10);

		textField_Descripcion = new JTextField();
		textField_Descripcion.setBounds(266, 2, 86, 20);
		panel.add(textField_Descripcion);
		textField_Descripcion.setColumns(10);

		modelo = new DefaultTableModel();

		modelo.addColumn("Precio");
		modelo.addColumn("Lista Descripcion");

		tabla = new JTable(modelo);

		// tabla = new JTable(new DefaultTableModel(
		// new Object[][] {
		// },
		// new String[] {
		// "Precio", "Porcentaje", "Lista Descripcion"
		// }
		// ));
		tabla.setBounds(50, 50, 50, 50);

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(24, 30, 352, 163);
		panel.add(scrollPane);

		ventanaArticulos.getContentPane().add(panel);

		JButton btn_Agregar = new JButton("Agregar");
		btn_Agregar.setBounds(93, 204, 89, 23);
		panel.add(btn_Agregar);

		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setBounds(250, 204, 89, 23);
		panel.add(btn_Eliminar);

		ventanaArticulos.setSize(406, 270);
		ventanaArticulos.setVisible(true);
		return ventanaArticulos;
	}

	protected void sentenciaSQL_ObtenerDescripcion(int codigoABuscar) {
		utilidades.conectar con = new conectar();
		Connection reg = con.conexion();
		String sql = "SELECT descripcion FROM stock.tb_articulos where codigo=" + codigoABuscar + "";
		try {
			Statement pst = reg.createStatement();
			ResultSet rs = pst.executeQuery(sql);

			while (rs.next()) {
				textField_Descripcion.setText(rs.getString("descripcion"));
			}

			reg.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// return sql;
	}

	protected String sentenciaSQL_ListarArticulos(int codigoABuscar) {

		String sql = "SELECT lpd.precios, lp.descripcion from tb_listadeprecios_detalles AS lpd" + " inner join "
				+ "tb_listadeprecios as lp ON lp.id = lpd.id_listadeprecios " + " inner join "
				+ "tb_listadeprecios as precios ON precios.id=lpd.id_listadeprecios" + " inner join "
				+ "tb_articulos as art ON art.id = lpd.id_articulos" + " Where art.codigo =" + codigoABuscar + " ";

		return sql;
	}

}
