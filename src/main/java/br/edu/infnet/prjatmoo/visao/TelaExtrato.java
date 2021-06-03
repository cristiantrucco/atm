package br.edu.infnet.prjatmoo.visao;

import java.util.List;

import br.edu.infnet.prjatmoo.controle.ContaCtrl;
import br.edu.infnet.prjatmoo.modelo.Transacao;

public class TelaExtrato implements Tela{
	
	private ContaCtrl contaCtrl = new ContaCtrl();
	
	public void apresentar() {
		System.out.println(" Extrato ");
		
		List<Transacao> transacoes = contaCtrl.getExtrato();

		for (Transacao transacao : transacoes) {
			System.out.println(transacao); 
		}
		
		
	}

}
