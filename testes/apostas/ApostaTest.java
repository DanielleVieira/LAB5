package apostas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {

	
	
	private ApostaNaoAssegurada a1;
	
	
	
	@Before
	public void setUp() throws Exception {
		this.a1 = new ApostaNaoAssegurada("Matheus Melanio", 10000, "N VAI ACONTECER");
	}

	
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaApostadorVazio() {
		this.a1 = new ApostaNaoAssegurada("", 10000, "N VAI ACONTECER");
	}

	
	
	@Test(expected = NullPointerException.class)
	public void testApostaApostadorNulo() {
		this.a1 = new ApostaNaoAssegurada(null, 10000, "N VAI ACONTECER");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaValorInvalida() {
		this.a1 = new ApostaNaoAssegurada("Matheus Melanio", 0, "N VAI ACONTECER");
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoVazia() {
		this.a1 = new ApostaNaoAssegurada("Matheus Melanio", 10000, "");
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testApostaPrevisaoNula() {
		this.a1 = new ApostaNaoAssegurada("Matheus Melanio", 10000, null);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoInvalida() {
		this.a1 = new ApostaNaoAssegurada("Matheus Melanio", 10000, "ACONTECER");
	}
	
	
	
	@Test
	public void testToString() {
		assertEquals("Matheus Melanio - R$100,00 - N VAI ACONTECER", this.a1.toString());
	}
}
