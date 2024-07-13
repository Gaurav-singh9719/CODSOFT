import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;
    private String accountHolder;
    private String accountNumber;

    // Constructor to set up account with holder's details
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter method for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid transaction. Please check your balance and try again.");
        }
    }

    // Method to display account holder's details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

// ATM class to interact with the bank account
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to handle user interface
    public void startATM() {
        while (true) {
            System.out.println("Welcome, " + account.getAccountHolder() + "! Please choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: $" + account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    account.displayAccountDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder's name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNum = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(holderName, accountNum, initialBalance);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.startATM();
    }
}
