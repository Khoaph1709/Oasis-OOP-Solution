import java.util.Scanner;

/**                 
   This program demonstrates the Time class.
*/

public class TimeDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        char answer = 'Y';			
        String enteredTime;
        String response;

        while (//CHECK ANSWER AFTER CONVERTING TO CAPITAL)
        {
            System.out.print("Enter a military time " +
                             "using the ##:## format: ");
            enteredTime = keyboard.nextLine();
            Time now = new Time (enteredTime);
            System.out.println("Do you want to enter " +
                               "another (Y/N)? ");
            response = keyboard.nextLine();
            answer = response.charAt(0);
        }
    }     
}
