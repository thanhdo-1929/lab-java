package tpbanklogin;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author Ninh
 */
public class EBank {

    private ResourceBundle labels;

    public ResourceBundle getLabels() {
        return labels;
    }

    public void setLocale(Locale locale) {
        labels = ResourceBundle.getBundle("languages/lang", locale);
    }

    // Check the user input account
    public String checkAccountNumber(String accountNumber) {
        if (Pattern.matches("^\\d{10}$", accountNumber)) {
            return accountNumber;
        }
        return labels.getString("account_login_error");

    }

    // Check the user input password
    public String checkPassword(String password) {
        if (Pattern.matches("^(?=.{8,31}$)(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$", password)) {
            return password;
        }
        return labels.getString("password_login_error");
    }

    // Generate random captcha
    public String generateCaptcha() {
        Random random = new Random();
        String captcha = "";
        // The captcha has 5 character 
        for (int i = 0; i < 5; i++) {
            // Random number from ASCII in range 48-122
            int temp = 48 + random.nextInt(75);
            // Check at that ASCII number is an alphabetic or a digit
            if (Character.isAlphabetic(temp) || Character.isDigit(temp)) {
                captcha += (char) temp;
                continue;
            }
            i--;
        }
        return captcha;
    }

    // Check user input captcha
    public String checkCaptcha(String captchaInput, String captchaGenerated) {
        if (captchaInput.equals(captchaGenerated)) {
            return captchaInput;
        }
        return labels.getString("captcha_error");
    }

}
