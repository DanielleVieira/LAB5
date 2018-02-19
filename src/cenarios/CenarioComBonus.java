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
		return super.toString() + " - R$ " + this.bonus / 100 + ",00";
	}
	
	
	
	@Override
	public int getTotalRateioCenario() throws CenarioAbertoException {
		return super.getTotalRateioCenario() + this.bonus;
	}
}
