package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertTrue(Nordea.getName() == "Nordea");
	}

	@Test
	public void testGetCurrency() {
		assertTrue(SweBank.getCurrency().equals(SEK));
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		DanskeBank.openAccount("John");
		assertNotNull(DanskeBank.getBalance("John"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		DanskeBank.deposit("Gertrud", new Money(2000, DKK));
		assertTrue(DanskeBank.getBalance("Gertrud") == 2000);
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		Nordea.withdraw("Bob", new Money(300, SEK));
		assertTrue(Nordea.getBalance("Bob") == -300);
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		Nordea.deposit("Bob", new Money(300, SEK));
		assertTrue(Nordea.getBalance("Bob") == 300);
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.transfer("Ulrika", "Bob", new Money(300, SEK));
		assertTrue(SweBank.getBalance("Bob") == 300);
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		DanskeBank.addTimedPayment("Gertrud", "5", 3, 3, new Money(300, SEK) , SweBank, "Bob");
		DanskeBank.removeTimedPayment("Gertrud", "5");
		//Nothing to assert
	}
	
	//Many of the bugs were found by making an example JUnit test, and then seeing that an exception was thrown or any other error occurred
	//Additionally, some bugs were found by making obvious assertions e.g. if we add 300 to an account with 0 balance, we assert that the balance is 300
	//that would fail, meaning that obviously there was a mistake in the code
}
