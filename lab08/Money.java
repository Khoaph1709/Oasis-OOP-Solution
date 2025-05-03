/**			
   This class represents nonnegative amounts of money.
*/

public class Money
{
    // The number of dollars
    private long dollars;

    // The number of cents
    private long cents;

    /**
      Constructor
      @param amount The amount in decimal format.
    */

    public Money(double amount)
    {
        if (amount < 0)
        {
            System.out.println("Error: Negative amounts " +
                               "of money are not allowed.");
            System.exit(0);				
        }
        else
        {
            long allCents = Math.round(amount * 100);
			dollars = allCents / 100;
            cents = allCents % 100;
        }
    }  

    // ADD LINES FOR TASK #1 HERE
    // Document and write a copy constructor
    /**
     * Copy constructor
     * @param otherAmount The amount of money to copy.
     */
    public Money(Money otherAmount) {
        dollars = otherAmount.dollars;
        cents = otherAmount.cents;
    }

    /**
      The add method
      @param otherAmount The amount of money to add.
      @return The sum of the calling Money object
              and the parameter Money object.
    */

    public Money add(Money otherAmount)
    {
        Money sum = new Money(0);

        sum.cents = cents + otherAmount.cents;

        long carryDollars = sum.cents / 100;

        sum.cents = sum.cents % 100;

        sum.dollars = dollars +
                      otherAmount.dollars +
                      carryDollars;

        return sum;
    }

    /**
      The subtract method
      @param amount The amount of money to subtract.
      @return The difference between the calling Money
              object and the parameter Money object.
    */

    public Money subtract (Money amount)
    {
        Money difference = new Money(0);

        if (cents < amount.cents)
        {
            dollars = dollars - 1;
            cents = cents + 100;
        }

        difference.dollars = dollars - amount.dollars;
        difference.cents = cents - amount.cents;

        return difference;
    }

    /**
      The compareTo method
      @param amount The amount of mony to compare against.
      @return -1 if the dollars and the cents of the
              calling object are less than the dollars and
              the cents of the parameter object.
			  0 if the dollars and the cents of the calling
              object are equal to the dollars and cents of
              the parameter object.               
              1 if the dollars and the cents of the calling
              object are more than the dollars and the
              cents of the parameter object.
    */

    public int compareTo(Money amount)
    {
        int value;

        if(dollars < amount.dollars)
            value = -1;
        else if (dollars > amount.dollars)
            value = 1;
        else if (cents < amount.cents)
            value = -1;
        else if (cents > amount.cents)
            value = 1;
        else
            value = 0;

        return value;
    }

    // ADD LINES FOR TASK #2 HERE
    // Document and write an equals method
    // Document and write a toString method
    public boolean equals(Object otherAmount) {
        if (otherAmount instanceof Money) {
            Money other = (Money) otherAmount;
            return dollars == other.dollars && cents == other.cents;
        }
        return false;
    }

    public String toString() {
        return "$" + dollars + "." + (cents < 10 ? "0" : "") + cents;
    }
}
