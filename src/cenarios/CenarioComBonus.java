package cenarios;

import exceptions.CenarioAbertoException;

public class CenarioComBonus extends Cenario {

	
	
	private int bonus;
	
	
	
	public CenarioComBonus(String descricao, int id, int bonus) {
		super(descricao, id);
		this.bonus = bonus;
	}



	@Override
	public String toString() {
		return String.format("%s - R$ %.2f", super.toString(), this.bonus / 100.0);
	}
	
	
	
	@Override
	public int getTotalRateioCenario() throws CenarioAbertoException {
		return super.getTotalRateioCenario() + this.bonus;
	}
}
