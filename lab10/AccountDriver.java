/**
   This program demonstrates the BankAccount and
   derived classes.
*/

public class AccountDriver
{
    public static void main(String[] args)
    {
        double put_in = 500;
        double take_out = 1000;

        String money;
        String money_in;
        String money_out;
        boolean completed;

        // Test the CheckingAccount class.
        CheckingAccount myCheckingAccount =
               new CheckingAccount("Benjamin Franklin", 1000);

        System.out.println("Account Number " +
                           myCheckingAccount.
                           getAccountNumber() +
                           " belonging to " +
                           myCheckingAccount.getOwner());

        money = String.format("%.2f",
                              myCheckingAccount.
                              getBalance());

        System.out.println("Initial balance = $" + money);

        myCheckingAccount.deposit(put_in);

        money_in = String.format("%.2f", put_in);

        money = String.format("%.2f",
                              myCheckingAccount.
                              getBalance());

        System.out.println("After deposit of $" +
                           money_in + ",  balance = $" +
                           money);

        completed = myCheckingAccount.withdraw(take_out);

        money_out = String.format("%.2f", take_out);

        money = String.format("%.2f",
                              myCheckingAccount.
                              getBalance());

        if (completed)
        {
            System.out.println("After withdrawal of $" +
                               money_out + ", balance = $" +
                               money);
        }
        else
        {
            System.out.println("Insuffient funds to " +
                               "withdraw $" + money_out +
                               ", balance = $" + money);
        }

        System.out.println();

        // Test the SavingsAccount class.
        SavingsAccount yourAccount =
                  new SavingsAccount("William Shakespeare", 400);

        System.out.println("Account Number " +
                           yourAccount.getAccountNumber() +
                           " belonging to " +
                           yourAccount.getOwner());

        money = String.format("%.2f",
                              yourAccount.getBalance());

        System.out.println("Initial balance = $" + money);

        yourAccount.deposit(put_in);

        money_in = String.format("%.2f", put_in);

        money = String.format("%.2f",
                              yourAccount.getBalance());

        System.out.println("After deposit of $" +
                           money_in + ", balance = $" +
                           money);

        completed = yourAccount.withdraw(take_out);

        money_out = String.format("%.2f", take_out);

        money = String.format("%.2f",
                              yourAccount.getBalance());

        if (completed)
        {
            System.out.println("After withdrawal of $" +
                               money_out + ", balance = $" +
                               money);
        }
        else
        {
            System.out.println("Insuffient funds " +
                              "to withdraw $" + money_out +
                              ", balance = $" + money);
        }

        yourAccount.postInterest();

        money = String.format("%.2f",
                              yourAccount.getBalance());

        System.out.println("After monthly interest " +
                           "has been posted," +
                           "balance = $" + money);

        System.out.println();

        // Test the copy constructor of the
        // SavingsAccount class.
        SavingsAccount secondAccount =
                    new SavingsAccount(yourAccount, 5);

        System.out.println("Account Number " +
                           secondAccount.
                           getAccountNumber() +
                           " belonging to " +
                           secondAccount.getOwner());

        money = String.format("%.2f",
                              secondAccount.getBalance());

        System.out.println("Initial balance = $" + money);

        secondAccount.deposit(put_in);

        money_in = String.format("%.2f", put_in);

        money = String.format("%.2f",
                              secondAccount.getBalance());

        System.out.println("After deposit of $" + money_in +
                           ", balance = $" + money);

        secondAccount.withdraw(take_out);

        money_out = String.format("%.2f", take_out);

        money  = String.format("%.2f",
                               secondAccount.getBalance());

        if (completed)
        {
            System.out.println("After withdrawal of $" +
                               money_out + ", balance = $" +
                               money);
        }
        else
        {
            System.out.println("Insuffient funds " +
                               "to withdraw $" + money_out +
                               ", balance = $" + money);
        }

        System.out.println();

        // Test to make sure new accounts are
        // numbered correctly.
        CheckingAccount yourCheckingAccount =
                      new CheckingAccount("Issac Newton", 5000);

        System.out.println("Account Number " +
                           yourCheckingAccount.
                           getAccountNumber() +
                           " belonging to " +
                           yourCheckingAccount.getOwner());
    }
}
