package lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumeroPorExtensoTest {

	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testComportamento1() throws Exception {
		assertEquals("zero", NumeroPorExtenso.converte(0));
		assertEquals("um", NumeroPorExtenso.converte(1));
		assertEquals("dois",NumeroPorExtenso.converte(2));
		assertEquals("sete", NumeroPorExtenso.converte(7));
		assertEquals("nove", NumeroPorExtenso.converte(9));
		assertEquals("dez", NumeroPorExtenso.converte(10));
	}
	
	@Test
	public void testComportamento2() throws Exception {
		assertEquals("vinte", NumeroPorExtenso.converte(20));
		assertEquals("onze", NumeroPorExtenso.converte(11));
		assertEquals("dezessete", NumeroPorExtenso.converte(17));
		assertEquals("dezoito", NumeroPorExtenso.converte(18));
		assertEquals("dezenove", NumeroPorExtenso.converte(19));
		assertEquals("treze", NumeroPorExtenso.converte(13));
	}
	
	@Test
	public void testComportamento3() throws Exception {
		assertEquals("vinte e três", NumeroPorExtenso.converte(23));
		assertEquals("quarenta e um", NumeroPorExtenso.converte(41));
		assertEquals("setenta e sete", NumeroPorExtenso.converte(77));
		assertEquals("cinquenta e oito", NumeroPorExtenso.converte(58));
		assertEquals("noventa e nove", NumeroPorExtenso.converte(99));
		assertEquals("sessenta e três",NumeroPorExtenso.converte(63));
	}
	
	@Test
	public void testComportamento4() throws Exception {
		assertEquals("cento e três", NumeroPorExtenso.converte(103));
		assertEquals("duzentos e três", NumeroPorExtenso.converte(203));
		assertEquals("duzentos e trinta e três", NumeroPorExtenso.converte(233));
		assertEquals("quatrocentos e cinquenta e um", NumeroPorExtenso.converte(451));
		assertEquals("setecentos e sessenta e sete", NumeroPorExtenso.converte(767));
		assertEquals("quinhentos e vinte e oito", NumeroPorExtenso.converte(528));
		assertEquals("novecentos e sessenta e nove", NumeroPorExtenso.converte(969));
		assertEquals("seiscentos e trinta e oito",NumeroPorExtenso.converte(638));
	}
	@Test
	public void testComportamento5() throws Exception {
		assertEquals("um mil e um", NumeroPorExtenso.converte(1001));
		assertEquals("um mil e cem", NumeroPorExtenso.converte(1100));
		assertEquals("dois mil duzentos e setenta e oito", NumeroPorExtenso.converte(2278));
		assertEquals("quatro mil setecentos e sessenta e sete", NumeroPorExtenso.converte(4767));
		assertEquals("quatro mil quinhentos e vinte e oito", NumeroPorExtenso.converte(4528));
		assertEquals("quatro mil novecentos e sessenta e nove", NumeroPorExtenso.converte(4969));
		assertEquals("quatro mil seiscentos e trinta e oito",NumeroPorExtenso.converte(4638));
	}
	@Test
	public void testComportamento6() throws Exception {
		assertEquals("cem mil", NumeroPorExtenso.converte(100000));
		assertEquals("cem mil e um", NumeroPorExtenso.converte(100001));
		assertEquals("duzentos mil quatrocentos e um", NumeroPorExtenso.converte(200401));
		assertEquals("novecentos e quarenta mil quatrocentos e um", NumeroPorExtenso.converte(940401));
		assertEquals("novecentos e quarenta e quatro mil quatrocentos e um", NumeroPorExtenso.converte(944401));
		assertEquals("um milhão novecentos e quarenta e quatro mil quatrocentos e um", NumeroPorExtenso.converte(1944401));
		assertEquals("quatrocentos e vinte milhões novecentos e quarenta e quatro mil quatrocentos e um", NumeroPorExtenso.converte(420944401));
		assertEquals("novecentos e noventa e nove milhões novecentos e noventa e nove mil novecentos e noventa e nove", NumeroPorExtenso.converte(999999999));
	}

}
