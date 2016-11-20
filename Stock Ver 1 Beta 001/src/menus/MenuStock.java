package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuStock {
	JMenu menuStock;
	JMenuItem itemIngresoMercaderia, itemEgresoMercaderia;

	public JMenu crearMenuStock() {
		menuStock = new JMenu("Stock");

		// inicio menu Ingreso Mercaderia

		itemIngresoMercaderia = new JMenuItem("Ingreso de Mercaderia");
		itemIngresoMercaderia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});

		menuStock.add(itemIngresoMercaderia);
		// fin menu Ingreso Mercaderia

		// inicio menu Egreso Mercaderia

		itemEgresoMercaderia = new JMenuItem("Egreso de Mercaderia");
		itemEgresoMercaderia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});

		menuStock.add(itemEgresoMercaderia);

		// fin menu Egreso Mercaderia

		return menuStock;
	}

}
