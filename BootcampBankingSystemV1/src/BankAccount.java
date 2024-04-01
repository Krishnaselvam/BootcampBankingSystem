public class BankAccount {
    private double balance;

    // Default constructor
    public BankAccount() {
        // Empty constructor
    }

    // Constructor with parameter for setting balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to print balance
    public double printBalance() {
        System.out.println("Current Balance: " + balance);
        return balance;
    }

    // Method to transfer balance from one account to another
    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            recipient.deposit(amount);
            System.out.println(amount + " transferred successfully.");
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }
}
