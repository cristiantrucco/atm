package br.edu.infnet.prjatmoo.visao;

import br.edu.infnet.prjatmoo.controle.ContaCtrl;

public class TelaSaldo implements Tela{
	
	private ContaCtrl contaCtrl = new ContaCtrl();
	
	public void apresentar() {
		System.out.println(" Saldo ");
		System.out.println(" O saldo da conta é: " + contaCtrl.getSaldo());
	}

}
