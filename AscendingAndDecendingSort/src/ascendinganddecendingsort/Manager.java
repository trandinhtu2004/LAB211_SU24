/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ascendinganddecendingsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Manager {
     Scanner in = new Scanner(System.in);
     
    public int checkInputInt(String input) {
        System.out.println(input);
        //loop until user input correct
        
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int inputSizeOfArray() {
        System.out.println("Input Length Of Arrays");
        System.out.print("Enter number: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number greater than zero.");
                System.out.print("Enter again: ");
            }
        }
    }
    public int [] intputRandomValueOfArray(){
        Random r = new Random();
        int n = inputSizeOfArray();
        int[] a = new int[n];
         for (int i = 0;i < n; i++){
             a[i] = r.nextInt(n);
         }
         System.out.println("Array: " + Arrays.toString(a));
        return a;
    }
    public int[] inputValueOfArray(){
        int n = inputSizeOfArray();
        int[] a = new int[n];
        for (int i = 0;i < n; i++){
            a[i] = checkInputInt("enter [" + i + "] :");
        }
        return a;
    }
    
    public void sortArrayAscending(int []a){
        int length = a.length;
        if (length == 0){
            System.err.println("list is empty!");
        }
        for (int i = 0; i < length - 1;i++ ){
            int minIndex = i;
            for (int j = i+1; j < length; j++){
                if (a[j] < a[minIndex] ){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        System.out.println("after sort: " + Arrays.toString(a));
    }


    public void sortArrayDecending(int []a){
        int length = a.length;
        if (length == 0){
            System.err.println("list is empty!");
        }
        for (int i = 0; i < length - 1;i++ ){
            int maxIndex = i;
            for (int j = i+1; j < length; j++){
                if (a[j] > a[maxIndex] ){
                    maxIndex = j;
                }
            }
            if (maxIndex != i){
                int temp = a[maxIndex];
                a[maxIndex] = a[i];
                a[i] = temp;
            }
        }
        System.out.println("after sort: " + Arrays.toString(a));
    }

    }
    

