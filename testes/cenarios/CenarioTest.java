package cenarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioTest {

	
	
	private Cenario c1;
	
	
	
	@Before
	public void setUp() throws Exception {
		this.c1 = new Cenario("A maioria irá tirar mais do que 7 na prova!", 1);
		this.c1.cadastrarAposta("Matheus Melanio", 10000, "N VAI ACONTECER");
		this.c1.cadastrarAposta("Matheus Melanio", 20000, "N VAI ACONTECER");
	}

	
	
	@Test(expected = NullPointerException.class)
	public void testCenarioDescricaoNula() {
		this.c1 = new Cenario(null, 1);
	}

	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoInvalida() {
		this.c1 = new Cenario("  ", 1);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioIDInvalido() {
		this.c1 = new Cenario("  ", 0);
	}
	
	
	
	@Test
	public void testCenario() {
		assertEquals("Nao finalizado", this.c1.getEstado());
		assertEquals(1, this.c1.getId());
	}
	
	
	
	@Test
	public void testToString() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado", this.c1.toString());
	}
	
	
	
	@Test
	public void testValorTotalDeApostas() {
		assertEquals(30000, this.c1.valorTotalDeApostas());
	}
	
	
	
	@Test
	public void testTotalDeApostas() {
		assertEquals(2, this.c1.totalDeApostas());
	}
	
	
	
	@Test
	public void testExibeApostas() {
		assertEquals("Matheus Melanio - R$100,00 - N VAI ACONTECER\nMatheus Melanio - R$200,00 - N VAI ACONTECER\n", this.c1.exibeApostas());
	}
}
