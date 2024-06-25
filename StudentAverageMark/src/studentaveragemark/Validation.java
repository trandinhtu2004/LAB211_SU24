/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentaveragemark;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    
     //check user input string
    public String checkInputString(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty() || result.equalsIgnoreCase("")) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
     public int checkInputIntLimit(String input, int min, int max) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
     
      public double checkInputDoubleLimit(String input, double min, double max) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public boolean checkYN(){
        System.out.println("Do you want to continue? (Y/N): ");
        while (true) {            
            String result = sc.nextLine().trim();
            
            if (result.length() == 1){
                char re = result.charAt(0);
                if (re == 'y' || re == 'Y') {
                    return true;
                }
                if (re == 'n' || re == 'N') {
                    return false;
                }
            }
            System.out.println("re-input: ");
        }
    }
}
