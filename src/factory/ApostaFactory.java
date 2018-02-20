package factory;

import apostas.ApostaNaoAssegurada;
import apostas.ApostaAssegurada;

public class ApostaFactory {

	
	
	public static ApostaNaoAssegurada criaAposta(String apostador, int valor, String previsao) {
		try {
			return new ApostaNaoAssegurada(apostador, valor, previsao);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta: " + e.getMessage());
		}
	}
	
	
	
	public static ApostaAssegurada criaApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		try {
			return new ApostaAssegurada(apostador, valor, previsao, taxa);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		}
	}
	
	
	
	public static ApostaAssegurada criaApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado) {
		try {
			return new ApostaAssegurada(apostador, valor, previsao, valorAssegurado);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: " + e.getMessage());
		}
	}
}
