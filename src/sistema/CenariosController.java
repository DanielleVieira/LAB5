package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cenarios.Cenario;
import cenarios.CenarioComBonus;
import comparadores.ComparadorPorCadastro;
import exceptions.ApostaFechadaException;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;
import factory.ComparadoresFactory;

public class CenariosController {

	
	
	private List<Cenario> cenarios;
	private int cenarioID;
	private Comparator<Cenario> comparador;
	
	
	
	public CenariosController() {
		this.cenarios = new ArrayList<>();
		this.comparador = new ComparadorPorCadastro();
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
	
	
	
	public String exibirCenario(int cenario) {
		try {
			this.alterarOrdem("Cadastro");
			return this.exibirCenarioOrdenado(cenario);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
	}
	
	
	
	private Cenario buscaCenario(int cenarioID) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Cenario nao cadastrado");
		return this.cenarios.get(cenarioID - 1);
	}



	private void verificaCenarioNaoCadastrado(int cenarioID, String msg) {
		if(cenarioID > this.cenarios.size()) {
			throw new IllegalArgumentException(msg);
		}
	}



	public String exibirCenarios() {
		this.alterarOrdem("Cadastro");
		String str = "";
		for (Cenario cenario : cenarios) {
			str += cenario.toString() + "\n";
		}
		return str;
	}



	public void cadastrarAposta(int cenarioID, String apostador, int valor, String previsao) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro no cadastro de aposta: Cenario nao cadastrado");
		this.buscaCenario(cenarioID).cadastrarAposta(apostador, valor, previsao);
	}



	public int valorTotalDeApostas(int cenarioID) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).valorTotalDeApostas();
	}



	public int totalDeApostas(int cenarioID) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro na consulta do total de apostas: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).totalDeApostas();
	}



	public String exibeApostas(int cenarioID) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro na consulta de apostas: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).exibeApostas();
	}



	public void fecharAposta(int cenarioID, boolean ocorreu) throws ApostaFechadaException {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro ao fechar aposta: Cenario nao cadastrado");
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
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).getCaixaCenario(taxa);
	}



	public int getTotalRateioCenario(int cenarioID) throws CenarioAbertoException {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).getTotalRateioCenario();
	}



	public void alterarOrdem(String ordem) {
		this.comparador = ComparadoresFactory.criaComparador(ordem);
		Collections.sort(this.cenarios, this.comparador);
	}



	public String exibirCenarioOrdenado(int cenario) {
		this.verificaCenarioNaoCadastrado(cenario, "Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		return this.cenarios.get(cenario- 1).toString();
	}



	public int cadastrarApostaSeguraValor(int cenarioID, String apostador, int valor, String previsao, int valorAssegurado) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).cadastrarApostaSeguraValor(apostador, valor, previsao, valorAssegurado);
	}



	public int cadastrarApostaSeguraTaxa(int cenarioID, String apostador, int valor, String previsao, double taxa) {
		this.verificaCenarioNaoCadastrado(cenarioID, "Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		return this.buscaCenario(cenarioID).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}
	
}
