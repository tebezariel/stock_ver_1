package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.informes.VerCajaPorNumero;

public class MenuCaja {

	JMenuItem itemCerrarCaja, itemGastos, itemIngresos, itemCobrarCuenta;
	
	public JMenu crearMenuCaja() {
		JMenu menuCaja = new JMenu("Caja");

		/* inicio menu Irregularidades*/
		JMenu menuIrregularidades = new JMenu("Cargar Irregularidades");
		menuCaja.add(menuIrregularidades);
				
		/* inicio item Cargar Gastos */
		itemGastos = new JMenuItem("Gastos");
		menuIrregularidades.add(itemGastos);
		/* fin item Cargar Gastos */

		/* inicio item Otros Ingresos */
		itemIngresos = new JMenuItem("Ingresos");
		menuIrregularidades.add(itemIngresos);
		/* fin item Otros Ingresos */

		/* fin menu irregularidades*/
		
		/* inicio item Ver Caja */
		JMenuItem itemVerCaja = new JMenuItem("Ver Caja");
		menuCaja.add(itemVerCaja);
		/* fin item Ver Caja */


		// inicio item Cobrar Cuenta 
		
		itemCobrarCuenta = new JMenuItem("Cobrar Cuenta Corriente");
		itemCobrarCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
		
		
		menuCaja.add(itemCobrarCuenta);
		// fin item Cobrar Cuenta
		
		
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
