package br.com.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		assertEquals(50000.0, leiloeiro.getMaiorDeLance(), 0.0001);
		assertEquals(10.0, leiloeiro.getMenorDeLance(), 0.0001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario jse = new Usuario("Jose");

		Leilao leilao = new Leilao("Casa");

		leilao.propoe(new Lance(jse, 1000));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(1000, leiloeiro.getMaiorDeLance(), 0.001);
		assertEquals(1000, leiloeiro.getMenorDeLance(), 0.001);
	}

	@Test
	public void deveEncontrarOsTresMaiores() {
		Usuario mario = new Usuario("Mario");
		Usuario jose = new Usuario("jose");

		Leilao leilao = new Leilao("Casa");

		leilao.propoe(new Lance(mario, 1000));
		leilao.propoe(new Lance(jose, 2000));

		leilao.propoe(new Lance(mario, 3000));
		leilao.propoe(new Lance(jose, 4000));

		Avaliador leiroeiro = new Avaliador();
		leiroeiro.avalia(leilao);

		List<Lance> maiores = leiroeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(2000, maiores.get(2).getValor(), 0.0001);
		assertEquals(3000, maiores.get(1).getValor(), 0.0001);
		assertEquals(4000, maiores.get(0).getValor(), 0.0001);
	}
}
