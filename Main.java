public class Main {
    public static void main(String[] args) {
        // 1. Create a Bank instance
        Bank myBank = new Bank();

        // 2. Create some Accounts
        Account account1 = new Account("ACC001", 1500.00);
        Account account2 = new Account("ACC002", 500.00);

        // 3. Create some Customers, linking them to accounts
        Customer customer1 = new Customer("CUST001", "1234", account1);
        Customer customer2 = new Customer("CUST002", "5678", account2);

        // 4. Add Customers to the Bank
        myBank.addCustomer(customer1);
        myBank.addCustomer(customer2);

        // 5. Create an ATM instance, linking it to the Bank
        ATM atm = new ATM(myBank);

        // 6. Start the ATM simulation
        atm.start();
    }
}
