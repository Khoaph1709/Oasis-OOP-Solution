public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * .
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * .
     */
    public String getTransactionTypeString(int type) {
        if (type == TYPE_DEPOSIT_CHECKING) {
           return "Nạp tiền vãng lai"; 
        }

        if (type == TYPE_DEPOSIT_SAVINGS) {
            return "Nạp tiền tiết kiệm"; 
        }

        if (type == TYPE_WITHDRAW_CHECKING) {
            return "Rút tiền vãng lai"; 
        }

        if (type == TYPE_WITHDRAW_SAVINGS) {
            return "Rút tiền tiết kiệm";
        }
        return null;
    }

    /** 
     *.
     */
    public String getTransactionSummary() {
        return String.format(
            "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
            getTransactionTypeString(this.type),
            this.initialBalance,
            this.amount,
            this.finalBalance
        );
    }
}
