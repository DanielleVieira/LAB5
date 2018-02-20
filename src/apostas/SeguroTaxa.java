package apostas;

public class SeguroTaxa implements Seguro {

	
	
	private double valorTaxa;
	private int valorAposta;
	
	
	
	public SeguroTaxa(double valorTaxa, int valorAposta) {
		this.valorTaxa = valorTaxa;
		this.valorAposta = valorAposta;
	}



	@Override
	public String toString() {
		return String.format("(TAXA) - R$ %.2f", this.valorTaxa / 100.0);
	}



	@Override
	public int seguroDebitadoDoCaixa() {
		return (int) (this.valorTaxa * this.valorAposta);
	}
}
