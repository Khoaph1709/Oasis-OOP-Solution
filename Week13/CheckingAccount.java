public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
            double money = this.getBalance();
            doWithdrawing(amount);
            this.addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, 
            amount, money, this.getBalance()));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            double money = this.getBalance();
            doDepositing(amount);
            this.addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, 
            amount, money, this.getBalance()));
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
