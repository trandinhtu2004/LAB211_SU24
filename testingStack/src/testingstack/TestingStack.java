/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testingstack;

import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class TestingStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack myStack = new Stack<>();

        System.out.println("Is my stack empty? " + myStack.empty());
// pushing elements into stack
        myStack.push("Orange Ball");
        myStack.push("Violet Ball");
        myStack.push("Green Ball");

//prints elements of the stack
        System.out.println("Elements in Stack: " + myStack);
        System.out.println("Is my stack empty? " + myStack.empty());
        while (!myStack.isEmpty()) {
            myStack.pop();
            System.out.println("Elements in Stack: " + myStack);
            System.out.println("Is my stack empty? " + myStack.empty());
        }
    }

}
