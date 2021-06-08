package br.edu.infnet.prjatmoo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Conta {

	/**
	 * Classe que cria a conta 
	 * @param numero conta do banco
	 * @param saldo da conta
	 */

	private static Conta instancia;

	private String numero;
	
	private int pin;
	
	private double saldo;
	
	private static List<Transacao> transacoes = new ArrayList<Transacao>();
	
	public static Conta getInstancia(String numero, int pin) {
		if(instancia == null) {
			instancia = new Conta(numero, pin);
		}

		return instancia;
	}

	public Conta(String numero, int pin) {
		this.numero = numero;
		this.pin = pin;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public void saca(double valorSaque) {
		this.saldo -= valorSaque;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void addTransacao(Transacao transacao) {
		transacoes.add(transacao);
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", pin=" + pin + ", saldo=" + saldo + ", transacoes=" + transacoes + "]";
	}
}
