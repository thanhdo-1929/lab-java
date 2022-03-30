package tpbanklogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Ninh
 */
public class DataInput {

    private Scanner sc = new Scanner(System.in);

    // Input integer in range
    public int inputInt(int min, int max, String title, String error) {
        int output;
        while (true) {
            try {
                System.out.print(title);
                output = Integer.parseInt(sc.nextLine());
                // Check the range
                if (output < min || output > max) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return output;
    }

    // Input string not empty
    public String inputString(String message, String error) {
        while (true) {
            System.out.print(message);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println(error);
            } else {
                return result;
            }
        }
    }
}
