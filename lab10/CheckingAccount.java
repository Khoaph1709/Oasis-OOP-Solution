public class CheckingAccount extends BankAccount {
    private double FEE;

    public CheckingAccount(String name, double amount) {
        super(name, amount);
        FEE = 0.15;
    }

    public boolean withdraw(double amount) {
        boolean completed = false;
        if (amount + FEE <= getBalance()) {
            setBalance(getBalance() - amount - FEE);
            completed = true;
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
        return completed;
    }
}
