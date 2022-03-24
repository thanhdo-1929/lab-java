/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Admin
 */
public class MatrixView {
    private DataInput dataInput = new DataInput();
    
    // Input matrix's element view
    public int[][] inputElement(int row, int col, int matrixOrder){
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String title = "Enter Matrix" + matrixOrder + 
                        "[" + (i+1) + "][" + (j+1) + "]:";
                matrix[i][j] = dataInput.inputInt(Integer.MIN_VALUE, 
                        Integer.MAX_VALUE, "Values of matrix is digit!", title);
            }
        }
        return matrix;
    }
    
    // Input number of row view
    public int inputRow(int matrixOrder){
        int row;
        String title = "Enter Row Matrix " + matrixOrder + ":";
        row = dataInput.inputInt(1, Integer.MAX_VALUE, 
                "Row of matrix must be a positive integer!", title);
        return row;
    }
    
    // Input number of column view
    public int inputCol(int matrixOrder){
        int col;
        String title = "Enter Column Matrix " + matrixOrder + ":";
        col = dataInput.inputInt(1, Integer.MAX_VALUE, 
                "Column of matrix must be a positive integer!", title);
        return col;
    }
    
    // Display matrix view
    public void matrixDisplay(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
}
