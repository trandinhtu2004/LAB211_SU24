/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Worker;
import Entity.History;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    Scanner in = new Scanner(System.in);

    public int checkInputIntLimit(String input, int min, int max) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
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

    //check user input string
    public String checkInputString(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty() || result.equalsIgnoreCase("")) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public int checkInputTakeList(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result == 0) {
                    System.out.println("Go back to the Fruit management");
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public double checkInputPrice(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine().trim());
                if (result < 0) {
                    System.err.println("price must >= 0");
                    System.out.println("Try again: ");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    public double checkInputDouble(String input) {
        System.out.println(input);
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    public int checkInputSalary(String input) {
        System.out.println(input);
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Salary must greater than 0");
                System.out.println("Try again: ");
            }
        }

    }

    public boolean checkWorkerExist(ArrayList<Worker> lw,
            String Id, String name, int age, int salary, String workLocation) {
        for (Worker worker : lw) {
            if (Id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge() && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }

    public int checkInputSalaryIfNull(String message, int curSalary) {
        int salary = 0;
        System.out.println(message);
        while (true){
        String input = in.nextLine().trim();
        if (!input.isEmpty()) {
            try {
                salary = Integer.parseInt(input);
                return salary;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid salary.");
                System.out.println("Try again: ");
            }
        }else if (input.isEmpty()){
                 return curSalary;   
                    }
        }
    }

    public boolean checkIdExist(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInputYN() {
        System.out.println("Do you want to continue? (Y/N): ");
        while (true) {
            String result = in.nextLine().trim();

            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }

            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
