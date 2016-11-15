package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.caja.VerCajaPorNumero;

public class MenuCaja {

	JMenuItem itemCerrarCaja;
	
	public JMenu crearMenuCaja() {
		JMenu menuCaja = new JMenu("Caja");

		/* inicio item Cargar Gastos */
		JMenuItem itemCargarGastos = new JMenuItem("Cargar Gastos");
		menuCaja.add(itemCargarGastos);
		/* fin item Cargar Gastos */

		/* inicio item Otros Ingresos */
		JMenuItem itemOtrosIngresos = new JMenuItem("Otros Ingresos");
		menuCaja.add(itemOtrosIngresos);
		/* fin item Otros Ingresos */

		/* inicio item Ver Caja */
		JMenuItem itemVerCaja = new JMenuItem("Ver Caja");
		menuCaja.add(itemVerCaja);
		/* fin item Ver Caja */

		/* inicio item Ver Caja por Numero */
		JMenuItem itemVerCajaPorNumero = new JMenuItem("Ver Caja por Numero");
		itemVerCajaPorNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.caja.VerCajaPorNumero vercajanumero = new VerCajaPorNumero();
				principal.Principal.escritorio.add(vercajanumero.crearVentanaVerCajaPorNumero());
			}
		});
		menuCaja.add(itemVerCajaPorNumero);
		/* fin item Ver Caja por Numero */

		
		/* inicio item Cerrar Caja */
		itemCerrarCaja = new JMenuItem("Cerrar Caja");
		itemCerrarCaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuCaja.add(itemCerrarCaja);
		
		/* fin item Cerrar Caja*/
		return menuCaja;
	}
}
