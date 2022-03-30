/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.util.Scanner;

/**
 *
 * @author 84964
 */
public class DataInput {
    private final Scanner in = new Scanner(System.in);
    
    public int inputInt(int min, int max, String err) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(err);
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputBinary() {
        System.out.print("Enter number binary: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches("[0-1]*")) {
                return result;
            }
            System.err.print("Enter must be 0 or 1, enter again: ");
        }
    }
    
    public String inputDecimal() {
        System.out.print("Enter number decimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches("[0-9]*")) {
                return result;
            }
            System.err.print("Enter must be 0-9, enter again: ");
        }
    }
    
    public String inputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches("[0-9A-F]*")) {
                return result;
            }
            System.err.print("Enter must be 0-9A-F, enter again: ");
        }
    }
}
