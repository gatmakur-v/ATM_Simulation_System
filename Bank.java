public class Bank {
    private Customer[] customers; // Using an array instead of HashMap as requested
    private int customerCount;
    private static final int MAX_CUSTOMERS = 10; // Max customers for this simple array implementation

    public Bank() {
        this.customers = new Customer[MAX_CUSTOMERS];
        this.customerCount = 0;
    }

    public void addCustomer(Customer customer) {
        if (customerCount < MAX_CUSTOMERS) {
            customers[customerCount] = customer;
            customerCount++;
        } else {
            System.out.println("Bank is full, cannot add more customers.");
        }
    }

    public Customer findCustomerById(String customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(customerId)) {
                return customers[i];
            }
        }
        return null; // Customer not found
    }
}
