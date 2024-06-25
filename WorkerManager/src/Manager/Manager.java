/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.util.ArrayList;
import Entity.History;
import Entity.Worker;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Validation validation = new Validation();

    public int menu() {
        String input = "Please input choice: ";
        System.out.println("1. Add Worker.");
        System.out.println("2. Up salary.");
        System.out.println("3. Down salary.");
        System.out.println("4. Display Information salary.");
        System.out.println("5.Exit.");
        int choice = validation.checkInputIntLimit(input, 1, 5);
        return choice;
    }

    public void addWorker(ArrayList<Worker> lw) {
        String id = validation.checkInputString("Enter code: ");
        if (!validation.checkIdExist(lw, id)) {
            System.err.println("id existed!");
            return;
        }
        String name = validation.checkInputString("Enter name: ");
        int age = validation.checkInputIntLimit("Enter age: ",
                18, 50);
        double salary = validation.checkInputSalary("Enter salary: ");
        String workLocation;
        workLocation = validation.checkInputString("Enter work location:");
        /*if (!validation.checkWorkerExist(lw, id, name, age, salary, workLocation)) {
            System.err.println("Duplicate!");
            return;
        } else {*/
            lw.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success");
        //}
    }
    
    public void testAddWorker(ArrayList<Worker> wl){
        String ID = validation.checkInputString("Enter ID: ");
        if (!validation.checkIdExist(wl, ID)){
            System.err.println("ID existed");
            return;
        }
        String name = validation.checkInputString("enter name: ");
        int age = validation.checkInputIntLimit("Enter age: ", 18, 51);
        double salary = validation.checkInputDouble("Enter salary: ");
        String workLocation;
        workLocation = validation.checkInputString("Enter work location: ");
        
        wl.add(new Worker(ID, name, age, salary, workLocation));
        System.out.println("ADD SUCCESSED!");
        
    }
    
    public void testChangeSalary(ArrayList<Worker> wl,
                                 ArrayList<History> hl,
                                 int status){
        if (wl.isEmpty()){
            System.err.println("Empty list!");
            return;
        }
        String getID = validation.checkInputString("Enter ID: ");
        Worker worker = testGetWorkerByCode(wl, getID);
        
        if (worker == null){
            System.err.println("Worker not existed!");
            return;
        }
        
        System.out.println("Worker: " + worker.getName() + " - Salary: " + worker.getSalary());
        double udateSalary;
        if (status == 1){
            //up salary
            while (true) {                
                udateSalary = validation.checkInputSalaryIfNull("Enter new salary: ",
                                                                worker.getSalary());
                if (worker.getSalary() > udateSalary){
                    System.err.println("Salary must be higher than last salary");
                    System.out.println("Try again: ");
                }else{
                    break;
                }
            }
            hl.add(new History("UP", getCurrentDate(), worker.getId(),
                    worker.getName(),
                    worker.getAge(), udateSalary,
                    worker.getWorkLocation()));
        }
        else{
            while (true) {                
                udateSalary = validation.checkInputSalaryIfNull("Enter new salary: ",
                                                                worker.getSalary());
                if (worker.getSalary() < udateSalary){
                    System.err.println("Salary must be lower than last salary");
                    System.out.println("Try again: ");
                }else{
                    break;
                }
            }
            hl.add(new History("DOWN", getCurrentDate(), worker.getId(),
                    worker.getName(),
                    worker.getAge(), udateSalary,
                    worker.getWorkLocation()));
        }
        worker.setSalary(udateSalary);
        System.out.println("UPDATE SUCCESSFULLY!");
    }
    public Worker testGetWorkerByCode(ArrayList<Worker> lw, String id){
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())){
                return worker;
            }
        }
            return null;
    }

    public void changeSalary(ArrayList<Worker> lw,
            ArrayList<History> lh, int status) {
        //list of history is empty
        if (lw.isEmpty()) {
            System.err.println("List empty!!!");
            return;
        }
        ListWorker(lw);
        //take the id of the worker
        String id = validation.checkInputString("Enter ID: ");
        Worker worker = getWorkerByCode(lw, id);
        
        if (worker == null) {
            System.err.println("worker not existed!");
        } else {
            // take the current worker salary.
            //create a new variable name updated salary.
            System.out.println(worker.getName() + ": " + worker.getSalary());
            double curSalary = worker.getSalary();
            double updSalary;
            //if statue = 1 <=> salary up
            if (status == 1) {
                
                while (true) {
                    /*updSalary = validation.checkInputSalaryIfNull("Enter new salary: ", curSalary);
                    if (updSalary <= curSalary) {
                        System.err.println("Must be greater than current salary.");
                        System.out.println("Enter again: ");
                    } */
                    updSalary = validation.checkInputSalaryIfNull("Enter new salary: ", worker.getSalary());
                    if (updSalary < curSalary){
                        System.err.println("Salary must higher than current salary.");
                        System.out.println("Enter again: ");
                    }
                            else {
                        break;
                    }
                }
                lh.add(new History("UP",getCurrentDate(),worker.getId(),worker.getName()
                        ,worker.getAge(),updSalary,worker.getWorkLocation()));
                
            } else {
                while (true) {
                    updSalary = validation.checkInputSalaryIfNull("Enter new salary: ", curSalary);
                    if (updSalary > curSalary) {
                        System.err.println("Must be lower than current salary.");
                        System.out.println("Enter again: ");
                    } else {
                        break;
                    }
                }
              lh.add(new History("DOWN",getCurrentDate(),worker.getId(),worker.getName()
                    ,worker.getAge(),updSalary,worker.getWorkLocation()));
                
            }
            
            worker.setSalary(updSalary);
            System.err.println("Update success");
        }
    }

    public Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())){
                return worker;
            }
        }
        return null;
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
    
    public String testGetCurrentDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cl = Calendar.getInstance();
        return df.format(cl.getTime());
    }

    public void displayInfoSalary(ArrayList<History> lh) {
        if (lh.isEmpty()){
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        //print history from first to last list
        for (History history : lh) {
            printHistory(history);
        }
    }
    public static void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10.2f%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
    
    public void ListWorker(ArrayList<Worker> wl){
        System.out.printf("%-5s%-15s%-5s%-10s\n", "Code", "Name", "Age",
                "Salary");
        for (Worker worker : wl) {
            System.out.printf("%-5s%-15s%-5d%-10.2f\n",worker.getId(),
                    worker.getName(),worker.getAge(),worker.getSalary());
        }
    }
    
    public void addNewWorker(ArrayList<Worker> wl){
        Worker worker = new Worker();
        wl.add(new Worker("1", "TU", 19, 2000, "HaNoi"));
        wl.add(new Worker("3", "TUAN", 19, 1900, "HaNoi"));
        wl.add(new Worker("2", "TUTAB", 19, 1000, "HaNoi"));
    }
    
}
