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
public class Main {

    private static MatrixCalculation calculator = new MatrixCalculation();
    private static MatrixView view = new MatrixView();
    private static DataInput dataInput = new DataInput();
    private static int row1, col1, row2, col2;
    
    // Calculate 2 matrix and display  
    private static void calMatrix(int option, String operator){
        System.out.println("-------- Result --------");
        view.matrixDisplay(calculator.getMatrix1());
        System.out.println(operator);
        view.matrixDisplay(calculator.getMatrix2());
        System.out.println("=");
        if(option == 1){
            view.matrixDisplay(calculator.addMatrix());
        }else if(option == 2){
            view.matrixDisplay(calculator.subMatrix());
        }else{
            view.matrixDisplay(calculator.mulMatrix());
        }
    }
    
    // Add element into 2 matrix
    private static void addElement(int option){
        row1 = view.inputRow(1);
        col1 = view.inputCol(1);
        calculator.setMatrix1(view.inputElement(row1, col1, 1));
        while (true) {                        
            row2 = view.inputRow(2);
            col2 = view.inputCol(2);
            if(option == 1 || option == 2){
                if(row1 == row2 && col1 == col2) break;
                else System.out.println("2 matrix must have same row col!");
            }else{
                if(col1 == row2) break;
                else System.out.println("Row of matrix1 must equal column matrix2!");
            }
        }
        calculator.setMatrix2(view.inputElement(row2, col2, 2));
    }
    
    public static void main(String[] args) {
        while(true){
            System.out.println("=======Calculator Program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = dataInput.inputInt(1, 4, "Your choice must from 1-4!", 
                    "Your choice: ");
            if(choice == 4) break;
            switch(choice){
                case 1:
                    System.out.println("------ Addition ------");
                    addElement(choice);
                    calMatrix(choice, "+");
                    break;
                case 2:
                    System.out.println("------ Subtraction ------");
                    addElement(choice);
                    calMatrix(choice, "-");
                    break;
                case 3:
                    System.out.println("------ Multiplication ------");
                    addElement(choice);
                    calMatrix(choice, "*");
                    break;
            }
        }
    }
    
}
