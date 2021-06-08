package br.edu.infnet.prjatmoo.controle;

import java.util.List;

import br.edu.infnet.prjatmoo.modelo.ContaService;
import br.edu.infnet.prjatmoo.modelo.Transacao;
import br.edu.infnet.prjatmoo.utils.SaldoInsuficienteException;

public class ContaCtrl {
	/**
     * Classe controle com todas os métodos (ações possiveis da conta)
     * 
     */
	private ContaService contaService = new ContaService();
	
	public double getSaldo() {
		return contaService.getSaldoConta();
	}

	public void depositar(double valor) {
		contaService.deposita(valor);
	}

	public String saca(double valorSaque) {
		try {
			return contaService.saca(valorSaque);
		} catch (SaldoInsuficienteException e) {
			return e.getMessage();
		}
	}

	public List<Transacao> getExtrato() {
		return contaService.getExtratoConta();
	}
}
