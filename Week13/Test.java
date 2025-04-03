public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer(704686599, "John Doe");
        Account account = new CheckingAccount(704686599, 30000);

        account.deposit(50000.25);
        account.deposit(2000.25);
        account.withdraw(900.27);
        account.deposit(8000.77);
        System.out.println(account.getTransactionHistory());

        

    }
}
