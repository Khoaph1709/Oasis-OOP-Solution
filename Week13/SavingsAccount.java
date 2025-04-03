public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * .
     */
    @Override
    public void withdraw(double amount) {
        try {
            double initialBalance = getBalance();
            if (initialBalance >= 5000 && amount <= 1000) {
                doWithdrawing(amount);
                double finalBalance = getBalance();
                addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, 
                amount, initialBalance, finalBalance));
            }
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * .
     */
    @Override
    public void deposit(double amount) {
        try {
            double initialBalance = this.getBalance();
            doDepositing(amount);
            double finalBalance = this.getBalance();
            this.addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, 
            amount, initialBalance, finalBalance));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
