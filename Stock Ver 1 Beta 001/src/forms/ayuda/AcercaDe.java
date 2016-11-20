package forms.ayuda;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class AcercaDe {

	/**
	 * @wbp.parser.entryPoint
	 */
	public JInternalFrame crearVentanaAcercaDe() {
		JInternalFrame ventanaAcercaDe = new JInternalFrame("Acerca De", false, true, false);

		JPanel panel = new JPanel();
		ventanaAcercaDe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblVersion = new JLabel("Stock Version 1.0 Beta 001");
		lblVersion.setBounds(86, 11, 166, 35);
		panel.add(lblVersion);

		JLabel lblMail = new JLabel("tebezariel@gmail.com");
		lblMail.setBounds(86, 57, 166, 35);
		panel.add(lblMail);

		ventanaAcercaDe.setVisible(true);
		ventanaAcercaDe.setSize(365, 158);
		return ventanaAcercaDe;

	}
}
