package forms.mantenimiento;

import javax.swing.JInternalFrame;

public class Proveedores {

	JInternalFrame ventanaProveedores;

	public JInternalFrame crearVentanaProveedores() {
		ventanaProveedores = new JInternalFrame("Proveedores", false, true, false);

		ventanaProveedores.setSize(300, 300);
		ventanaProveedores.setVisible(true);

		return ventanaProveedores;
	}

}
