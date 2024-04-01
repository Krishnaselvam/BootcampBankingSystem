import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banking {
    private static final Logger logger = Logger.getLogger(Banking.class.getName());

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Bank bank = new Bank();

            // Adding some sample accounts
            bank.addAccount("123456", "password", 500);
            bank.addAccount("789012", "abc123", 1000);

            // Creating two bank accounts
            BankAccount account1 = bank.getAccount("123456");
            BankAccount account2 = bank.getAccount("789012");

            // Prompt for input and log output
            try (PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {
                // Deposit to account1
                printWriter.print("Enter account number for deposit to account1: ");
                int accountNumber1 = scanner.nextInt();
                printWriter.println(accountNumber1);

                printWriter.print("Enter password: ");
                String password1 = scanner.next();
                printWriter.println(password1);

                printWriter.print("Enter deposit amount for Account1: ");
                double depositAmount = scanner.nextDouble();
                printWriter.println(depositAmount);
                account1.deposit(depositAmount);

                // Withdraw from account2
                printWriter.print("Enter account number for withdraw from Account2: ");
                int accountNumber2 = scanner.nextInt();
                printWriter.println(accountNumber2);

                printWriter.print("Enter password: ");
                String abc123 = scanner.next();
                printWriter.println(abc123);

                printWriter.print("Enter withdrawal amount from account2: ");
                double withdrawAmount = scanner.nextDouble();
                printWriter.println(withdrawAmount);
                account2.withdraw(withdrawAmount);

                // Print balances
                printWriter.println("Balance of Account1: " + account1.printBalance());
                printWriter.println("Balance of Account2: " + account2.printBalance());

                // Transfer from account1 to account2
                printWriter.print("Enter transfer amount from account1 to account2: ");
                double transferAmount = scanner.nextDouble();
                printWriter.println(transferAmount);
                account1.transfer(account2, transferAmount);

                // Print balances after transfer
                printWriter.println("Updated balance of account1: " + account1.printBalance());
                printWriter.println("Updated balance of account2: " + account2.printBalance());

                // Ask for statement
                printWriter.print("Do you want a statement? (yes/no): ");
                String choice = scanner.next();
                printWriter.println(choice);

                if (choice.equalsIgnoreCase("yes")) {
                    printWriter.println("Statement:");
                    printWriter.println("Transactions for Account1:");
                    account1.printStatement(printWriter);
                    printWriter.println("Transactions for Account2:");
                    account2.printStatement(printWriter);
                } else {
                    printWriter.println("Thanks for using our bank.");
                }
            }

            // Close resources
            scanner.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
