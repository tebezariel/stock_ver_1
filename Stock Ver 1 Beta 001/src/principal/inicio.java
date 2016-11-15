package principal;

import forms.login.Login;

public class inicio {

	public static void main(String[] args) {

		Principal pri = new Principal();
		pri.crearVentanaPrincipal();
		
		/* inicio Login*/

		forms.login.Login log = new Login();
		principal.Principal.escritorio.add(log.crearVentanaLogin());
		
		
		
		/* fin Login*/ 
		
	}

}
