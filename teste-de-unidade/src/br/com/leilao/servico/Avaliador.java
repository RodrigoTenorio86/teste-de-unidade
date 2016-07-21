package br.com.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;

public class Avaliador {
	private double maiorDeTodos = Double.MIN_VALUE;
	private double menorDeTodos = Double.MAX_VALUE;
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
		}
		// Os 3 maiores Valores de Lance.
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance a1, Lance a2) {
				if (a1.getValor() < a2.getValor())	return 1;
				if (a1.getValor() > a2.getValor())	return -1;
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size()> 3?3:maiores.size());
	}

	public List<Lance> getTresMaiores() {
		return maiores;
	}

	public double getMaiorDeLance() {
		return maiorDeTodos;
	}

	public double getMenorDeLance() {
		return menorDeTodos;
	}
}
