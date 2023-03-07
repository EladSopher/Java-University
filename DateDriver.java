import java.util.*;
/**
 * This program receives a day, a month and a year from the user,
 * creates two dates objects with these values and print them,
 * then checks if the dates are the same and print "Same date" or "Different dates" accordingly,
 * then updates the month of the first date to a different value, and updates the year of the second date to the year after,
 * then prints the second date based on the DD/MM/YYYY format, and checks if the dates are equal,
 * if the dates are different, print the date before and then the date after.
 *
 * @author Elad Sopher
 * @version 03/12/22
 */
public class DateDriver
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println ("This program demonstrates the "
                + "usage of Date class.");
        System.out.println ("Please enter the day, month, year"
                + " of the first date");
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        Date d1 = new Date(day,month,year);
        //creating a new date based on the values of d1
        Date d2 = new Date(d1.getDay(),d1.getMonth(),d1.getYear());
        System.out.println ("d1 = " + d1);
        System.out.println ("d2 = " + d2);
        if(d1.equals(d2))//checks if the two dates are the same
            System.out.println ("Same date");
        else
            System.out.println ("Different date");
        System.out.println ("Please change the month of the first date");
        month = scan.nextInt();
        d1.setMonth(month);
        System.out.println ("updated month in d1: " + d1.getMonth());
        //updates the year of d2 to the following year
        d2.setYear(d2.getYear() + 1);
        System.out.println ("updated year in d2: " + d2.getYear());
        //creating variables in order to print d2 in the DD/MM/YYYY format
        String dayString = (d2.getDay() <= 9) ? "0" + d2.getDay() : d2.getDay() + "";
        String monthString = (d2.getMonth() <= 9) ? "0" + d2.getMonth() : d2.getMonth() + "";
        System.out.println ("d2: " + dayString + "/" + monthString + "/" + d2.getYear());
        if(d1.equals(d2)){
            System.out.println ("Same date");
        } else if(d1.before(d2)){ //checks which date is before and prints
            System.out.println ("before: " + d1);
            System.out.println ("after: " + d2);
        } else {
            System.out.println ("before: " + d2);
            System.out.println ("after: " + d1);
        }
    } // end of method main
} //end of class DateDriver