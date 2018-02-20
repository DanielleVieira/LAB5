package apostas;

import util.Verificador;

public class Aposta {

	
	
	private String apostador;
	private int valor; // valor da aposta em centavos
	private String previsao;
	private final String msgError1 = "Apostador nao pode ser vazio ou nulo";
	private final String msgError2 = "Valor nao pode ser menor ou igual a zero";
	private final String msgError3 = "Previsao nao pode ser vazia ou nula";
	private final String msgError4 = "Previsao invalida";

	
	
	public Aposta(String apostador, int valor, String previsao) {
		Verificador.verificaStringNula(apostador, this.msgError1);
		Verificador.verificaStringVazia(apostador, this.msgError1);
		Verificador.verificaValorMenorIgualZero(valor, this.msgError2);
		Verificador.verificaStringNula(previsao, this.msgError3);
		Verificador.verificaStringVazia(previsao, this.msgError3);
		Verificador.verificaPrevisao(previsao.toUpperCase(), this.msgError4);
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao.toUpperCase();
	}



	public int getValor() {
		return valor;
	}
	


	@Override
	public String toString() {
		return String.format("%s - R$%.2f - %s", this.apostador, this.valor / 100.0, this.previsao);
	}



	public String getPrevisao() {
		return previsao;
	}

}
