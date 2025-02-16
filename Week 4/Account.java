import java.util.ArrayList;


public class Account {
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transactionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transactionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n", i + 1, transactionList.get(i).getAmount(), transactionList.get(i).getBalance());
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n", i + 1, transactionList.get(i).getAmount(), transactionList.get(i).getBalance());
            }
        }
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(2000.255, "deposit");
        acc.addTransaction(1000, "withdraw");
        acc.printTransaction();
    }
}
