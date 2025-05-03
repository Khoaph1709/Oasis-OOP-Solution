public class CreditCard {
    private Money balance;
    private Money creditLimit;
    private Person owner;

    public CreditCard(Person newCardHolder, Money limit) {
        owner = newCardHolder;
        creditLimit = limit;
        balance = new Money(0);
    }

    public Money getBalance() {
        Money copy = new Money(balance);
        return copy;
    }

    public Money getCreditLimit() {
        Money copy = new Money(creditLimit);
        return copy;
    }

    public String getPersonals() {
        return owner.toString();
    }

    public void charge(Money amount) {
        Money newBalance = balance.add(amount);
        if (newBalance.compareTo(creditLimit) > 0) {
            System.out.println("Charge denied.");
        } else {
            System.out.println("Charge: " + amount.toString());
            balance = newBalance;
        }
    }

    public void payment(Money amount) {
        Money newBalance = balance.subtract(amount);
        if (newBalance.compareTo(new Money(0)) < 0) {
            System.out.println("Exceeds credit limit");
        } else {
            System.out.println("Payment: " + amount.toString());
            balance = newBalance;
        }
    }
}
