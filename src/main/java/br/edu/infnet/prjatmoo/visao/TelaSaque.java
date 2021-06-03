package br.edu.infnet.prjatmoo.visao;

import java.util.Scanner;

import br.edu.infnet.prjatmoo.controle.ContaCtrl;

public class TelaSaque implements Tela {

	private double valorSaque;
	private ContaCtrl contaCtrl = new ContaCtrl();

	@SuppressWarnings("resource")
	@Override
	public void apresentar() {
		System.out.println(" Saque ");
		System.out.println(" Informe o valor: ");
		Scanner scanner = new Scanner(System.in);
		valorSaque = scanner.nextDouble();
		System.out.println( contaCtrl.saca(valorSaque)  );
	}

}
