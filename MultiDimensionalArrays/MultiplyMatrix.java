package MultiDimensionalArrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MultiplyMatrix {

    /**
     *
     * Refrence -> https://www.mathsisfun.com/algebra/matrix-multiplying.html
     *
     * Matrix A -> 1    2    3           Matrix B -> 7  |  8
     *             -----------                      ---------
     *             4    5    6                       9  |  10
     *                                              ---------
     *                                               11 |  12
     *
     *          Mulitplication -> 58  |  64
     *                            ---------
     *                            139 | 154
     *
     * Condition -> Columns of 1st Matrix equals Rows of 2nd Matrix (2 X 2)
     *
     * Approach -> Create new 2D-Array [Rows of 1st Matrix][Columns of 2nd Matrix]
     *             array[0][0] = (1X7)+(2X9)+(3X11) = 58
     *             array[0][1] = (1X8)+(2X10)+(3X12) = 64
     *             array[1][0] = (4X7)+(5X9)+(6X11) = 139
     *             array[1][1] = (4X8)+(5X10)+(6X12) = 154
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println("Matrix One");
        int[][] matrixOne = new int[r1][c1];
        for (int i=0 ; i<matrixOne.length ; i++){
            for (int j=0 ; j<matrixOne[0].length ; j++){
                matrixOne[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix Two");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] matrixTwo = new int[r2][c2];
        for (int i=0 ; i<matrixTwo.length ; i++){
            for (int j=0 ; j<c2 ; j++){
                matrixTwo[i][j] = sc.nextInt();
            }
        }

        if (c1!=r2){
            System.out.println("Columns of first Matrix must be equal to Rows of second Matrix");
            return;
        }

        int[][] multiplication = new int[r1][c2];
        for (int i=0 ; i<r1 ; i++){
            for (int j=0 ; j<c2 ; j++){
                for (int m=0 ; m<r2 ; m++){
                    multiplication[i][j]+= matrixOne[i][m] * matrixTwo[m][j];
                }
            }
        }

        for (int i=0 ; i<multiplication.length ; i++){
            for(int j=0 ; j<multiplication[0].length ; j++){
                System.out.print(multiplication[i][j] + " ");
            }
            System.out.println();
        }
    }
}
