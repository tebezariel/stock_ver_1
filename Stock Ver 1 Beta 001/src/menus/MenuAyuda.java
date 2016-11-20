package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import forms.ayuda.AcercaDe;
import forms.ayuda.Preferencias;

public class MenuAyuda {

	JMenuItem itemAcercaDe, itemPreferencias;
	
	
	public JMenu crearMenuAyuda() {

		JMenu menuAyuda = new JMenu("Ayuda");
		// inicio Item Acerca De
		itemAcercaDe = new JMenuItem("Acerca De");
		itemAcercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forms.ayuda.AcercaDe acercaDe = new AcercaDe();
				principal.Principal.escritorio.add(acercaDe.crearVentanaAcercaDe());
			}
		});

		menuAyuda.add(itemAcercaDe);
		// fin Item Acerca De

		// inicio item Preferencias

		itemPreferencias = new JMenuItem("Preferencias");
		itemPreferencias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				forms.ayuda.Preferencias preferencias = new Preferencias();
				principal.Principal.escritorio.add(preferencias.crearVentanaPreferencias());
				
				
			}
		});

		menuAyuda.add(itemPreferencias);

		// fin item Preferencias

		return menuAyuda;
	}

}
