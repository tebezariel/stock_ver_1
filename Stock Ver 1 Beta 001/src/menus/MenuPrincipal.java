package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal {

	private JMenuBar menuBar;

	public JMenuBar crearMenuPrincipal() {
		menuBar = new JMenuBar();

		/* inicio menu Archivo */
		menus.MenuArchivo menuArchivo = new MenuArchivo();
		menuBar.add(menuArchivo.crearMenuArchivo());
		/* fin menu Archivo */

		/* inicio menu Stock */
		menus.MenuStock menuStock = new MenuStock();
		menuBar.add(menuStock.crearMenuStock());
		/* fin menu Stock */

		/* inicio menu Mantenimiento */
		menus.MenuMantenimiento menuMantenimiento = new MenuMantenimiento();
		menuBar.add(menuMantenimiento.crearMenuMantenimiento());
		/* fin menu Mantenimiento */

		/* inicio menu Caja */
		menus.MenuCaja menuCaja = new MenuCaja();
		menuBar.add(menuCaja.crearMenuCaja());
		/* fin menu Caja */

		/* inicio menu Informes */
		menus.MenuInformes menuInformes = new MenuInformes();
		menuBar.add(menuInformes.crearMenuInformes());
		/* fin menu Informes */

		/* inicio menu Ayuda */
		menus.MenuAyuda menuAyuda = new MenuAyuda();
		menuBar.add(menuAyuda.crearMenuAyuda());
		/* fin menu Ayuda */

		return menuBar;

	}

	public JMenuBar crearMenuLogin() {
		menuBar = new JMenuBar();

		JMenu menuArchivo = new JMenu("Archivo");

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

		menuBar.add(menuArchivo);
		return menuBar;
	}

}
