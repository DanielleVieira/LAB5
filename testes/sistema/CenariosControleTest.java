package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ApostaFechadaException;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;
import sistema.CenariosController;

public class CenariosControleTest {

	
	
	private CenariosController c1;
	private CenariosController c2;
		
	
	
	@Before
	public void setUp() throws Exception {
		this.c1 = new CenariosController();
		this.c2 = new CenariosController();
		this.c1.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.c1.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.c1.cadastrarAposta(2, "Matheus Melanio", 10000, "N VAI ACONTECER");
		this.c1.cadastrarAposta(2, "Matheus Melanio", 20000, "N VAI ACONTECER");
	}

	
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarCenarioDescricaoNula() {
		this.c1.cadastrarCenario(null);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioDescricaoVazia() {
		this.c1.cadastrarCenario("  ");
	}
	
	
	
	@Test
	public void testCadastrarCenario() {
		assertEquals(1, this.c2.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!"));
		assertEquals(2, this.c2.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!"));
	}
	
	
	
	@Test
	public void testExibirCenario() {
		assertEquals("2 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado", this.c1.exibirCenario(2));
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioNaoCadastrado() {
		this.c1.exibirCenario(3);
	}
	
	
	
	@Test
	public void testExibirCenarios() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado\n2 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado\n", this.c1.exibirCenarios());
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaCenarioNaoCadastrado() {
		this.c1.cadastrarAposta(3, "Matheus Melanio", 10000, "N VAI ACONTECER");
	}
	
	
	
	@Test
	public void testValorTotalDeApostas() {
		assertEquals(30000, this.c1.valorTotalDeApostas(2));
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioNaoCadastrado() {
		this.c1.valorTotalDeApostas(3);
	}
	
	
	
	@Test
	public void testTotalDeApostas() {
		assertEquals(2, this.c1.totalDeApostas(2));
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasCenarioNaoCadastrado() {
		this.c1.totalDeApostas(3);
	}
	
	
	
	@Test
	public void testExibeApostas() {
		assertEquals("Matheus Melanio - R$100,00 - N VAI ACONTECER\nMatheus Melanio - R$200,00 - N VAI ACONTECER\n", this.c1.exibeApostas(2));
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasCenarioNaoCadastrado() {
		this.c1.exibeApostas(3);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaCenarioNaoCadastrado() throws ApostaFechadaException {
		this.c1.fecharAposta(3, false);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioCenarioNaoCadastrado() throws CenarioAbertoException, CenarioEncerradoException {
		this.c1.getCaixaCenario(3, 0.01);
	}
}
