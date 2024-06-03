/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectionsort;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    
    static final Scanner sc = new Scanner(System.in);
        
       public static int checkInputInt(){
           while (true){
               try{
                   int num = Integer.parseInt(sc.nextLine().trim());
                   return num;
               }catch (NumberFormatException e){
                   System.err.println("please input number");
                   System.out.println("try again: ");
               }
           }
       }
       // lấy số lượng phần tử muốn sắp xếp trong array
       public static int inputSizeArray(){
           System.out.println("Enter number of array: ");
           int n = checkInputInt();
           return n;
       }
       // nhập dữ liệu cho từng phần tử
       public static int[] inputValueOfArray(int n){
           int [] a = new int[n];
           for (int i = 0; i< n ; i++){
               System.out.println("Enter a[" + i + "] : ");
               a[i] = checkInputInt();
           }
           return a;
       }
       
    /*   public static void SelectionSort(int a[]){
           int len = a.length;
           System.out.println("Unsorted array: ");
           for (int i = 0;i < len;i++){
               System.out.print(a[i] + " ");
           }
       
           for (int i = 0;i < len - 1; i++){
               int minIndex = i;
               for (int j = i+1; j < len;j++){
                   if (a[j] < a[minIndex]){
                       minIndex = j;
                   }
               }
               if (minIndex != i){
                   int temp = a[minIndex];
                   a[minIndex] = a[i];
                   a[i] = temp;
               }
               if (i==1) break;
           }
           System.out.println();
       }
      */
       //
       public static void selectionSort(int a[]) {
    int len = a.length;
    System.out.println("Unsorted array: ");
    for (int i = 0; i < len; i++) {
        System.out.print(a[i] + " ");
    }
    
    for (int i = 0; i < len - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < len; j++) {
            if (a[j] < a[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }
    System.out.println();
}

       public static void print(int a[]){
           System.out.println("Sorted Array: ");
           for (int i = 0; i < a.length; i++){
               System.out.print(a[i]+ " ");
           }
       }
       
       public static void main(String[] args) {
           int n = inputSizeArray();
           int[] a = inputValueOfArray(n);
           selectionSort(a);
           print(a);
    }
       
       
    }
    

