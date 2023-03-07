import java.util.*;
/**
 * This program receives an id, type, brand and the type of gear of a car from the user for two car objects
 * then checks if the parameters received are valid and prints the two cars,
 * then checks if the cars are the same and prints "Same car" or "Different cars" accordingly,
 * then inverse the gear of the first car and prints the first car,
 * then checks which car is the better car and prints it, if there isn't one,print nothing.
 *
 * @author Elad Sopher
 * @version 04/12/22
 */
public class CarDriver
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        final int MAX_OR_DEFAULT_ID = 9999999;
        final int MIN_ID = 1000000;
        final char DEFAULT_TYPE = 'A';

        System.out.println ("Please enter the first car's ID,Type,Brand,IsManual:");
        int id = scan.nextInt();
        scan.nextLine();
        //checks if id is valid
        id = (id >= MIN_ID && id <= MAX_OR_DEFAULT_ID) ? id : MAX_OR_DEFAULT_ID;
        String stringType = scan.nextLine();
        char type = stringType.charAt(0);
        //checks if type is invalid
        if(type != 'A' && type != 'B' && type != 'C' && type != 'D')
        {
            type = DEFAULT_TYPE;
        }
        String brand = scan.nextLine();
        boolean isManual = scan.nextBoolean();
        Car c1 = new Car (id,type,brand,isManual);

        System.out.println ("Please enter the second car's ID,Type,Brand,IsManual:");
        id = scan.nextInt();
        scan.nextLine();
        id = (id > MIN_ID && id < MAX_OR_DEFAULT_ID) ? id : MAX_OR_DEFAULT_ID;
        stringType = scan.nextLine();
        type = stringType.charAt(0);
        if(type != 'A' && type != 'B' && type != 'C' && type != 'D')
        {
            type = DEFAULT_TYPE;
        }
        brand = scan.nextLine();
        isManual = scan.nextBoolean();
        Car c2 = new Car (id,type,brand,isManual);

        System.out.println ("First car");
        System.out.println (c1);
        System.out.println ("\nSecond car");
        System.out.println (c2);
        //checks if c1 and c2 are the same
        if(c1.getType() == c2.getType() && c1.getBrand().equals(c2.getBrand()) && c1.isManual() == c2.isManual())
        {
            System.out.println ("\nSame car.");
        }
        else
        {
            System.out.println ("\nDifferent cars.");
        }

        c1.setIsManual(!c1.isManual());//inverse the gear of c1
        System.out.println ("\n" + c1);
        //checks which car is better
        if(c1.better(c2))
        {
            System.out.println ("\nThe better car is: \n" + c1);
        }
        else if (c2.better(c1))
        {
            System.out.println ("\nThe better car is: \n" + c2);
        }
    }// end of method main
}//end of class CarDriver