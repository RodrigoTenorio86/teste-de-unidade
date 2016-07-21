package br.com.leilao.teste.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;

public class LeilaoTest {
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Casa");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Jose"), 1000));
		assertEquals(1, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.0001);
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Casa");
		leilao.propoe(new Lance(new Usuario("Jose"), 1000.0));
		leilao.propoe(new Lance(new Usuario("Maria"), 2000.0));
		leilao.propoe(new Lance(new Usuario("marcia"), 3000.0));
		// Qtd de lance.
		assertEquals(3, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.0001);
		assertEquals(2000.0, leilao.getLances().get(1).getValor(), 0.0001);
		assertEquals(3000.0, leilao.getLances().get(2).getValor(), 0.0001);
	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Casa");
		Usuario maia = new Usuario("Maia");

		leilao.propoe(new Lance(maia, 1000.0));
		leilao.propoe(new Lance(maia, 2000.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.0001);
	}
	@Test
	public void naoDeveAceitarMaisDoQueCincolancesDoMesmoUsuario(){
		Leilao leilao=new Leilao("Casa");
		
		Usuario jose=new Usuario("Jose");
		Usuario maria=new Usuario("maria");
		
		leilao.propoe(new Lance(jose, 1000.0));
		leilao.propoe(new Lance(maria, 2000.0));
		
		leilao.propoe(new Lance(jose, 3000.0));
		leilao.propoe(new Lance(maria, 4000.0));
		
		leilao.propoe(new Lance(jose, 5000.0));
		leilao.propoe(new Lance(maria, 6000.0));
		
		leilao.propoe(new Lance(jose, 7000.0));
		leilao.propoe(new Lance(maria, 8000.0));
		
		leilao.propoe(new Lance(jose, 9000.0));
		leilao.propoe(new Lance(maria, 10000.0));
		

		leilao.propoe(new Lance(jose, 11000.0));
		
		assertEquals(10, leilao.getLances().size());
	}
}
