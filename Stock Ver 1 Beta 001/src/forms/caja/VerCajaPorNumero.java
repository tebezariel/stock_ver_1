package forms.caja;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VerCajaPorNumero {

	JInternalFrame ventanaVerCajaPorNumero;
	private JTextField textField_NumeroCaja;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JInternalFrame crearVentanaVerCajaPorNumero(){
		ventanaVerCajaPorNumero = new JInternalFrame("Ver Caja por Numero", false, true, false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNumeroDeCaja = new JLabel("Numero de Caja:");
		panel.add(lblNumeroDeCaja);
		
		textField_NumeroCaja = new JTextField();
		panel.add(textField_NumeroCaja);
		textField_NumeroCaja.setColumns(10);
		
		JButton btn_VerCaja = new JButton("Ver Caja");
		panel.add(btn_VerCaja);
		
		
		ventanaVerCajaPorNumero.getContentPane().add(panel);

		ventanaVerCajaPorNumero.setVisible(true);
		ventanaVerCajaPorNumero.setSize(303, 60);
		
		return ventanaVerCajaPorNumero;
	}
}
