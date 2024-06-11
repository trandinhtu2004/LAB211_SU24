/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.Locale;
import java.util.Scanner;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Scanner sc = new Scanner(System.in);

    String AccountValidNum = "^\\d{10}$"; //valid account co do dai = 10
    //dung de lay captcha
    char[] chars = "1AaBbCc2DdEeFf3GgHhIiJjKkLl4MmNnOo5PpQqRrSsTt6UuVvWw8XxYyZz9".toCharArray();
    
    //lay thu vien su dung ngon ngu trong muc folder ngon ngu
    public void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words;
        words = ResourceBundle.getBundle("Languages/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }
    //kiem tra limit
    public int checkInputLimit(String input, int min, int max, Locale language) {
        System.out.println(input);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                getWordLanguage(language, "errorCheckInputIntLimit");
                System.out.println();
            }
        }
    }
    //kiem tra String
    public String checkInputString(Locale language) {
        while (true) {
            String result = sc.nextLine();
            if (result.length() == 0 || result.isEmpty()) {
                getWordLanguage(language, "errCheckInputIntLimit");
                System.out.println();
            } else {
                return result;
            }
        }
    }
    //kiem tra neu so tai khoan match 2 dieu kien chi dung number va phai co 10 chu so
    public int checkInputAccount(Locale language) {
        while (true) {
            String result = sc.nextLine();
            if (result.matches(AccountValidNum)) {
                return Integer.parseInt(result);
            }
            getWordLanguage(language, "errCheckInputAccount");
            System.out.println();
        }
    }
    //kiem tra password phai co chu cai va so, 8<length <31
    public String checkInputPassword(Locale language) {
        String result;
        while (true) {
            result = checkInputString(language);
            if (isValidPass(result, language)) {
                return result;
            }
        }
    }

    public boolean isValidPass(String password, Locale language) {
        int passwordLength = password.length();
        //8<pass.length < 31 thif return trang chu
        if (passwordLength < 8 || passwordLength > 31) {
            getWordLanguage(language, "errCheckLengthPassword");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            //dem password digit va letter
            for (int i = 0; i < passwordLength - 1; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            //dieu kien de return result la digit hoac leter phai lon hon 1
            if (countDigit < 1 || countLetter < 1) {
                getWordLanguage(language, "errCheckAlphanumericPassword");
                System.out.println();
                return false;
            }
        }
        return true;
    }
    //kiem tra input ccaptcha // dieu kien la ham nhap chi can 1 chu cai contain trong cai captcha
    public boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        getWordLanguage(language, "enterCaptcha");
        String captchaInput = checkInputString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    //tao ra random captcha
    public String generateCpatchaText() {
        String randStringValue = "";
        int length = 6;
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            result.append(chars[index]);
        }
        return result.toString();
    }
    //UI login
    public void login(Locale language) {
        getWordLanguage(language, "enterAccountNumber");
        int accountNum = checkInputAccount(language);
        getWordLanguage(language, "enterPassword");
        String password = checkInputPassword(language);
        while (true) {            
        String captchaGenerated = generateCpatchaText();
        
            if (checkInputCaptcha(captchaGenerated, language)) {
                getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }
    //UI trang chu
    public void menu() {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        System.out.println("1.Vietnamese");
        System.out.println("2.English");
        System.out.println("3.Exit");
        String input = "Please choose 1 option: ";
        int choice = checkInputLimit(input, 1, 3, english);
        switch (choice) {
            case 1:
                login(vietnamese);
                break;
            case 2:
                login(english);
                break;
            case 3:
                return;
        }
    }
    //main
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.menu();
    }
}
