package menus;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.ayuda.AcercaDe;

public class MenuAyuda {

	public JMenu crearMenuAyuda() {

		JMenu menuAyuda = new JMenu("Ayuda");
		// Inicio Item Acerca De
		JMenuItem itemAcercaDe = new JMenuItem("Acerca De");
		itemAcercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.ayuda.AcercaDe acercaDe = new AcercaDe();
				principal.Principal.escritorio.add(acercaDe.crearVentanaAcercaDe());
			}
		});

		menuAyuda.add(itemAcercaDe);
		// Fin Itema Acerca De

		return menuAyuda;
	}

}
