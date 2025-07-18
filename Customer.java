public class Customer {
    private String customerId;
    private String pin;
    private Account account; // A customer has one account for this simulation simplicity

    public Customer(String customerId, String pin, Account account) {
        this.customerId = customerId;
        this.pin = pin;
        this.account = account;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
}
