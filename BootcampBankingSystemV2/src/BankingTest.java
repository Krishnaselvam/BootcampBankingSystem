import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.addAccount("123456", "password", 500);
        bank.addAccount("789012", "abc123", 1000);
    }

    @Test
    void testDeposit() {
        BankAccount account = bank.getAccount("123456");
        assertNotNull(account);
        double initialBalance = account.printBalance();
        account.deposit(200);
        assertEquals(initialBalance + 200, account.printBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = bank.getAccount("789012");
        assertNotNull(account);
        double initialBalance = account.printBalance();
        account.withdraw(300);
        assertEquals(initialBalance - 300, account.printBalance());
    }

    @Test
    void testTransfer() {
        BankAccount sender = bank.getAccount("789012");
        BankAccount recipient = bank.getAccount("123456");
        assertNotNull(sender);
        assertNotNull(recipient);
        double senderInitialBalance = sender.printBalance();
        double recipientInitialBalance = recipient.printBalance();
        double amount = 200;
        sender.transfer(recipient, amount);
        assertEquals(senderInitialBalance - amount, sender.printBalance());
        assertEquals(recipientInitialBalance + amount, recipient.printBalance());
    }
}
