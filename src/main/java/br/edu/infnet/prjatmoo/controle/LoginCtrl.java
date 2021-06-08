package br.edu.infnet.prjatmoo.controle;

import br.edu.infnet.prjatmoo.modelo.Conta;
import br.edu.infnet.prjatmoo.utils.LoginOrSenhaInvalidaExcetion;
import br.edu.infnet.prjatmoo.visao.TelaHome;

public class LoginCtrl {

	public static Conta _conta = null;

	/**
	 * Classe que valida a conta e senha
	 * @param conta a conta do banco
	 * @param pin a senha da conta
	 * @throws LoginOrSenhaInvalidaExcetion
	 */
	public void login(String conta, int pin) throws LoginOrSenhaInvalidaExcetion {

		if (conta.equals("123") && pin == 456) {
			_conta = Conta.getInstancia(conta, pin);
			TelaHome home = new TelaHome();
			home.apresentar();
			return;
		}

		throw new LoginOrSenhaInvalidaExcetion();
	}

}
