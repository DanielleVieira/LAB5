package cenarios;

import java.util.HashMap;
import java.util.Map;

import apostas.Aposta;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;
import util.Verificador;

public class Cenario implements Comparable<Cenario>{

	
	
	protected String descricao;
	protected int id;
	protected String estado;
	protected Map<Integer, Aposta> apostas;
	protected boolean encerrado;
	protected int rateio;
	protected int chave;
	
	
	
	public Cenario(String descricao, int id) {
		Verificador.verificaStringNula(descricao, "Erro no cadastro de cenario: Descricao nao pode ser nula");
		Verificador.verificaStringVazia(descricao, "Erro no cadastro de cenario: Descricao nao pode ser vazia");
		Verificador.verificaValorIDCenario(id, "Erro na consulta de cenario: Cenario invalido");
		this.descricao = descricao;
		this.id = id;
		this.estado = "Nao finalizado";
		this.apostas = new HashMap<>();
		this.encerrado = false;
		this.rateio = 0;
		this.chave = 0;
	}



	public void cadastrarAposta(String apostador, int valor, String previsao) {
		this.apostas.put(this.chave, this.criaAposta(apostador, valor, previsao));
		this.chave++;
		
	}
	
	
	
	protected Aposta criaAposta(String apostador, int valor, String previsao) {
		try {
			return new Aposta(apostador, valor, previsao);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta: " + e.getMessage());
		}
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
		for (Aposta aposta : this.apostas.values()) {
			soma += aposta.getValor();
		}
		return soma;
	}



	public int totalDeApostas() {
		return this.apostas.size();
	}



	public String exibeApostas() {
		String str = "";
		for (Aposta aposta : this.apostas.values()) {
			str += aposta.toString() + "\n";
		}
		return str;
	}



	public int getCaixaCenario(double taxa) throws CenarioAbertoException, CenarioEncerradoException {
		int somaOcorreu = 0;
		int somaNOcorreu = 0;
		int valorCaixa = 0;
		
		this.verificaCenarioAberto("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		this.verificaCenarioEncerrado("Erro na consulta do caixa do cenario: Cenario encerrado");
		
		for (Aposta aposta : this.apostas.values()) {
			if(aposta.getPrevisao().equals("VAI ACONTECER")) {
				somaOcorreu += aposta.getValor();
			} else {
				somaNOcorreu += aposta.getValor();
			}
		}
		if(this.estado.equals("Finalizado (ocorreu)")) {
			valorCaixa = (int) ( somaNOcorreu * taxa);
			this.rateio = somaNOcorreu - valorCaixa;
		} else {
			valorCaixa = (int) (somaOcorreu * taxa);
			this.rateio = somaOcorreu - valorCaixa;
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

}
