/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrix;

import java.util.Scanner;


/**
 *
 * @author ADMIN
 */
public class Matrix {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Matrix m = new Matrix();
        int[][] matrix1 = m.inputMatrix(1);
        int[][] matrix2 = m.inputMatrix(2);

        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = m.checkInputIntLimit("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    m.additionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    m.subtractionMatrix(matrix1, matrix2);
                    break;
                case 3:
                    m.multiplicationMatrix(matrix1, matrix2);
                    break;
                case 4:
                    return;

                default:
                    throw new AssertionError();
            }
        }
    }

    public int checkInputInt(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public int checkInputIntLimit(String input, int min, int max) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public int[][] inputMatrix(int n) {
        int row = checkInputInt("Enter Row of matrix " + n +": ");
        int col = checkInputInt("Enter Col of matrix " + n +": ");
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = checkInputInt(
                        "Enter matrix" + n + "[" + i + "]" + "[" + j + "] : ");
            }
        }
        return matrix;
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
            System.out.println("matrix length = " + matrix.length);
            System.out.println("matrix[0] length = " + matrix[0].length);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || 
            matrix1[0].length != matrix2[0].length) {
            System.err.println("Matrices must have the same dimensions for addition.");
            return;
        }
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");

        int row = matrix1.length;
        int col = matrix1[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix1[i][j] + matrix2[i][j] + "]");
            }
            System.out.println();
        }

    }
     public void subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.err.println("Matrices must have the same dimensions for subtraction.");
            return;
        }
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    public void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.err.println("Number of columns in Matrix 1 must be equal to number of rows in Matrix 2 for multiplication.");
            return;
        }
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    public void testMutiply(int[][] matrix1, int[][] matrix2){
        if(matrix1[0].length != matrix2.length){
            System.out.println("number of collumn 1 must equal to number of"
                    + " row in matrix 2");
            return;
        }
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        //out of length
        int row = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row][col2];
        
        for(int i = 0; i < row; i++){
            for(int j=0;j<col1;j++){
                for (int k=0;k<col2;k++){
                    result[i][j] = matrix1[i][k] * matrix2[k][j];
                }
               System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }
    }
    

}
