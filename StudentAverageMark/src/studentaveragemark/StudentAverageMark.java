/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentaveragemark;
import Entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class StudentAverageMark {

    public static void main(String[] args) {
        Manager m = new Manager();
        Entity.Student st = new Student();
        List<Student> sl = new ArrayList<>();
        m.testStudent(sl);
        m.addStudent(sl);
        
        m.displayStudent(sl);
        
        HashMap<String,Integer> getpStudent = m.getPercentageStudent(sl);
        for (Map.Entry student : getpStudent.entrySet()) {
            System.out.println(student.getKey() + ": " + student.getValue() + "%");
            
        }
    }
    
}
