/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerprogram;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class manager {

    private Scanner sc = new Scanner(System.in);

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.err.println("error input");
                System.out.println("Try again: ");
            }
        }
    }

    public int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("input must between" + min + " and " + max);
                    System.out.println("try again: ");
                }else
                return result;
            } catch (Exception e) {
                System.err.println("error input");
                System.out.println("try again: ");
            }

        }
    }
    public String checkOperator(){
        while (true){
            try{
        String operator = sc.nextLine().trim();
        if (operator.isEmpty()){
            System.out.println("op must not be empty");
            System.out.println("try again: ");
        }else if (
                operator.equalsIgnoreCase("+") ||
                operator.equalsIgnoreCase("-") ||
                operator.equalsIgnoreCase("*") ||
                operator.equalsIgnoreCase("/") ||
                operator.equalsIgnoreCase("^") ||
                operator.equalsIgnoreCase("=") )
        {
            return operator;
        }
            }catch (Exception e){
                System.err.println("error operator - (+,-,*,/,^)");
                System.out.println("try again: ");
            }
        }
    }
    public int menu() {
        System.out.println("1.Calculator");
        System.out.println("2.BMI calculator");
        System.out.println("3.Exit");
        int choice = checkInputLimit(1, 3);
        return choice;
    }
    
    public double inputNum(){
        System.out.println("enter number: ");
        double num = checkInputDouble();
        return num;
    }
    public void normalCalculator(){
        double memory;
        System.out.print("enter number: ");
        memory = checkInputDouble();
        while (true){
            System.out.print("enter operator: ");
            String op = checkOperator();
            if (op.equalsIgnoreCase("+")){
                memory += inputNum();
                System.out.println("memory: " + memory);
            }
            if (op.equalsIgnoreCase("-")){
                memory -= inputNum();
                System.out.println("memory: " + memory);
            }
            if (op.equalsIgnoreCase("*")){
                memory *= inputNum();
                System.out.println("memory: " + memory);
            }
            if (op.equalsIgnoreCase("/")){
                memory /= inputNum();
                System.out.println("memory: " + memory);
            }
            if (op.equalsIgnoreCase("^")){
                memory = Math.pow(memory, inputNum());
                System.out.println("memory: " + memory);
            }
            if (op.equalsIgnoreCase("=")){
                System.out.println("result: " + memory);
                return;
            }
        }
    }
    public String BMIStatue(double bmi){
        if (bmi < 19){
            return "Under-standard";
        }
        return "Fat";
    }
    public void BMICalculator(){
        
    }
}
