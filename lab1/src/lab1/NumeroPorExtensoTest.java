package lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumeroPorExtensoTest {

	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testComportamento1() {
		assertEquals(NumeroPorExtenso.converte(0), "Zero");
		assertEquals(NumeroPorExtenso.converte(1), "Um");
		assertEquals(NumeroPorExtenso.converte(2), "Dois");
		assertEquals(NumeroPorExtenso.converte(7), "Sete");
		assertEquals(NumeroPorExtenso.converte(9), "Nove");
		assertEquals(NumeroPorExtenso.converte(10), "Dez");
	}
	
	@Test
	public void testComportamento2() {
		assertEquals(NumeroPorExtenso.converte(20), "Vinte");
		assertEquals(NumeroPorExtenso.converte(11), "Onze");
		assertEquals(NumeroPorExtenso.converte(17), "Dezessete");
		assertEquals(NumeroPorExtenso.converte(18), "Dezoito");
		assertEquals(NumeroPorExtenso.converte(19), "Dezenove");
		assertEquals(NumeroPorExtenso.converte(13), "Treze");
	}
	
	

}
