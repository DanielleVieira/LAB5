package apostas;

import util.Verificador;

public class ApostaAssegurada{

	
	
	private ApostaNaoAssegurada aposta;
	private Seguro seguro;
	

	
	
	public ApostaAssegurada(String apostador, int valor, String previsao, int valorAssegurado) {
		Verificador.verificaValorMenorIgualZero(valorAssegurado, "Valor assegurado nao pode ser menor ou igual a zero");
		this.aposta = new ApostaNaoAssegurada(apostador, valor, previsao);
		this.seguro = new SeguroValor(valorAssegurado);
	}
	
	
	
	public ApostaAssegurada(String apostador, int valor, String previsao, double valorTaxa) {
		Verificador.verificaValorMenorIgualZero(valorTaxa, "Taxa nao pode ser menor ou igual a zero");
		this.aposta = new ApostaNaoAssegurada(apostador, valor, previsao);
		this.seguro = new SeguroTaxa(valorTaxa, this.aposta.getValor());
	}



	public int getValor() {
		return aposta.getValor();
	}
	


	@Override
	public String toString() {
		return String.format("%s - ASSEGURADA %s", this.aposta.toString(), this.seguro.toString());
	}



	public String getPrevisao() {
		return this.aposta.getPrevisao();
	}



	public void alterarSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(taxa, this.aposta.getValor());
	}



	public void alterarSeguroValor(int valor) {
		this.seguro = new SeguroValor(valor);
	}

}
