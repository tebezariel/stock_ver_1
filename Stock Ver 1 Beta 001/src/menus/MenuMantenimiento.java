package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.mantenimiento.Articulos;
import forms.mantenimiento.Clientes;
import forms.mantenimiento.ListaDePrecios;
import forms.mantenimiento.Proveedores;

public class MenuMantenimiento {
	JMenu menuMantenimiento;
	JMenuItem itemArticulos, itemListaDePrecios, itemClientes, itemProveedores;

	public JMenu crearMenuMantenimiento() {
		menuMantenimiento = new JMenu("Mantenimiento");
		/* inicio item Articulos */
		itemArticulos = new JMenuItem("Articulos");
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

		itemListaDePrecios = new JMenuItem("Lista de Precios");
		itemListaDePrecios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.mantenimiento.ListaDePrecios listaDePrecios = new ListaDePrecios();
				principal.Principal.escritorio.add(listaDePrecios.crearVentanaListaDePrecios());
			}
		});
		menuMantenimiento.add(itemListaDePrecios);
		/* fin item Lista de Precios */

		// inicio item Clientes

		itemClientes = new JMenuItem("Clientes");
		itemClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.mantenimiento.Clientes clientes = new Clientes();
				principal.Principal.escritorio.add(clientes.crearVentanaClientes());
			}
		});

		menuMantenimiento.add(itemClientes);

		// fin item Clientes

		// inicio item Proveedores

		itemProveedores = new JMenuItem("Proveedores");
		itemProveedores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.mantenimiento.Proveedores proveedores = new Proveedores();
				principal.Principal.escritorio.add(proveedores.crearVentanaProveedores());
			}
		});

		menuMantenimiento.add(itemProveedores);

		// fin item Proovedores

		return menuMantenimiento;
	}

}
