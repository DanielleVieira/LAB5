package sistema;

import java.util.ArrayList;
import java.util.List;

import cenarios.Cenario;
import cenarios.CenarioComBonus;
import exceptions.ApostaFechadaException;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;

public class CenariosController {

	
	
	private List<Cenario> cenarios;
	private int cenarioID;
	
	
	
	public CenariosController() {
		this.cenarios = new ArrayList<>();
		this.cenarioID = 1;
	}

	

	public int cadastrarCenario(String descricao) {
		this.cenarios.add(this.criaCenario(descricao, this.cenarioID));
		this.cenarioID += 1;
		
		return this.cenarioID - 1;
	}
	
	
	
	public int cadastrarCenario(String descricao, int bonus) {
		this.cenarios.add(this.criaCenario(descricao, this.cenarioID, bonus));
		this.cenarioID += 1;
		
		return this.cenarioID - 1;
	}



	private Cenario criaCenario(String descricao, int cenarioID, int bonus) {
		return new CenarioComBonus(descricao, cenarioID, bonus);
	}



	private Cenario criaCenario(String descricao, int idCenario) {
		return new Cenario(descricao, idCenario);
	}
	
	
	
	public String exibirCenario(int cenarioID) {
		return this.buscaCenario(cenarioID).toString();
	}
	
	
	
	private Cenario buscaCenario(int cenarioID) {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro na consulta de cenario: Cenario nao cadastrado");
		return this.cenarios.get(cenarioID - 1);
	}



	private void validaCenarioNaoCadastrado(int cenarioID, String msg) {
		if(cenarioID > this.cenarios.size()) {
			throw new IllegalArgumentException(msg);
		}
	}



	public String exibirCenarios() {
		String str = "";
		for (Cenario cenario : cenarios) {
			str += cenario.toString() + "\n";
		}
		return str;
	}



	public void cadastrarAposta(int cenarioID, String apostador, int valor, String previsao) {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro no cadastro de aposta: Cenario nao cadastrado");
		this.buscaCenario(cenarioID).cadastrarAposta(apostador, valor, previsao);
	}



	public int valorTotalDeApostas(int cenarioID) {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).valorTotalDeApostas();
	}



	public int totalDeApostas(int cenarioID) {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro na consulta do total de apostas: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).totalDeApostas();
	}



	public String exibeApostas(int cenarioID) {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro na consulta de apostas: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).exibeApostas();
	}



	public void fecharAposta(int cenarioID, boolean ocorreu) throws ApostaFechadaException {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro ao fechar aposta: Cenario nao cadastrado");
		Cenario cenario = this.buscaCenario(cenarioID);
		if(cenario.getEstado().equals("Nao finalizado")) {
			if(ocorreu) {
				cenario.setEstado("Finalizado (ocorreu)");
			} else {
				cenario.setEstado("Finalizado (n ocorreu)");
			}
		} else {
			throw new ApostaFechadaException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
	}
	


	public int getCaixaCenario(int cenarioID, double taxa) throws CenarioAbertoException, CenarioEncerradoException {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).getCaixaCenario(taxa);
	}



	public int getTotalRateioCenario(int cenarioID) throws CenarioAbertoException {
		this.validaCenarioNaoCadastrado(cenarioID, "Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).getTotalRateioCenario();
	}
	
}
