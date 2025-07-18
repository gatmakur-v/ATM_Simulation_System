import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Customer currentCustomer;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        authenticateUser(customerId, pin);
    }

    private void authenticateUser(String customerId, String pin) {
        Customer customer = bank.findCustomerById(customerId);
        if (customer != null && customer.authenticate(pin)) {
            currentCustomer = customer;
            System.out.println("Authentication successful. Welcome, " + customerId + "!");
            showMenu();
        } else {
            System.out.println("Invalid Customer ID or PIN. Please try again.");
            // Optionally restart or exit
            start();
        }
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    currentCustomer = null; // Log out
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        if (currentCustomer != null) {
            System.out.println("Current Balance: $" + String.format("%.2f", currentCustomer.getAccount().getBalance()));
        }
    }

    private void deposit() {
        if (currentCustomer != null) {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            currentCustomer.getAccount().deposit(amount);
            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", currentCustomer.getAccount().getBalance()));
        }
    }

    private void withdraw() {
        if (currentCustomer != null) {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            if (currentCustomer.getAccount().withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", currentCustomer.getAccount().getBalance()));
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }
    }
}

