package util;

public class Verificador {

	
	public static void verificaValorMenorZero(double valor, String msg) {
		if(valor < 0) {throw new IllegalArgumentException(msg);}
	}
	
	
	
	public static void verificaStringVazia(String str, String msg) {
		if(str.trim().isEmpty()) {throw new IllegalArgumentException(msg);}
	}
	
	
	
	public static void verificaStringNula(String str, String msg) {
		if(str == null) {throw new NullPointerException(msg);}
	}
	
	
	
	/**
	 * Lança uma exceção se o valor do id for menor que 1.
	 * @param id - númeração que identifica o cenário
	 */
	public static void verificaValorIDCenario(int id, String msg) {
		if(id < 1) {throw new IllegalArgumentException(msg);}
	}
	
	
	
	public static void verificaValorMenorIgualZero(double valor, String msg) {
		if(valor <= 0) {throw new IllegalArgumentException(msg);}
	}
	
	
	
	public static void verificaPrevisao(String previsao, String msg) {
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {throw new IllegalArgumentException(msg);}
	}
}
