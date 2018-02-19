package sistema;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptions.ApostaFechadaException;
import exceptions.CenarioAbertoException;
import exceptions.CenarioEncerradoException;

public class SistemaDeApostasTest {

	
	
	private SistemaDeApostas s1;
	private static final int VALOR_CAIXA = 100000;
	private static final double VALOR_TAXA = 0.01;
	
	
	
	@Before
	public void setUp() throws Exception {
		this.s1 = new SistemaDeApostas(VALOR_CAIXA, VALOR_TAXA);
	}

	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSistemaDeApostasTaxaMenorQueZero() {
		this.s1 = new SistemaDeApostas(VALOR_CAIXA, -0.01);
	}

	
		
	@Test(expected = IllegalArgumentException.class)
	public void testSistemaDeApostasCaixaMenorQueZero() {
		this.s1 = new SistemaDeApostas(-1, VALOR_TAXA);
	}
	
	
	
	@Test
	public void testGetCaixa() {
		assertEquals(VALOR_CAIXA, this.s1.getCaixa());
	}

	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioCenarioInvalido() {
		this.s1.exibirCenario(-1);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioBonusInvalido() {
		this.s1.cadastrarCenario("As provas vao ser corrigidas ate sexta", 0);
	}

	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaCenarioInvalido() {
		this.s1.cadastrarAposta(0, "Matheus Melanio", 10000, "N VAI ACONTECER");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioInvalido() {
		this.s1.valorTotalDeApostas(0);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasCenarioInvalido() {
		this.s1.valorTotalDeApostas(0);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasCenarioInvalido() {
		this.s1.exibeApostas(0);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaCenarioInvalido() throws ApostaFechadaException {
		this.s1.fecharAposta(0, false);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testgetCaixaCenarioCenarioInvalido() throws CenarioAbertoException, CenarioEncerradoException {
		this.s1.getCaixaCenario(0);
	}

}
