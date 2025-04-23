public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void deposit(double amount) {
        try {
            double money = this.getBalance();
            doDepositing(amount);
            this.addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
            amount, money, this.getBalance()));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            double money = this.getBalance();
            if (amount <= 1000 && money >= 5000) {
                doWithdrawing(amount);
                this.addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, money, this.getBalance()));  
            }
            
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }   
}
