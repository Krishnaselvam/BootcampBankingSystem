import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating two bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(500); // Set initial balance for account2


        // Deposit to account1
        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = scanner.nextDouble();
        account1.deposit(depositAmount);

        // Withdraw from account2
        System.out.print("Enter withdrawal amount from account2: ");
        double withdrawAmount = scanner.nextDouble();
        account2.withdraw(withdrawAmount);

        // Print balances
        System.out.println("Balance of account1: " + account1.printBalance());
        System.out.println("Balance of account2: " + account2.printBalance());

        // Transfer from account1 to account2
        System.out.print("Enter transfer amount from account1 to account2: ");
        double transferAmount = scanner.nextDouble();
        account1.transfer(account2, transferAmount);

        // Print balances after transfer
        System.out.println("Updated balance of account1: " + account1.printBalance());
        System.out.println("Updated balance of account2: " + account2.printBalance());

        scanner.close();
    }
}

