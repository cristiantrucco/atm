package br.edu.infnet.prjatmoo.utils;

public class LoginOrSenhaInvalidaExcetion extends Exception {

	public LoginOrSenhaInvalidaExcetion() {
		super("Login ou senhas inválidos, verifique suas credencias e tente novamente");
	}
	
}
