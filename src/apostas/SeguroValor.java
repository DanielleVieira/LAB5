package apostas;

public class SeguroValor implements Seguro {

	
	
	
	private int valorAssegurado;
	
	
	
	public SeguroValor(int valorAssegurado) {
		this.valorAssegurado = valorAssegurado;
	}



	@Override
	public String toString() {
		return String.format("(VALOR) - R$ %.2f", this.valorAssegurado / 100.0);
	}



	@Override
	public int seguroDebitadoDoCaixa() {
		return this.valorAssegurado;
	}
	
	
	
	
	
	

}
