package br.com.leilao.teste;

import org.junit.Assert;
import org.junit.Test;
import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;
import br.com.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// 1 Cenario
		Usuario jose = new Usuario("jose");
		Usuario joao = new Usuario("joao");
		Usuario maria = new Usuario("maria");

		Leilao leilao = new Leilao("Casa");

		leilao.propoe(new Lance(maria, 10.0));
		leilao.propoe(new Lance(joao, 3000.0));
		leilao.propoe(new Lance(jose, 50000.0));
		// 2 Acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// 3 Valida
		System.out.println(leiloeiro.getMaiorDeLance());
		System.out.println(leiloeiro.getMenorDeLance());
		Assert.assertEquals(50000.0, leiloeiro.getMaiorDeLance(), 0.0001);
		Assert.assertEquals(10.0, leiloeiro.getMenorDeLance(), 0.0001);
	}
}
