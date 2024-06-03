/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;
import java.util.ArrayList;
import Entity.Doctor;
/**
 *
 * @author ADMIN
 */
public class Manager {
    
    Validation v = new Validation();
    public int menu(){
        System.out.println("1. Add Doctor.");
        System.out.println("2. Update Doctor.");
        System.out.println("3. Delete Doctor.");
        System.out.println("4. Search Doctor.");
        System.out.println("5. List all Doctor");
        System.out.println("6. Exit.");
        int choice = v.checkLimit("Input your choice: ",
                1, 6);
        return choice;
    }

    public void addDoctor(ArrayList<Doctor> d){
        String code = v.checkString("Enter code you want to add: ");
        // neu nhu codeExist o trang thai la false
        if (!v.checkCodeExist(d, code)){
            System.out.println("code existed!!");
            return;
        }
        String name = v.checkString("Enter name: ");
        String specialization = v.checkString("Enter specialization: ");
        int availability = v.checkInputInt("Enter availability: ",
    "Error Input");
        
        //check worker duplicate
        if (!v.checkDuplicate(d, code, name, specialization, availability)){
            System.out.println("Doctor info is duplicated");
            return;
        }
        d.add(new Doctor(code, name, specialization, availability));
        System.err.println("Added successfully.");
    }
    
    public void updateDoctor(ArrayList<Doctor> d){
        String code = v.checkString("Enter code you want to update: ");
        if (v.checkCodeExist(d, code)){
            System.err.println("Not found doctor!");
            return;
        }
        String codeUpd = v.checkString("Enter new code: ");
        Doctor doctor = findDoctorByCode(d, code);
        String name = v.checkString("Enter new name: ");
        String specialization = v.checkString("Enter new specialization: ");
        int availability = v.checkInputInt("Enter new availability: ",
    "Error Input");
        // neu thong tin bi trung
        if (!v.checkChangeInfo(doctor, code, name, specialization, availability)){
            System.err.println("No change");
            return;
        }
        //thay doi thong tin
        doctor.setCode(codeUpd);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvaiability(availability);
        System.err.println("Update successful");
        
    }
    
    public void deleteDoctor(ArrayList<Doctor> d){
        String code = v.checkString("Enter code you want to delete: ");
        Doctor doctor = findDoctorByCode(d, code);
        if (doctor == null){
            System.err.println("Not found doctor!");
            return;
        }else{
            d.remove(doctor);
        }System.err.println("Delete successful");
        
    }
    
    public void searchDoctor(ArrayList<Doctor> d){
        String nameSearch = v.checkString("Enter name you want to search: ");
        ArrayList<Doctor> listFoundByName = listFoundByName(d, nameSearch);
        if (listFoundByName.isEmpty()){
            System.err.println("List empty!");
        }else{
            System.out.printf("%-10s%-15s%-25s%-20s\n", "code"
                    ,"name","specialization","Avaiability");
        }for (Doctor doctor : listFoundByName) {
            System.out.printf("%-10s%-15s%-25s%-20d\n",doctor.getCode()
            ,doctor.getName(),doctor.getSpecialization()
            ,doctor.getAvaiability());
        }
    }
    public void listDoctor(ArrayList<Doctor> d){
        System.out.printf("%-10s%-15s%-25s%-20s\n", "code"
                    ,"name","specialization","Avaiability");
        for (Doctor doctor : d) {
             System.out.printf("%-10s%-15s%-25s%-20d\n",doctor.getCode()
            ,doctor.getName(),doctor.getSpecialization()
            ,doctor.getAvaiability());
        }
    }
    // get doctor by code 
    public Doctor findDoctorByCode(ArrayList<Doctor> d,String code){
        for (Doctor doctor : d) {
            if (doctor.getCode().equalsIgnoreCase(code)){
                return doctor;
            }
        }
        return null;
    }
    
    //get list doctor by name
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> d,String name){
        //create a new list
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        //take all of names that contain in Input.
        for (Doctor doctor : d) {
            if(doctor.getName().contains(name)){
                //add.
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
