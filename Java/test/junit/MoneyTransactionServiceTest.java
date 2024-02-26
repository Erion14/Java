package junit;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import exceptions.NotEnoughMoneyException;

@DisplayName("Money Transaction Service Test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTransactionServiceTest {
	private static final String MONEY_AMOUNT_EXCEPTION_MSG = "Money amount should be greater than 0";
	private static final String ACCOUNT_EXCEPTION_MSG = "Accounts shouldn't be null";
	private static final double RANDOM_MONEY_AMOUNT = 200;
	private static final double ZERO_MONEY_AMOUNT = 0;
	private static final double MORE_THAN_RANDOM_MONEY_AMOUNT = 250;
	private static final double NEGATIVE_MONEY_AMOUNT = -1;

	private MoneyTransactionService testInstance;
	
	@BeforeEach
	void setUp() {
		testInstance = new MoneyTransactionService();
	}
	 
	@Test
	void should_Transfer_Money_From_Account_To_Other_Account() {
		//given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);
		
		//when
		testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
		
		assertEquals(ZERO_MONEY_AMOUNT, account1.getMoneyAmount());
		assertEquals(RANDOM_MONEY_AMOUNT, account2.getMoneyAmount());
		
	}
	@Test
	void should_Throw_Exception_If_AccountFrom_Is_Null() {
		Account account1 = null;
		Account account2 = new Account(RANDOM_MONEY_AMOUNT);
		
		var exception = assertThrows(IllegalArgumentException.class, () -> 
				testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT));
		
		assertEquals(ACCOUNT_EXCEPTION_MSG, exception.getMessage());
	}
	
	@Test
	void shouldThrowExceptionIfAccountToIsNull() {
		Account account1 = new Account(RANDOM_MONEY_AMOUNT);
		Account account2 = null;
		
		var exception = assertThrows(IllegalArgumentException.class, () -> 
				testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT));
		
		assertEquals(ACCOUNT_EXCEPTION_MSG, exception.getMessage());
	}
	@Test
	void shouldThrowNotEnoughMoneyExcpetionWhenTransferMoreMoney() {
		Account account1 = new Account(RANDOM_MONEY_AMOUNT);
		Account account2 = new Account(ZERO_MONEY_AMOUNT);
		
		assertThrows(NotEnoughMoneyException.class, () -> 
				testInstance.transferMoney(account1, account2, MORE_THAN_RANDOM_MONEY_AMOUNT));
		
		
	}
	
	@Test
	void shouldThrowExceptionWhenTransferNegativeAmount() {
		var account1 = new Account();
		var account2 = new Account();
		
		var exception = assertThrows(IllegalArgumentException.class, () -> 
		testInstance.transferMoney(account1, account2, NEGATIVE_MONEY_AMOUNT));
		
		assertEquals(MONEY_AMOUNT_EXCEPTION_MSG, exception.getMessage());
	}
	
	@Test
	void shouldThrowExceptionWhenTransferZeroMoneyAmount() {
		var account1 = new Account();
		var account2 = new Account();
		
		var exception = assertThrows(IllegalArgumentException.class, () -> 
		testInstance.transferMoney(account1, account2, ZERO_MONEY_AMOUNT));
		
		assertEquals(MONEY_AMOUNT_EXCEPTION_MSG, exception.getMessage());
	}

	@Test
	void groupedAssertion() {
		//given
				var account1 = new Account(RANDOM_MONEY_AMOUNT);
				var account2 = new Account(ZERO_MONEY_AMOUNT);
				
				//when
				testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
				//then
				
				assertAll("Money Transaction",
				() -> assertEquals(ZERO_MONEY_AMOUNT, account1.getMoneyAmount()),
				() -> assertEquals(RANDOM_MONEY_AMOUNT, account2.getMoneyAmount()));
	}

}
