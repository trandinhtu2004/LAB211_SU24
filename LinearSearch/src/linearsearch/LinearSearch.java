/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearsearch;

import java.util.*;
import sun.security.util.Length;

/**
 *
 * @author ADMIN
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static final Scanner sc = new Scanner(System.in);

    //check input
    public static int CheckNum() {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                return n;
            } catch (NumberFormatException e) {
                System.err.println("input must be number");
                System.out.println("try again: ");
            }
        }
    }

    //display array
    public static void displayArr(int arr[]) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    //searching key
    public static boolean linearSearch(int[] arr, int key) {
        int size = arr.length;
        int cur;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("found " + key + " at " + i);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter num of Array: ");
        int n = CheckNum();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(n);
        }

        System.out.println("array: ");
        displayArr(arr);
        System.out.println("Enter search value: ");

        int search = CheckNum();
        boolean key = linearSearch(arr, search);
             
        }
    }
