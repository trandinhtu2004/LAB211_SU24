/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BinarySearch {

    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */

    public int checkInput(String input) {
        System.out.println(input);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                return n;
            } catch (Exception e) {
                System.err.println("error input");
                System.out.println("Try again: ");
            }
        }
    }
    public int binarySearch(int arr[],int l, int r, int key){
        if (l<r){
            int mid = (l + r) / 2;
            if (arr[mid] == key){
                return mid;
            }else if (arr[mid] > key){
                return binarySearch(arr, l, mid-1, key);
            }else{
                return binarySearch(arr, mid + 1, r, key);
            }
        }
        return -1;
    }
    /*public int binarySearch(int arr[],int l, int r, int key) {
        if (l < r) {
            //mid lay phan tu o giua mang 
            int mid = (l + r) / 2;
            // 
            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] > key) {
                return binarySearch(arr, l, mid - 1, key);
            } else {
                return binarySearch(arr, mid + 1, r, key);
            }
        }
        return -1;
    }
    */
    public void selectionSort(int arr[]){
	int len = arr.length;
for (int i = 0; i < len - 1; i++){
	int minIndex = i;
	for (int j = i+1;j < len;j++){
		if (arr[minIndex] > arr[j]){
			minIndex = j;
			}	
		}
	if (minIndex!= i){
	int temp = arr[minIndex];
	arr[minIndex] = arr[i];
	arr[i] = temp;
		} 
	}

}
    public int[] getRandom(int arr[]) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(arr.length);
        }
        return arr;
    }
    /*public void displayArrayToString(int [] arr){
        System.out.print("[ ");
        for (int i = 0;i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
    }*/
    public void displayArrayToString(int [] arr){
        System.out.print("Array: " + Arrays.toString(arr));
        System.out.println();
    }
    public void findKey(int foundIndex, int key){
        if (foundIndex == -1) {
            System.out.println("Phần tử không tồn tại.");
        } else {
            System.out.println("Phần tử " + key + " được tìm thấy tại vị trí: " + foundIndex);
        }
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        /*int arr[] = {2, 4, 9, 10, 11, 22, 24, 31, 48, 56, 76, 86};
        int n = arr.length;
        int x = 10;
        int result = bs.binarySearch(arr, x);
        if (result == -1) {
            System.out.println("Phần tử không tồn tại.");
        } else {
            System.out.println("Phần tử được tìm thấy tại vị trí: " + result);
        }*/
        int n = bs.checkInput("enter size of array");
        int arr[] = new int[n];
        bs.getRandom(arr);
        bs.selectionSort(arr);
        bs.displayArrayToString(arr);
        int key = bs.checkInput("enter search value: ");
        int foundIndex = bs.binarySearch(arr, 0, arr.length - 1, key);
        bs.findKey(foundIndex, key);
        /*int foundIndex = bs.binarySearch(arr,0,arr.length-1, key);
        if (foundIndex == -1) {
            System.out.println("Phần tử không tồn tại.");
        } else {
            System.out.println("Phần tử " + key + " được tìm thấy tại vị trí: " + foundIndex);
        }*/
        
    }
}
