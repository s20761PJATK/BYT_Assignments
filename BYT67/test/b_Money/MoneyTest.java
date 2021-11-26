package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertTrue(SEK100.getAmount() == 10000);
	}

	@Test
	public void testGetCurrency() {
		assertTrue(EUR10.getCurrency() == EUR);
	}

	@Test
	public void testToString() {
		assertTrue(SEK200.toString().equals("200.00 SEK"));
	}

	@Test
	public void testGlobalValue() {
		assertTrue(EUR20.universalValue() == 3000);
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(EUR10.equals(EUR10));
	}

	@Test
	public void testAdd() {
		assertTrue(SEK0.add(EUR20).getAmount() == 20000);
	}

	@Test
	public void testSub() {
		assertTrue(SEK0.sub(EUR20).getAmount() == -20000);
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());	}

	@Test
	public void testNegate() {
		assertTrue(SEKn100.negate().getAmount() == 10000);
	}

	@Test
	public void testCompareTo() {
		assertTrue(EUR0.compareTo(SEK100) == -1);
	}
}
