package principal;

import java.awt.Color;
import java.sql.Date;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import menus.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Principal {

	public static JDesktopPane escritorio;
	public static JFrame frame;
	private JLabel lbl_IDFecha;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void crearVentanaPrincipal() {
		frame = new JFrame("Ventana Principal");

		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.BLUE);

		frame.getContentPane().add(escritorio);

		// look and Feel
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.pack();

		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	protected String obtenerFecha() {
		// String devolverFecha ="";

		java.util.Date fecha = new Date(0);
		// System.out.println (fecha.getDay());
		// System.out.println (fecha.getMonth());
		// devolverFecha = String.valueOf((fecha.getDay()));

		return fecha.toString();
	}

}
