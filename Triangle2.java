/**
 * this program receives 3 lengths of a triangle sides,determines what type of a triangle it is based of the lenghts,
 and notify the user of the end result.
 *
 * @author Elad Sopher
 * @version 10/11/2022
 */
import java.util.Scanner;
public class Triangle2
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program checks what type "
                + "of a triangle the lenghts of the sides create. ");
        System.out.println ("Please enter the three lengths"
                + " of the triangle's sides");
        int X = scan.nextInt();
        int Y = scan.nextInt();
        int Z = scan.nextInt();
        if (X>0 && Y>0 && Z>0 && (X+Y)>Z && (X+Z)>Y && (Y+Z)>X && X>0 && Y>0 && Z>0)//checks if the numbers given are legal and can create a triangle
        {
            if (X==Y && X==Z)//the parameters for an equilateral triangle
                System.out.println ("The numbers: "+X +","+ Y +" and "+ Z +" represent an equilateral triangle.");
            else if (X==Y || Y==Z || X==Z)//the parameters for an isosceles triangle
                System.out.println ("The numbers: "+X +","+ Y +" and "+ Z +" represent an isosceles triangle.");
            else if ((X*X + Y*Y == Z*Z) || (X*X + Z*Z == Y*Y) || (Z*Z + Y*Y == X*X))//using the pythagoras theorem
                System.out.println ("The numbers: "+X +","+ Y +" and "+ Z +" represent a right-angle triangle.");
            else
                System.out.println ("The numbers: "+X +","+ Y +" and "+ Z +" represent a common triangle.");
        }
        else
            System.out.println ("The numbers: "+X +","+ Y +" and "+ Z +" cannot represent a triangle.");
    }//end of method main 
}//end of class Triangle2