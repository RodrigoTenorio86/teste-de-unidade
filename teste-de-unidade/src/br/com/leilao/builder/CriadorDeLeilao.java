/**
 * @author RodrigoTenorio
 * drescricao: class para criar cenario:Teste  data builder para diminui o acoplamento.
 */
package br.com.leilao.builder;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;

public class CriadorDeLeilao {

	private Leilao leilao;

	public CriadorDeLeilao para(String descricao) {
		// TODO Auto-generated method stub
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		// TODO Auto-generated method stub
		this.leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		// TODO Auto-generated method stub
		return this.leilao;
	}

}
