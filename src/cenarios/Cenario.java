package cenarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apostas.ApostaAssegurada;
import apostas.ApostaNaoAssegurada;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;
import factory.ApostaFactory;
import util.Verificador;

public class Cenario implements Comparable<Cenario>{

	
	
	protected String descricao;
	protected int id;
	protected String estado;
	protected List<ApostaNaoAssegurada> apostasNaoAsseguradas;
	protected Map<Integer, ApostaAssegurada> apostasAsseguradas;
	protected boolean encerrado;
	protected int rateio;
	protected int chave;
	protected static final int ALTERADO_COM_SUCESSO = 1;
	
	
	
	public Cenario(String descricao, int id) {
		Verificador.verificaStringNula(descricao, "Erro no cadastro de cenario: Descricao nao pode ser nula");
		Verificador.verificaStringVazia(descricao, "Erro no cadastro de cenario: Descricao nao pode ser vazia");
		Verificador.verificaValorIDCenario(id, "Erro na consulta de cenario: Cenario invalido");
		this.descricao = descricao;
		this.id = id;
		this.estado = "Nao finalizado";
		this.apostasNaoAsseguradas = new ArrayList<>();
		this.apostasAsseguradas = new HashMap<>();
		this.encerrado = false;
		this.rateio = 0;
		this.chave = 0;
	}



	public void cadastrarAposta(String apostador, int valor, String previsao) {
		this.apostasNaoAsseguradas.add(ApostaFactory.criaAposta(apostador, valor, previsao));
		this.chave++;
		//this.apostas.put(this.chave, ApostaFactory.criaAposta(apostador, valor, previsao));
		//this.chave++;
	}
	
	
	
	public String getEstado() {
		return this.estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getId() {
		return this.id;
	}



	public String getDescricao() {
		return descricao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (this.id != other.getId())
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.estado;
	}



	public int valorTotalDeApostas() {
		int soma = 0;
		for (ApostaNaoAssegurada aposta : this.apostasNaoAsseguradas) {
			soma += aposta.getValor();
		}
		for (ApostaAssegurada aposta : this.apostasAsseguradas.values()) {
			soma += aposta.getValor();
		}
		return soma;
	}



	public int totalDeApostas() {
		return this.apostasNaoAsseguradas.size() + this.apostasAsseguradas.size();
	}



	public String exibeApostas() {
		String str = "";
		for (ApostaNaoAssegurada aposta : this.apostasNaoAsseguradas) {
			str += aposta.toString() + "\n";
		}
		return str;
	}



	public int getCaixaCenario(double taxa) throws CenarioAbertoException, CenarioEncerradoException {
		int valorCaixa = 0;
		
		this.verificaCenarioAberto("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		this.verificaCenarioEncerrado("Erro na consulta do caixa do cenario: Cenario encerrado");
		
		if(this.estado.equals("Finalizado (ocorreu)")) {
			valorCaixa = (int) ( this.valorTotalDeApostasPerdedoras() * taxa);
			this.rateio = this.valorTotalDeApostasPerdedoras() - valorCaixa;
		} else {
			valorCaixa = (int) (this.valorTotalDeApostasGanhadoras() * taxa);
			this.rateio = this.valorTotalDeApostasGanhadoras() - valorCaixa;
		}
		return valorCaixa;
	}



	protected void verificaCenarioEncerrado(String msg) throws CenarioEncerradoException {
		if(this.encerrado) {
			throw new CenarioEncerradoException(msg);
		}
	}



	protected void verificaCenarioAberto(String msg) throws CenarioAbertoException {
		if(this.estado.equals("Nao finalizado")) {
			throw new CenarioAbertoException(msg);
		}
	}
	
	
	
	protected int valorTotalDeApostasGanhadoras() {
		int soma = 0;
		for (ApostaNaoAssegurada apostaNaoAssegurada : this.apostasNaoAsseguradas) {
			if(apostaNaoAssegurada.getPrevisao().equals("VAI ACONTECER")) {
				soma += apostaNaoAssegurada.getValor();
			}
		}
		for (ApostaAssegurada apostaAssegurada : this.apostasAsseguradas.values()) {
			if(apostaAssegurada.getPrevisao().equals("VAI ACONTECER")) {
				soma += apostaAssegurada.getValor();
			}
		}
		return soma;
	}
	
	
	
	protected int valorTotalDeApostasPerdedoras() {
		int soma = 0;
		for (ApostaNaoAssegurada apostaNaoAssegurada : this.apostasNaoAsseguradas) {
			if(apostaNaoAssegurada.getPrevisao().equals("N VAI ACONTECER")) {
				soma += apostaNaoAssegurada.getValor();
			}
		}
		for (ApostaAssegurada apostaAssegurada : this.apostasAsseguradas.values()) {
			if(apostaAssegurada.getPrevisao().equals("N VAI ACONTECER")) {
				soma += apostaAssegurada.getValor();
			}
		}
		return soma;
	}

	
	
	
	public int getTotalRateioCenario() throws CenarioAbertoException {
		this.verificaCenarioAberto("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		return this.rateio;
	}



	@Override
	public int compareTo(Cenario o) {
		if(this.id < o.getId()) {
			return -1;
		} else if(this.id > o.getId()) {
			return 1;
		} else {
			return 0;
		}
	}



	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		this.apostasAsseguradas.put(this.chave, ApostaFactory.criaApostaSeguraTaxa(apostador, valor, previsao, taxa));
		this.chave++;
		return this.chave - 1;
	}



	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado) {
		this.apostasAsseguradas.put(this.chave, ApostaFactory.criaApostaSeguraValor(apostador, valor, previsao, valorAssegurado));
		this.chave++;
		return this.chave - 1;
	}



	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		this.verificaApostaAsseguradaCadastrada(apostaAssegurada);
		this.apostasAsseguradas.get(apostaAssegurada).alterarSeguroTaxa(taxa);
		return this.ALTERADO_COM_SUCESSO;
	}
	
	
	
	protected void verificaApostaAsseguradaCadastrada(int apostaAsseguradaID) {
		if(!apostasAsseguradas.keySet().contains(apostaAsseguradaID)) {
			throw new IllegalArgumentException("Aposta assegurada não cadastrada");
		}
	}



	public int alterarSeguroValor(int apostaAssegurada, int valor) {
		this.verificaApostaAsseguradaCadastrada(apostaAssegurada);
		this.apostasAsseguradas.get(apostaAssegurada).alterarSeguroValor(valor);
		return this.ALTERADO_COM_SUCESSO;
	}

}
