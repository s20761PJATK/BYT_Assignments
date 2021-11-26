package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("5", 3, 3, new Money(1000, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("5"));
		
		testAccount.removeTimedPayment("5");
		assertFalse(testAccount.timedPaymentExists("5"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("5", 3, 3, new Money(1000, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("5"));
		//I'm not certain what we're trying to test here? I already tested the "add timed payment" method above
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(20000, SEK));
		assertTrue(testAccount.getBalance().getAmount() == 10000000-20000);
	}
	
	@Test
	public void testGetBalance() {
		assertTrue(testAccount.getBalance().equals(new Money(10000000, SEK)));
	}
}
