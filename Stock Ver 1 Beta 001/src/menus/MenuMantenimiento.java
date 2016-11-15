package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.mantenimiento.Articulos;

public class MenuMantenimiento {

	public JMenu crearMenuMantenimiento() {
		JMenu menuMantenimiento = new JMenu("Mantenimiento");
		/* inicio item Articulos */
		JMenuItem itemArticulos = new JMenuItem("Articulos");
		itemArticulos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.mantenimiento.Articulos articulos = new Articulos();
				principal.Principal.escritorio.add(articulos.crearVentanaArticulos());
			}
		});

		menuMantenimiento.add(itemArticulos);
		/* fin item Articulos */

		/* inicio item Lista de Precios */

		JMenuItem itemListaDePrecios = new JMenuItem("Lista de Precios");

		menuMantenimiento.add(itemListaDePrecios);
		/* fin item Lista de Precios */

		return menuMantenimiento;
	}

}
