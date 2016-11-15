package forms.caja;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CerrrarCaja {
JInternalFrame ventanaCerrarCaja;
private JTextField textField_NumeroDeCaja;
private JTextField textField_Responsable;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JInternalFrame crearVentanaCerrarCaja(){
		ventanaCerrarCaja = new JInternalFrame("Cerar Caja", false, true, false);
		
		JPanel panel = new JPanel();
		
		
		
		
		
		
		
		ventanaCerrarCaja.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_NumeroDeCaja = new JLabel("Numero de Caja");
		lbl_NumeroDeCaja.setBounds(27, 8, 77, 14);
		panel.add(lbl_NumeroDeCaja);
		
		textField_NumeroDeCaja = new JTextField();
		textField_NumeroDeCaja.setBounds(109, 5, 86, 20);
		textField_NumeroDeCaja.setEditable(false);
		panel.add(textField_NumeroDeCaja);
		textField_NumeroDeCaja.setColumns(10);
		
		JLabel lbl_Responsable = new JLabel("Responsable");
		lbl_Responsable.setBounds(35, 33, 61, 14);
		panel.add(lbl_Responsable);
		
		textField_Responsable = new JTextField();
		textField_Responsable.setBounds(101, 30, 86, 20);
		panel.add(textField_Responsable);
		textField_Responsable.setColumns(10);
		
		JLabel lbl_Obervaciones = new JLabel("Observaciones");
		lbl_Obervaciones.setBounds(10, 80, 71, 14);
		panel.add(lbl_Obervaciones);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(74, 115, 113, 94);
		textArea.setRows(5);
		panel.add(textArea);
		
		
		
		ventanaCerrarCaja.setVisible(true);
		return ventanaCerrarCaja;
	}
	
}
