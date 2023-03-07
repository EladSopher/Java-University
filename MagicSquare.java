/**
 * This class checks if a givin matrix is a magic square.
 *
 * @author Elad Sopher
 * @version 26/01/23
 */
public class MagicSquare
{
    /**
     * calculates the sum of a row in the matrix
     * @param sumOfRow the total sum of the row
     * @returns the sum
     */
    public static int sumRow(int[][] mat,int row)
    {
        int sumOfRow = 0;
        for(int i = 0; i < mat[0].length; i++)
        {
            sumOfRow += mat[row][i];
        }
        return sumOfRow;
    }

    /**
     * calculates the sum of a column in the matrix
     * @param sumOfCol the total sum of the column
     * @returns the sum
     */
    public static int sumCol(int[][] mat,int col)
    {
        int sumOfCol = 0;
        for(int i = 0; i < mat.length; i++)
        {
            sumOfCol += mat[i][col];
        }
        return sumOfCol;
    }

    /**
     * calculates the sum of the primary diagonal in the matrix
     * @param sumOfDiag the total sum of the primary diagonal
     * @returns the sum
     */
    public static int sumPrimaryDiag(int[][] mat)
    {
        int sumOfDiag = 0;
        for(int i = 0; i < mat.length; i++)
        {
            sumOfDiag += mat[i][i];
        }
        return sumOfDiag;
    }

    /**
     * calculates the sum of the secondary diagonal in the matrix
     * @param sumOfDiag the total sum of the secondary diagonal
     * @returns the sum
     */
    public static int sumSecondaryDiag(int[][] mat)
    {
        int sumOfDiag = 0;
        for(int i = 0, j = mat.length-1; i < mat.length; i++,j--)
        {
            sumOfDiag += mat[i][j];
        }
        return sumOfDiag;
    }

    /**
     * checks if the givin matrix is a magic square
     * magic square - if the sum of every row, column and diagonal are the same
     * @param sum the sum of the first row in the matrix
     * @return false if there is a row,column or a diagonal that have a different sum than the param sum, otherwise return true
     */
    public static boolean isMagicSquare(int[][] mat)
    {
        if(mat.length != mat[0].length)//checks if the given matrix is a square
           return false;
        int sum = sumRow(mat,0);
        //calculates the total value of the matrix using the formula (n^2*(n^2+1))/2 
        int calc = (int)(Math.pow(mat.length,2) * (Math.pow(mat.length,2) + 1))/2;
        if(calc != sum * mat.length)
           return false;
        for(int i = 0; i < mat.length; i++)//checks every row
        {
            if(sumRow(mat,i) != sum)
               return false;
        }
        for(int j = 0; j < mat[0].length; j++)//checks every column
        {
            if(sumCol(mat,j) != sum)
               return false;
        }
        if(sumPrimaryDiag(mat) != sum)
           return false;
        if(sumSecondaryDiag(mat) != sum)
           return false;
        //everything checks so this is a magic square
        return true;
    }
}