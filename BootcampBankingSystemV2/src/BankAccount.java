import java.util.HashMap;
import java.util.Map;

class Bank { // In bank class HashMap is used to store bank accounts, with the account number (String)
    private final Map<String, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(String accountNumber, String password, double initialBalance) {
        accounts.put(accountNumber, new BankAccount(accountNumber, password, initialBalance));
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

class BankAccount {
    public final String accountNumber;
    public final String password;
    private double balance;
    private final StringBuilder transactionHistory; // In the BankAccount class,I used StringBuilder to store the transaction history.

    public BankAccount(String accountNumber, String password, double initialBalance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = initialBalance;
        this.transactionHistory = new StringBuilder();
    }



    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.append("Deposit: +").append(amount).append('\n');
            System.out.println(amount + " deposited successfully.");
        } else {
            throw new IllegalArgumentException("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.append("Withdrawal: -").append(amount).append('\n');
            System.out.println(amount + " withdrawn successfully.");
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public double printBalance() {
        System.out.println("Current Balance: " + balance);
        return balance;
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            recipient.deposit(amount);
            transactionHistory.append("Transfer: -").append(amount).append('\n');
            recipient.transactionHistory.append("Transfer: +").append(amount).append('\n');
            System.out.println(amount + " transferred successfully.");
        } else {
            throw new IllegalArgumentException("Invalid transfer amount or insufficient balance.");
        }
    }

    public void printStatement() {
        System.out.println(transactionHistory);
    }
}
