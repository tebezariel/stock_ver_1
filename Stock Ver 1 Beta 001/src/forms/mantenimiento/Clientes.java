package forms.mantenimiento;

import javax.swing.JInternalFrame;

public class Clientes {

	JInternalFrame ventanaClientes;

	public JInternalFrame crearVentanaClientes() {
		ventanaClientes = new JInternalFrame("Clientes", false, true, false);

		
		ventanaClientes.setSize(300, 300);
		ventanaClientes.setVisible(true);
		return ventanaClientes;

	}

}
