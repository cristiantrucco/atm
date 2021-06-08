package br.edu.infnet.prjatmoo.modelo;

import java.util.List;
import br.edu.infnet.prjatmoo.utils.SaldoInsuficienteException;

public class ContaService {
 
	private Conta REPOSITORIO = Conta.getInstancia("", 0);

	public double getSaldoConta() {
		return REPOSITORIO.getSaldo();
	}

	public void deposita(double valor) {
		REPOSITORIO.depositar(valor);

		Transacao transacao = new Transacao(TipoTransacao.CREDITO, valor, REPOSITORIO);
		REPOSITORIO.addTransacao(transacao);
	}

	public String saca(double valorSaque) throws SaldoInsuficienteException {
		if (REPOSITORIO.getSaldo() >= valorSaque) {
			REPOSITORIO.saca(valorSaque);

			Transacao transacao = new Transacao(TipoTransacao.DEBITO, valorSaque, REPOSITORIO);
			REPOSITORIO.addTransacao(transacao);
			
			return "saque realizado com sucesso";
		}
		
		throw new SaldoInsuficienteException("Saldo Insuficiente, para a conta");
	}

	public List<Transacao> getExtratoConta() {
		return REPOSITORIO.getTransacoes();
	}
}
