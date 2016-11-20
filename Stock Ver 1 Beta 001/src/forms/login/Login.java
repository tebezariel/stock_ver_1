package forms.login;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import menus.MenuPrincipal;
import utilidades.herramientas;

import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Login {
	// private JPasswordField passwordField;

	private JLabel lblusuario, lblpassword;
	private JTextField textField_usuario;
	private JPasswordField passwordField;
	private JButton btnSalir;
	private JInternalFrame ventanaLogin;
	private int intentosLogin = 0;

	/**
	 * @wbp.parser.entryPoint
	 */

	public JInternalFrame crearVentanaLogin() {
		ventanaLogin = new JInternalFrame("Login", false, false, false);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		lblusuario = new JLabel("Ingrese un Usuario");
		lblusuario.setBounds(20, 35, 122, 14);
		panel.add(lblusuario);

		lblpassword = new JLabel("Contraseña");
		lblpassword.setBounds(20, 60, 91, 14);
		panel.add(lblpassword);

		textField_usuario = new JTextField();
		textField_usuario.setBounds(152, 35, 64, 14);
		panel.add(textField_usuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(151, 57, 65, 20);
		panel.add(passwordField);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(20, 104, 89, 23);
		panel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				verificarUsuario(textField_usuario, passwordField);
			}
		});

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(146, 104, 89, 23);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		ventanaLogin.getContentPane().add(panel);

		ventanaLogin.setVisible(true);
		ventanaLogin.setSize(284, 204);

		menus.MenuPrincipal pri = new MenuPrincipal();
		principal.Principal.frame.setJMenuBar(pri.crearMenuLogin());

		return ventanaLogin;
	}

	public void verificarUsuario(JTextField usuario, JPasswordField contraseña) {

		utilidades.herramientas herr = new herramientas();
		if (herr.verificarLogin(usuario.getText(), contraseña.getText())) {
			JOptionPane.showMessageDialog(null, "Bienvenido: " + usuario.getText());

			ventanaLogin.setVisible(false);

			menus.MenuPrincipal menu = new MenuPrincipal();
			principal.Principal.frame.setJMenuBar(menu.crearMenuPrincipal());

		} else {

			JOptionPane.showMessageDialog(null, "Datos Erroneos, intentelo nuevamente");
			passwordField.setText(null);
			textField_usuario.setText(null);
			intentosLogin++;

			if (intentosLogin == 3) {
				JOptionPane.showMessageDialog(null, "demasiados intentos, Saliendo del Sistema");
				System.exit(0);
			}

		}

		// return true;
	}

}
