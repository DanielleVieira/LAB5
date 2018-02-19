package sistema;

import exceptions.ApostaFechadaException;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;
import util.Verificador;

public class SistemaDeApostas {

	
	
	private int caixa; // valor em centavos
	private final double taxa;
	private CenariosController cenariosControle;

	
	
	public SistemaDeApostas(int caixa, double taxa) {
		Verificador.verificaValorMenorZero(taxa, "Erro na inicializacao: Taxa nao pode ser inferior a 0");
		Verificador.verificaValorMenorZero(caixa, "Erro na inicializacao: Caixa nao pode ser inferior a 0");
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenariosControle = new CenariosController();
	}



	public int getCaixa() {
		return caixa;
	}



	public int cadastrarCenario(String descricao) {
		return this.cenariosControle.cadastrarCenario(descricao);
	}
	
	
	
	public int cadastrarCenario(String descricao, int bonus) {
		Verificador.verificaValorMenorIgualZero(bonus, "Erro no cadastro de cenario: Bonus invalido");
		int cenarioID = this.cenariosControle.cadastrarCenario(descricao, bonus);
		this.caixa -= bonus;
		return cenarioID;
	}



	public String exibirCenario(int cenarioID) {
		Verificador.verificaValorIDCenario(cenarioID, "Erro na consulta de cenario: Cenario invalido");
		return this.cenariosControle.exibirCenario(cenarioID);
	}



	public String exibirCenarios() {
		return this.cenariosControle.exibirCenarios();
	}



	public void cadastrarAposta(int cenarioID, String apostador, int valor, String previsao) {
		Verificador.verificaValorIDCenario(cenarioID, "Erro no cadastro de aposta: Cenario invalido");
		this.cenariosControle.cadastrarAposta(cenarioID, apostador, valor, previsao);
	}



	public int valorTotalDeApostas(int cenarioID) {
		Verificador.verificaValorIDCenario(cenarioID, "Erro na consulta do valor total de apostas: Cenario invalido");
		return this.cenariosControle.valorTotalDeApostas(cenarioID);
	}



	public int totalDeApostas(int cenarioID) {
		Verificador.verificaValorIDCenario(cenarioID, "Erro na consulta do total de apostas: Cenario invalido");
		return this.cenariosControle.totalDeApostas(cenarioID);
	}



	public String exibeApostas(int cenarioID) {
		Verificador.verificaValorIDCenario(cenarioID, "Erro na consulta de apostas: Cenario invalido");
		return this.cenariosControle.exibeApostas(cenarioID);
	}



	public void fecharAposta(int cenarioID, boolean ocorreu) throws ApostaFechadaException {
		Verificador.verificaValorIDCenario(cenarioID, "Erro ao fechar aposta: Cenario invalido");
		this.cenariosControle.fecharAposta(cenarioID, ocorreu);
	}



	public int getCaixaCenario(int cenarioID) throws CenarioAbertoException, CenarioEncerradoException {
		Verificador.verificaValorIDCenario(cenarioID, "Erro na consulta do caixa do cenario: Cenario invalido");
		int valorParaOCaixa = this.cenariosControle.getCaixaCenario(cenarioID, this.taxa);
		this.caixa += valorParaOCaixa;
		return valorParaOCaixa;
	}



	public int getTotalRateioCenario(int cenarioID) throws CenarioAbertoException {
		Verificador.verificaValorIDCenario(cenarioID, "Erro na consulta do total de rateio do cenario: Cenario invalido");
		return this.cenariosControle.getTotalRateioCenario(cenarioID);
	}
	
}
