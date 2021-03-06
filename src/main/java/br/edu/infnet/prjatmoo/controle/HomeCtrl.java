package br.edu.infnet.prjatmoo.controle;

import br.edu.infnet.prjatmoo.visao.Tela;
import br.edu.infnet.prjatmoo.visao.TelaDeposito;
import br.edu.infnet.prjatmoo.visao.TelaExtrato;
import br.edu.infnet.prjatmoo.visao.TelaSaldo;
import br.edu.infnet.prjatmoo.visao.TelaSaque;

public class HomeCtrl {
	
	/**
     * Classe controle com todas as operações e ações possiveis para realizar na conta, após o login
     * 
     */
	
	private Tela tela;
	
	public void abrir(int opcao) {
		
		switch (opcao) {
			case 1:
				tela = new TelaSaldo();
				break;
			case 2:
				tela = new TelaSaque();
				break;
			case 3:
				tela = new TelaDeposito();
				break;
			case 4:
				tela = new TelaExtrato();
				break;
	
			default:
				break;
		}
		
		tela.apresentar();
		
	}

}
