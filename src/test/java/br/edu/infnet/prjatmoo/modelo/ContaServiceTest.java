package br.edu.infnet.prjatmoo.modelo;

import org.junit.Assert;
import org.junit.Test;

import br.edu.infnet.prjatmoo.utils.SaldoInsuficienteException;

public class ContaServiceTest {

	@Test
	public void testGetSaldoContaComSucessoValorZero() {
		// cria cenários
		ContaService contaService = new ContaService();

		// executa a logica
		double saldoConta = contaService.getSaldoConta("123");

		// valida o retorno
		Assert.assertEquals(0.0, saldoConta, 0.0001);

	}
	
	@Test
	public void testGetSaldoContaComSucesso() {

		// cria cenários
		ContaService contaService = new ContaService();
		contaService.deposita("123", 10.0);
		
		// executa a logica
		double saldoConta = contaService.getSaldoConta("123");

		// valida o retorno
		Assert.assertEquals(10.0, saldoConta, 0.0001);

	}
	
	@Test
	public void testGetSaldoContaInexistente() {

		// cria cenários
		ContaService contaService = new ContaService();
		contaService.deposita("123", 10.0);
		
		// executa a logica
		double saldoConta = contaService.getSaldoConta("456");

		// valida o retorno
		Assert.assertEquals(0.0, saldoConta, 0.0001);

	}

	@Test
	public void testDeposita() {
		// cria cenários
		ContaService contaService = new ContaService();

		// executa a logica
		contaService.deposita("123", 10.0);
		double saldoConta = contaService.getSaldoConta("123");

		// valida o retorno
		Assert.assertEquals(10.0, saldoConta, 0.0001);
	}

	@Test
	public void testSaca() throws SaldoInsuficienteException {
		// cria cenários
		ContaService contaService = new ContaService();
		contaService.deposita("123", 10.0);
		
		// executa a logica
		contaService.saca(5.0,"123");
		double saldoConta = contaService.getSaldoConta("123");

		// valida o retorno
		Assert.assertEquals(5.0, saldoConta, 0.0001);

	}

}
