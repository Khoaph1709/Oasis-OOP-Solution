public class SavingsAccount extends BankAccount {
    private double rate;
    private int savingsNumber;
    private String accountNumber;

    public SavingsAccount(String name, double amount) {
        super(name, amount);
        rate = 0.05; // Default interest rate
        savingsNumber = 0; // Default savings number
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        rate = oldAccount.rate;
        savingsNumber = oldAccount.savingsNumber + 1; // Increment savings number for new account
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() {
        double interest = getBalance() * rate / 12; // Monthly interest
        deposit(interest);
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}
