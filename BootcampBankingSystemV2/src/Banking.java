import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // Adding some sample accounts
        bank.addAccount("123456", "password", 500);
        bank.addAccount("789012", "abc123", 1000);

        // Creating two bank accounts
        BankAccount account1 = bank.getAccount("123456");
        BankAccount account2 = bank.getAccount("789012");



        // Deposit to account1
        System.out.print("Enter account number for deposit to account1: ");
        int accountNumber1 = scanner.nextInt();
        System.out.print("Enter password: ");
        String password1 = scanner.next();
        System.out.print("Enter deposit amount for Account1: ");
        double depositAmount = scanner.nextDouble();
        account1.deposit(depositAmount);

        // Withdraw from account2
        System.out.print("Enter account number for withdraw from Account2: ");
        int accountNumber2 = scanner.nextInt();
        System.out.print("Enter password: ");
        String abc123 = scanner.next();
        System.out.print("Enter withdrawal amount from account2: ");
        double withdrawAmount = scanner.nextDouble();
        account2.withdraw(withdrawAmount);

        // Print balances
        System.out.println("Balance of Account1: " + account1.printBalance());
        System.out.println("Balance of Account2: " + account2.printBalance());

        // Transfer from account1 to account2
        System.out.print("Enter transfer amount from account1 to account2: ");
        double transferAmount = scanner.nextDouble();
        account1.transfer(account2, transferAmount);

        // Print balances after transfer
        System.out.println("Updated balance of account1: " + account1.printBalance());
        System.out.println("Updated balance of account2: " + account2.printBalance());

        // Ask for statement
        System.out.print("Do you want a statement? (yes/no): ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Statement:");
            System.out.println("Transactions for Account1:");
            account1.printStatement();
            System.out.println("Transactions for Account2:");
            account2.printStatement();
        } else {
            System.out.println("Thanks for using our bank.");
        }

        scanner.close();
    }
}


/* Initial Balance in Account1 is 500 and Account2 is 1000
 The goal of my program is to Deposit a amount in Account1 (500) with account number and password

 It shows one pop-up message that amount will deposit successfully

 Then withdraw amount from Account2 (300) with account number and password

 It also shows one success message

 Then transfer amount from Account1 to Account2 (300)

 Then it will show a balence of two Accounts

 Finally, if user want a statement. If they click yes statement will be provided.

 If they click no Thanks for using our bank this message will be shown
 */


