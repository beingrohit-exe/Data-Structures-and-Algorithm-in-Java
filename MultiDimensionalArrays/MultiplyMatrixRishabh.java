package MultiDimensionalArrays;

import java.util.Scanner;

public class MultiplyMatrixRishabh {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter rows for matrix 1");
        int row1 = sc.nextInt();
        System.out.println("Enter columns for matrix 1");
        int column1=sc.nextInt();
        int[][] matrix1=new int[row1][column1];

        for(int i=0;i<matrix1.length;i++) {
            System.out.print("enter data for row " + i);
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter rows for matrix 2");
        int row2=sc.nextInt();
        System.out.println("Enter columns for matrix 2");
        int column2=sc.nextInt();

        int[][] matrix2=new int[row2][column2];
        for (int i=0;i<matrix2.length;i++){
            System.out.println("Enter data for row"+i);
            for(int j=0;j<matrix2[0].length;j++){
                matrix2[i][j]=sc.nextInt();
            }
        }

        if(column1!=row2){
            System.out.println("Matrix cannot be multiplied");
            return;
        }
        int[][] resultmatrix=new int[row1][column2];
        for(int i=0;i<resultmatrix.length;i++){
            for(int j=0;j<resultmatrix[0].length;j++){
                for(int k=0;k<row2;k++){
                    resultmatrix[i][j]=resultmatrix[i][j]+matrix1[i][k]*matrix2[k][j];

                }
            }
        }

        for(int i=0;i<resultmatrix.length;i++) {
            for (int j = 0; j < resultmatrix[0].length; j++) {
                System.out.print(resultmatrix[i][j]+"\t \t");
            }
        }
        
    }
}
