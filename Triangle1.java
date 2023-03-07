/**
 * this program receives 3 lengths of a triangle sides,calculates the area and the perimeter of a given triangle,
 and notify the user of the end result.
 *
 * @author Elad Sopher
 * @version 10/11/2022
 */
import java.util.Scanner;
public class Triangle1
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the area "
                + "and the perimeter of a given triangle. ");
        System.out.println ("Please enter the three lengths"
                + " of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        //using the heron formula to find the area of the triangle
        double s = (Math.sqrt((a+b+c)*(a+b-c)*(b+c-a)*(c+a-b)))/4;
        System.out.println ("The lengths of the triangle sides are: "+ a +"," + b +"," + c + ".");
        System.out.println ("The perimeter of the triangle is: "+(a+b+c));
        System.out.println ("The area of the triangle is: "+ s);
    } // end of method main
} //end of class Triangle1