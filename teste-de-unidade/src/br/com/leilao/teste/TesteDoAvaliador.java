package br.com.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.leilao.builder.CriadorDeLeilao;
import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;
import br.com.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	private Avaliador leiloeiro;
	private Usuario jose;
	private Usuario joao;
	private Usuario maria;

	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		System.out.println("cria Avaliador");

		this.jose = new Usuario("jose");
		this.joao = new Usuario("joao");
		this.maria = new Usuario("maria");
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// 1 Cenario

		Leilao leilao = new Leilao("Casa");

		leilao.propoe(new Lance(maria, 10.0));
		leilao.propoe(new Lance(joao, 3000.0));
		leilao.propoe(new Lance(jose, 50000.0));
		// 2 Acao
		// criaAvaliador();
		leiloeiro.avalia(leilao);

		// 3 Valida
		System.out.println(leiloeiro.getMaiorDeLance());
		System.out.println(leiloeiro.getMenorDeLance());
		assertEquals(50000.0, leiloeiro.getMaiorDeLance(), 0.0001);
		assertEquals(10.0, leiloeiro.getMenorDeLance(), 0.0001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		Leilao leilao = new Leilao("Casa");

		leilao.propoe(new Lance(jose, 1000));

		// criaAvaliador();
		leiloeiro.avalia(leilao);

		assertEquals(1000, leiloeiro.getMaiorDeLance(), 0.001);
		assertEquals(1000, leiloeiro.getMenorDeLance(), 0.001);
	}

	@Test
	public void deveEncontrarOsTresMaiores() {

		//Leilao leilao = new Leilao("Casa");

		//leilao.propoe(new Lance(maria, 1000));
		//leilao.propoe(new Lance(jose, 2000));

		//leilao.propoe(new Lance(maria, 3000));
		//leilao.propoe(new Lance(jose, 4000));

		// criaAvaliador();
		Leilao leilao = new CriadorDeLeilao().para("casa").lance(jose, 3000.0).lance(maria, 4000.0).constroi();
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(2, maiores.size());
		assertEquals(4000, maiores.get(0).getValor(), 0.0001);
		assertEquals(3000, maiores.get(1).getValor(), 0.0001);
	}
}
