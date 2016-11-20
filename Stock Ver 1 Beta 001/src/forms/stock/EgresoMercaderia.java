package forms.stock;

import javax.swing.JInternalFrame;

public class EgresoMercaderia {

	JInternalFrame ventanaEgresoMercaderia;

	public JInternalFrame crearVentanaEgresoMercaderia() {
		ventanaEgresoMercaderia = new JInternalFrame("Egreso de Mercaderia", false, true, false);

		ventanaEgresoMercaderia.setSize(300, 300);
		ventanaEgresoMercaderia.setVisible(true);

		return ventanaEgresoMercaderia;
	}

}
