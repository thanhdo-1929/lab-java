/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DataInput {
    // Check input Integer inrange
    public int inputInt(int min, int max, String error, String title) {
        Scanner sc = new Scanner(System.in);
	int output;
        while(true){
            try {
                System.out.print(title);
                output = Integer.parseInt(sc.nextLine());
                // Check the range
                if(output < min || output > max){
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
	return output;
    }
}
