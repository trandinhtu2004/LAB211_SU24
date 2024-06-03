/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerprogram;

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args) {
        manager m = new manager();
        while (true){
            int choice = m.menu();
            switch (choice) {
                case 1:
                    m.normalCalculator();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
