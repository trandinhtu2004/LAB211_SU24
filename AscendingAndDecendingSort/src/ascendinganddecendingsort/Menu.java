/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ascendinganddecendingsort;

/**
 *
 * @author ADMIN
 */
public class Menu {
    Manager v = new Manager();
    public int menu(){
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Desceding");
        System.out.println("4. Exit.");
        while (true){
            try{
        int choice = v.checkInputInt("Enter your choice: ");
        if (choice < 1 || choice > 4) {
                    throw new NumberFormatException();
                }
        return choice;
            }catch (NumberFormatException e){
                System.err.println("Must be input integer 1 to 4.");
                System.out.print("Enter again: ");
            }
        }
    }
}
