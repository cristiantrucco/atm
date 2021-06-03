package br.edu.infnet.prjatmoo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.infnet.prjatmoo.utils.SaldoInsuficienteException;

public class ContaService {
 
	private static List<Conta> REPOSITORIO = new ArrayList<Conta>();

	public double getSaldoConta(String numerConta) {

		/// pegar o saldo de uma conta que está na lista

		List<Conta> collect = REPOSITORIO.stream().filter(c -> c.getNumero().equals(numerConta))
				.collect(Collectors.toList());

		if (collect.size() == 0) {
			return 0;
		}

		return collect.get(0).getSaldo();
	}

	public void deposita(String contaNumero, double valor) {

		Conta conta = null;

		List<Conta> collect = REPOSITORIO.stream().filter(c -> c.getNumero().equals(contaNumero))
				.collect(Collectors.toList());

		if (collect.size() == 0) {
			conta = new Conta(contaNumero, 0);
			REPOSITORIO.add(conta);
		} else {
			conta = collect.get(0);
		}

		conta.depositar(valor);
		
		Transacao transacao = new Transacao(TipoTransacao.CREDITO, valor, conta);
		conta.addTransacao(transacao);

	}

	public String saca(double valorSaque, String contaNumero) throws SaldoInsuficienteException {

		Conta conta = null;

		List<Conta> collect = REPOSITORIO.stream().filter(c -> c.getNumero().equals(contaNumero))
				.collect(Collectors.toList());

		//
		if (collect.size() == 0) {
			conta = new Conta(contaNumero, 0);
			REPOSITORIO.add(conta);
		} else {
			conta = collect.get(0);
		}

		if (conta.getSaldo() >= valorSaque) {
			conta.saca(valorSaque);

			Transacao transacao = new Transacao(TipoTransacao.DEBITO, valorSaque, conta);
			conta.addTransacao(transacao);
			
			return "saque realizado com sucesso";
		}
		
		throw new SaldoInsuficienteException("Saldo insuficiente maluco");
	}

	public List<Transacao> getExtratoConta(String contaNumero) {
		List<Conta> collect = REPOSITORIO.stream().filter(c -> c.getNumero().equals(contaNumero))
				.collect(Collectors.toList());

		if (collect.size() == 0) {
			return null;
		}

		return collect.get(0).getTransacoes();
	}

}
