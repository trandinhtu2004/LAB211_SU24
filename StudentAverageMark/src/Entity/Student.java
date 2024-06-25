/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Student {
    String studentName;
    String className;
    double mathMark;
    double chemistryMark;
    double physicMark;

    public Student() {
    }

    public Student(String studentName, String className, double mathMark, double chemistryMark, double physicMark) {
        this.studentName = studentName;
        this.className = className;
        this.mathMark = mathMark;
        this.chemistryMark = chemistryMark;
        this.physicMark = physicMark;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(double chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    public double getPhysicMark() {
        return physicMark;
    }

    public void setPhysicMark(double physicMark) {
        this.physicMark = physicMark;
    }
    
    public String getType(double avg){
        if(avg > 7.5){
            return "A";
        }
        else if (avg >= 6){
            return "B";
        }
        else if (avg >=4 ){
            return "C";
        }else return "D";
    }
    
    public double getAvg(){
         double avg = (mathMark + chemistryMark + physicMark) / 3;
         return avg;
    }
    
    

   
}
