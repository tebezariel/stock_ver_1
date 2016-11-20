package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.informes.VerCajaPorNumero;

public class MenuInformes {

	JMenu menuInformes, menuCaja;

	JMenuItem itemCuentaCorriente, itemCajaporNumero, itemCajaporFecha;

	public JMenu crearMenuInformes() {
		menuInformes = new JMenu("Informes");

		// inicio item Cuenta Corriente
		itemCuentaCorriente = new JMenuItem("Cuenta Corriente");
		itemCuentaCorriente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});

		menuInformes.add(itemCuentaCorriente);
		// fin item Cuenta Corriente

		// inicio Menu Caja
		menuCaja = new JMenu("Caja");

		// inicio item Caja por Numero
		itemCajaporNumero = new JMenuItem("por Numero");
		itemCajaporNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.informes.VerCajaPorNumero vercajapornumero = new VerCajaPorNumero();
				principal.Principal.escritorio.add(vercajapornumero.crearVentanaVerCajaPorNumero());
			}
		});

		menuCaja.add(itemCajaporNumero);

		// fin item Caja por Numero

		// inicio item Caja por Fecha
		itemCajaporFecha = new JMenuItem("por Fecha");
		itemCajaporFecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});

		menuCaja.add(itemCajaporFecha);
		// fin item Caja por Fecha

		menuInformes.add(menuCaja);
		// fin Menu Caja

		return menuInformes;
	}

}
