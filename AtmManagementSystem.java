import java.util.InputMismatchException;
import java.util.Scanner;

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("******** WELCOME TO ATM ********");
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Exiting ATM. Thank You!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
                choice = 0; // Reset choice to force menu re-display
            }
        } while (choice != 4);
        scanner.close(); // Closing the scanner to prevent resource leakage
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + String.format("%.2f", account.getBalance()));
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        try {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                account.deposit(amount);
            } else {
                System.out.println("Invalid amount for deposit!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        try {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                account.withdraw(amount);
            } else {
                System.out.println("Invalid amount for withdrawal!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // Clear the buffer
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Money Deposited: $" + String.format("%.2f", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Money Withdrawn: $" + String.format("%.2f", amount));
        } else {
            System.out.println("Insufficient funds for withdrawal!");
        }
    }
}

public class AtmManagementSystem {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
