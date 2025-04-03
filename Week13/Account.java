import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList;

    /**
     * .
     */
    public Account() {
        accountNumber = 0;
        balance = 0;
        transactionList = new ArrayList<>();
    }

    /**
     * .
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * .
     */
    public void doWithdrawing(double amount) throws BankException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance -= amount;
        }
    }

    /**
     * .
     */
    public void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * .
     */
    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lịch sử giao dịch của tài khoản ");
        sb.append(accountNumber);
        sb.append(":\n");
        for (Transaction transaction : transactionList) {
            sb.append(transaction.getTransactionSummary());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     *.
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     *.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account other = (Account) obj;
            return accountNumber == other.accountNumber;
        }
        return false;
    }
}