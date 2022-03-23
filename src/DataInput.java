
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class DataInput {

    private Scanner sc = new Scanner(System.in);

    public int inputIntVal(String mess, int min, int max) {
        System.out.println(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int num = Integer.parseInt(input);
                if (num < min || num > max) {
                    System.out.print("Please input must more than " + min
                            + " and less than " + max); 
                    continue;
                }
               return num;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public String inputStringVal(String mess, String regex) {
        System.out.println(mess);
        while (true) {
            String input = sc.nextLine();
            if (input.trim().equals("")) {
                continue;
            }
            if (!input.matches(regex)) {
                System.out.println("Input invalid!");
                continue;
            }
            return input.trim();
        }
    }

    
}
