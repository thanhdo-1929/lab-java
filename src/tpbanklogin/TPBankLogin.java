package tpbanklogin;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Ninh
 */
public class TPBankLogin {
    private static EBank ebank = new EBank();
    private static DataInput input = new DataInput();
    private static String account, password, captcha, message;
    
    // Input account number
    private static void inputAcc(){
        while (true) {
            account = input.inputString(ebank.getLabels().getString("account_login"),
                    ebank.getLabels().getString("account_login_error"));
            message = ebank.checkAccountNumber(account);
            if (message.equals(account)) {
                break;
            }
            System.out.println(message);
        }
    }
    
    // Input password
    private static void inputPass(){
        while (true) {
            password = input.inputString(ebank.getLabels().getString("password_login"),
                    ebank.getLabels().getString("password_login_error"));
            message = ebank.checkPassword(password);
            if (message.equals(password)) {
                break;
            }
            System.out.println(message);
        }
    }
    
    // Input captcha
    private static void inputCaptcha(){
        String generatedCaptcha = ebank.generateCaptcha();
        System.out.println("Captcha: " + generatedCaptcha);
        while (true) {
            captcha = input.inputString(ebank.getLabels().getString("captcha_input"),
                    ebank.getLabels().getString("captcha_error"));
            message = ebank.checkCaptcha(captcha, generatedCaptcha);
            if (message.equals(captcha)) {
                break;
            }
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice = input.inputInt(1, 3, "Please choice one option: ", "Choice must in range 1-3");
        switch (choice) {
            case 1:
                ebank.setLocale(new Locale("vi"));
                break;
            case 2:
                ebank.setLocale(new Locale("en"));
                break;
            case 3:
                System.exit(0);
        }
        inputAcc();
        inputPass();
        inputCaptcha();
        System.out.println("Login sucessfully!");
    }

}
