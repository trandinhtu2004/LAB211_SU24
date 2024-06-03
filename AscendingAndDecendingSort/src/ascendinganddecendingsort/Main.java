/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ascendinganddecendingsort;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu m = new Menu();
        Manager manager = new Manager();
        int[] a = new int[0];
        while (true){
            int choice = m.menu();
            switch (choice) {
                case 1:
                    a = manager.intputRandomValueOfArray();
                    break;
                case 2:
                    manager.sortArrayAscending(a);
                    break;
                case 3:
                    manager.sortArrayDecending(a);
                    break;
                case 4: 
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
    
}
