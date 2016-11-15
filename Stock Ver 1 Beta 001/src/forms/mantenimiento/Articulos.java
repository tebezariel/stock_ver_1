package forms.mantenimiento;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Articulos {
	private JLabel lbl_CodigoArticulo, lbl_Descripcion;
	private JPanel panel;
	private JTextField textField_Codigo;
	private JTextField textField_Descripcion;
	private JTable table;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JInternalFrame crearVentanaArticulos() {
		JInternalFrame ventanaArticulos = new JInternalFrame("Articulos", false, true, false);
		panel = new JPanel();
		panel.setLayout(null);

		lbl_CodigoArticulo = new JLabel("Codigo");
		lbl_CodigoArticulo.setBounds(36, 5, 54, 14);
		panel.add(lbl_CodigoArticulo);

		lbl_Descripcion = new JLabel("Descripcion");
		lbl_Descripcion.setBounds(36, 33, 89, 14);
		panel.add(lbl_Descripcion);
		
		textField_Codigo = new JTextField();
		textField_Codigo.setBounds(135, 5, 86, 20);
		panel.add(textField_Codigo);
		textField_Codigo.setColumns(10);
		
		textField_Descripcion = new JTextField();
		textField_Descripcion.setBounds(135, 33, 86, 20);
		panel.add(textField_Descripcion);
		textField_Descripcion.setColumns(10);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Precio", "Porcentaje", "Lista Descripcion"
			}
		));
		table.setBounds(50, 50, 50, 50);
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 71, 352, 163);
		panel.add(scrollPane);
				
		
		ventanaArticulos.getContentPane().add(panel);

		ventanaArticulos.setSize(455, 299);
		ventanaArticulos.setVisible(true);
		return ventanaArticulos;
	}
}
