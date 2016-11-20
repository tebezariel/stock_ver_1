package forms.mantenimiento;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import utilidades.herramientas;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import utilidades.herramientas;

public class ListaDePrecios {

	JInternalFrame ventanaListaDePrecios;
	JPanel panel;
	JTable tabla;
	JButton btn_Agregar, btn_Eliminar;
	DefaultTableModel modelo, modelo2;
	public Object pasarvalor;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JInternalFrame crearVentanaListaDePrecios() {
		ventanaListaDePrecios = new JInternalFrame("Lista de Precios", false, true, false);
		panel = new JPanel();

		ventanaListaDePrecios.getContentPane().add(panel);
		panel.setLayout(null);

		modelo = new DefaultTableModel(null, new String[] { "Descripcion" });
		tabla = new JTable(modelo);
		tabla.setBounds(50, 50, 50, 50);

		tabla.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Object valorSeleccionado = modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
				//System.out.println("selecionado:" + valorSeleccionado);
				pasarvalor = valorSeleccionado;
			}
		});

		tabla.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Apéndice de método generado automáticamente
				try {
					Object valorNuevo = modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
					if (null != pasarvalor) {
						utilidades.herramientas herr = new herramientas();
						String sql = "UPDATE tb_listadeprecios SET descripcion= \"" + valorNuevo
								+ "\" WHERE descripcion= \"" + pasarvalor + "\"";

						String update = herr.simpleUpdateSQL(sql);
					
						if(!update.equals(null)){
							JOptionPane.showMessageDialog(null, "Valor actualizado: " + valorNuevo);
						}
						else{
							JOptionPane.showMessageDialog(null, "Error al Actualizar: " + update);
						}						
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		utilidades.herramientas herr = new herramientas();
		String sql = "SELECT descripcion FROM stock.tb_listadeprecios";
		herr.llenarTablaDesdeBaseDeDatos(sql, modelo);

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 245, 149);
		panel.add(scrollPane);

		btn_Agregar = new JButton("Agregar");
		btn_Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				utilidades.herramientas herr = new herramientas();
				String valorCargar = "nuevo" + String.valueOf((Math.random()));
				
				herr.simpleSelectMYSQL("stock.tb_listadeprecios", new String[] { "descripcion" },
						new String[] { valorCargar });
				modelo.addRow(new String[] { valorCargar});
			}
		});
		panel.add(btn_Agregar);
		btn_Agregar.setBounds(10, 171, 77, 39);

		btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String delete  = herr.simpleDeleteSQL("Delete FROM stock.tb_listadeprecios WHERE descripcion= ?", pasarvalor.toString());
				if(!delete.equals(null)){
					modelo.removeRow(tabla.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Item Borrado: " + pasarvalor);
				}else{
					JOptionPane.showMessageDialog(null, "Error al Borrar: " + delete);
				}
				tabla.repaint();
			}
		});
		panel.add(btn_Eliminar);
		btn_Eliminar.setBounds(101, 171, 77, 39);

		panel.add(scrollPane);

		ventanaListaDePrecios.setSize(286, 260);
		ventanaListaDePrecios.setVisible(true);
		return ventanaListaDePrecios;
	}

}
