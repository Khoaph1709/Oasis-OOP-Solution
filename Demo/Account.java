import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList;

    public Account() {
        this.accountNumber = 0;
        this.balance = 0;
        this.transactionList = new ArrayList<>();
    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void doWithdrawing(double amount) throws BankException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        } else if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance -= amount;
        }
    }

    public void doDepositing(double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    public String getTransactionHistory() {
        String result = "Lịch sử giao dịch của tài khoản " + accountNumber + ":\n";
        for (Transaction transaction : transactionList) {
            result += transaction.getTransactionSummary() + "\n";
        }
        return result;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account other = (Account) obj;
            return accountNumber == other.accountNumber;
        }
        return false;
    }
}
