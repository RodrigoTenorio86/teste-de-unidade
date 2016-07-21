package br.com.leilao.servico;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;

public class Avaliador {
	private double maiorDeTodos = Double.MIN_VALUE;
	private double menorDeTodos=Double.MAX_VALUE;

	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)	maiorDeTodos = lance.getValor();
			if(lance.getValor()<menorDeTodos) menorDeTodos=lance.getValor();
		}
	}

	public double getMaiorDeLance() {
		return maiorDeTodos;
	}
	public double getMenorDeLance() {
		return menorDeTodos;
	}
}
