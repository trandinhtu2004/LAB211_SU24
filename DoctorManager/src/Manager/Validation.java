/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;
import Entity.Doctor;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class Validation {
    private final Scanner sc = new Scanner(System.in);
    public int checkInputInt(String input,String err){
        System.out.println(input);
        while (true) {            
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.err.println("Wrong type of input");
                System.out.println("Try again: ");
            }
        }
    }
    
    public int checkLimit(String input,int min, int max){
        System.out.println(input);
        while (true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max){
                    System.err.println("the input must between"
                            + min + " and " + max);
                }
                else return result;
            }catch(Exception e){
                System.err.println("Wrong type of input");
                System.out.println("Try again: ");
            }
        }
    }
    
    public String checkString(String input){
        System.out.println(input);
        while (true){
            try{
                String result = sc.nextLine().trim();
                if (result.isEmpty()){
                    System.err.println("String must not be empty");
                }else return result;
            }catch(Exception e){
                System.err.println("Wrong type of input");
                System.out.println("Try again: ");
            }
        }
    }
    
    public boolean checkInputYN(){
        while (true){
            String result = checkString("Please type 'Y/y' or 'N/n': ");
            if (result.equalsIgnoreCase("Y")){
                return true;
            }
            if (result.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please type 'Y/y' or 'N/n'");
            System.out.println("Try again: ");
        }
    }
    
    public boolean checkCodeExist(ArrayList<Entity.Doctor> d, String code){
        for (Doctor doctor : d) {
            if (code.equalsIgnoreCase(doctor.getCode())){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkDuplicate(ArrayList<Entity.Doctor> d,String code,
            String name,String specialization, int avaiability){
        for (Doctor doctor : d) {
            if (code.equalsIgnoreCase(doctor.getCode())&&
                name.equalsIgnoreCase(doctor.getName())&&
                specialization.equalsIgnoreCase(doctor.getSpecialization())
                && avaiability == doctor.getAvaiability()){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkChangeInfo(Doctor doctor, String code, String name,
            String specialization,int avaiability){
        if (doctor.getCode().equalsIgnoreCase(code)&&
            doctor.getName().equalsIgnoreCase(name)&&
            doctor.getSpecialization().equalsIgnoreCase(specialization)&&
            doctor.getAvaiability() == avaiability){
            return false;
        }
        return true;
    }
    
}
