/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentaveragemark;

import Entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Validation v = new Validation();
    Student t = new Student();

    public void addStudent(List<Student> sl) {
        while (true) {
            String name = v.checkInputString("Name: ");
            String className = v.checkInputString("Classes: ");
            double math;
            math = v.checkInputDoubleLimit("Math: ", 0, 10);
            double physic;
            physic = v.checkInputDoubleLimit("Physic: ", 0, 10);
            double chemistry;
            chemistry = v.checkInputDoubleLimit("Chemistry: ", 0, 10);

            sl.add(new Student(name, className, math,
                    chemistry, physic));

            if (!v.checkYN()) {
                return;
            }
        }
    }

    public void testStudent(List<Student> sl) {
        sl.add(new Student("Tu", "Fu", 4, 6, 7));
        sl.add(new Student("Tuan", "Fu", 10, 9.5, 8));
        sl.add(new Student("Tai", "Fu", 4, 3, 4));
        sl.add(new Student("Hai", "Fu", 4, 10, 7));
        sl.add(new Student("Duong", "Fu", 4, 1, 7));
    }

    public void displayStudent(List<Student> sl) {
        int i = 0;
        for (Student student : sl) {
            System.out.println("======Student " + (++i) + " info========== ");

            System.out.println("Name : " + student.getStudentName());
            System.out.println("Classes: " + student.getClassName());
            System.out.printf("AVG: %.2f\n", student.getAvg());
            System.out.println("Type: " + student.getType(student.getAvg()));

        }
    }

    public HashMap<String, Integer> getPercentageStudent(List<Student> sl) {
        //A
        //B
        //C
        //D
        HashMap<String, Integer> hm = new HashMap<>();

        double countA = 0;
        double countB = 0;
        double countC = 0;
        double countD = 0;

        for (Student student : sl) {
            if (student.getAvg() > 7.5) {
                countA++;
            } else if (student.getAvg() >= 6) {
                countB++;
            } else if (student.getAvg() >= 4) {
                countC++;
            } else {
                countD++;
            }
        }
        int totalStudent = sl.size();
        hm.put("A", (int)(countA / totalStudent * 100));
        hm.put("B", (int)(countB / totalStudent * 100));
        hm.put("C", (int)(countC / totalStudent * 100));
        hm.put("D", (int)(countD / totalStudent * 100));
        return hm;
    }
    
    
}
