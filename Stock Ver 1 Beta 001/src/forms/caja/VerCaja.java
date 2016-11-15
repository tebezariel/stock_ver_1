package forms.caja;

import javax.swing.JInternalFrame;

public class VerCaja {

	JInternalFrame ventanaVerCaja;

	public JInternalFrame crearVentanaVerCaja() {
		ventanaVerCaja = new JInternalFrame("Ver Caja", true, true, true);

		return ventanaVerCaja;
	}

}
