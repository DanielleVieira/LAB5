package facade;
import exceptions.ApostaFechadaException;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;
import sistema.SistemaDeApostas;

public class Facade {

	
	
	private SistemaDeApostas sistemaDeApostas;
	
	
	
    public void inicializa(int caixa, double taxa) {
    	this.sistemaDeApostas = new SistemaDeApostas(caixa, taxa);
    }
    
    
    
    public int getCaixa() {
    	return this.sistemaDeApostas.getCaixa();
    }
    
    
    
    public int cadastrarCenario(String descricao) {
    	return this.sistemaDeApostas.cadastrarCenario(descricao);
    }
    
    
    
    public int cadastrarCenario(String descricao, int bonus) {
    	return this.sistemaDeApostas.cadastrarCenario(descricao, bonus);
    }
    
    
    
    public String exibirCenario(int cenario) {
    	return this.sistemaDeApostas.exibirCenario(cenario);
    }
    
    
    
    public String exibirCenarios() {
    	return this.sistemaDeApostas.exibirCenarios();
    }
    
    
    
    public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
    	this.sistemaDeApostas.cadastrarAposta(cenario, apostador, valor, previsao);
    }
    
    
    
    public int valorTotalDeApostas(int cenario) {
    	return this.sistemaDeApostas.valorTotalDeApostas(cenario);
    }
    
    
    
    public int totalDeApostas(int cenario) {
    	return this.sistemaDeApostas.totalDeApostas(cenario);
    }
    
    
    
    public String exibeApostas(int cenario) {
    	return this.sistemaDeApostas.exibeApostas(cenario);
    }
    
    
    
    public void fecharAposta(int cenario, boolean ocorreu) throws ApostaFechadaException {
    	this.sistemaDeApostas.fecharAposta(cenario, ocorreu);
    }
    
    
    
    public int getCaixaCenario(int cenario) throws CenarioAbertoException, CenarioEncerradoException {
    	return this.sistemaDeApostas.getCaixaCenario(cenario);
    }
    
    
    
    public int getTotalRateioCenario(int cenario) throws CenarioAbertoException {
    	return this.sistemaDeApostas.getTotalRateioCenario(cenario);
    }
    
    
    
    public void alterarOrdem(String ordem) {
    	this.sistemaDeApostas.alterarOrdem(ordem);
    }
    
    
    
    public String exibirCenarioOrdenado(int cenario) {
    	return this.sistemaDeApostas.exibirCenarioOrdenado(cenario);
    }
   
}
