package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertTrue(SEK.getName() == "SEK");
	}
	
	@Test
	public void testGetRate() {
		assertTrue(DKK.getRate() == 0.20);
	}
	
	@Test
	public void testSetRate() {
		EUR.setRate(1.6);
		assertTrue(EUR.getRate() == 1.6);
	}
	
	@Test
	public void testGlobalValue() {
		assertTrue(SEK.universalValue(100) == 15);
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertTrue(DKK.valueInThisCurrency(100, SEK) == 75);
	}

}
