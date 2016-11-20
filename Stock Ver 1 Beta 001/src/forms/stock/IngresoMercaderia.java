package forms.stock;

import javax.swing.JInternalFrame;

public class IngresoMercaderia {

	JInternalFrame ventanaIngresoMercaderia;

	public JInternalFrame crearVentanaIngresoMercaderia() {
		ventanaIngresoMercaderia = new JInternalFrame("Ingreso de Mercaderia", false, true, false);

		ventanaIngresoMercaderia.setSize(300, 300);
		ventanaIngresoMercaderia.setVisible(true);
		return ventanaIngresoMercaderia;
	}

}
