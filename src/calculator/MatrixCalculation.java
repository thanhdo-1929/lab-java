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
public class MatrixCalculation {
    private int[][] matrix1;
    private int[][] matrix2;

    public int[][] getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(int[][] matrix1) {
        this.matrix1 = matrix1;
    }

    public int[][] getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(int[][] matrix2) {
        this.matrix2 = matrix2;
    }
    
    // Matrix multiply
    public int[][] mulMatrix() {
        int row = matrix1.length;
        int col = matrix2[0].length;
        int col1 = matrix1[0].length;
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < col1; k++) {
                    matrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrix;
    }
    
    // Matrix subtraction
    public int[][] subMatrix(){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrix;
    }
    
    // Matrix addition
    public int[][] addMatrix(){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix;
    }
}
