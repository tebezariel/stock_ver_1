package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import forms.login.Login;

public class MenuArchivo {

	private JMenuItem itemDesconectar;

	public JMenu crearMenuArchivo() {
		JMenu menuArchivo = new JMenu("Archivo");

		/* inicio item Desconectar */
		itemDesconectar = new JMenuItem("Desconectar");
		itemDesconectar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// desconectamos todas las ventanas visibles

				//cargamos el mensaje
				JOptionPane.showMessageDialog(null, "Sesion Cerrada");
				
				// cargamos el frame de login
				forms.login.Login log = new Login();
				principal.Principal.escritorio.add(log.crearVentanaLogin());

			}
		});
		menuArchivo.add(itemDesconectar);
		/* fin item Desconectar */

		/* inicio item Salir */
		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuArchivo.add(itemSalir);
		/* fin item Salir */

		return menuArchivo;
	}

}
