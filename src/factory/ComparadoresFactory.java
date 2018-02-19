package factory;

import java.util.Comparator;

import cenarios.Cenario;
import comparadores.ComparadorPorApostas;
import comparadores.ComparadorPorCadastro;
import comparadores.ComparadorPorNome;
import util.Verificador;

public class ComparadoresFactory {

	
	
	public static Comparator<Cenario> criaComparador(String ordem) {
		Verificador.verificaStringVazia(ordem, "Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		Verificador.verificaStringVazia(ordem, "Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		if(ordem.equalsIgnoreCase("Cadastro")) {
			return new ComparadorPorCadastro();
		} else if(ordem.equalsIgnoreCase("Nome")) {
			return new ComparadorPorNome();
		} else if (ordem.equalsIgnoreCase("Apostas")) {
			return new ComparadorPorApostas();
		}
		throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
	}
}
