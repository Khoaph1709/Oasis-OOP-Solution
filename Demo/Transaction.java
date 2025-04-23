public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;
    
    private int type;
    private double amount;
    private double initialBalance; 
    private double finalBalance;

    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.finalBalance = finalBalance;
        this.initialBalance = initialBalance;
    }

    private String getTransactionTypeString(int type) {
        if (type == TYPE_DEPOSIT_CHECKING) {
            return "Nạp tiền vãng lai";
        } else if (type == TYPE_WITHDRAW_CHECKING) {
            return "Rút tiền vãng lai";
        } else if (type == TYPE_DEPOSIT_SAVINGS) {
            return "Nạp tiền tiết kiệm";
        } else if (type == TYPE_WITHDRAW_SAVINGS) {
            return "Rút tiền tiết kiệm";
        } else {
            return "Không xác định";
        }
    }

    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(type) + ". Số dư ban đầu: $" + initialBalance + ". Số tiền: $" + amount + ". Số dư cuối: $" + finalBalance;
    }
}
