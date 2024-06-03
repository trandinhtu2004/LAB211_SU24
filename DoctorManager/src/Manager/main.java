/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Doctor;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args) {
        ArrayList<Doctor> d = new ArrayList<>();
        Manager m = new Manager();
        while (true) {            
            int choice = m.menu();
            switch (choice) {
                case 1:
                    m.addDoctor(d);
                    break;
                case 2:
                    m.updateDoctor(d);
                    break;
                case 3:
                    m.deleteDoctor(d);
                    break;
                case 4:
                    m.searchDoctor(d);
                    break;
                case 5:
                    m.listDoctor(d);
                    break;
                case 6:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
