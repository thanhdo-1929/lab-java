                   
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84964
 */
public class DataInput {
    private final Scanner in = new Scanner(System.in);

    //check user input number limit
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

    //check user input string
    public String inputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    //check user input double limit
    public double inputDouble(double min, double max, String err) {
        //loop until user input correct
        double result;
        while (true) {
            try {
                result = Double.parseDouble(in.nextLine().trim());
                if (result >= min && result <= max) {
                    if(result % 0.5 == 0){
                        break;
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println(err);
                System.out.print("Enter again: ");
            }
        }
        return result;
    }
    
    //input date
    public String inputDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                date = df.parse(in.nextLine());
                break;
            } catch (Exception e) {
                System.err.print("Format date like dd-MM-yyyy, please enter again: ");
            }
        }
        return df.format(date);
    }
}
