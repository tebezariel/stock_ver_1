package forms.ayuda;

import javax.swing.JInternalFrame;

public class Preferencias {

	JInternalFrame ventanaPreferencias;

	public JInternalFrame crearVentanaPreferencias() {
		ventanaPreferencias = new JInternalFrame("Preferencias", true, true, true);

		
		ventanaPreferencias.setSize(300, 300);
		ventanaPreferencias.setVisible(true);
		return ventanaPreferencias;
	}

}
