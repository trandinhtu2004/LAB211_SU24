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
        int salary = validation.checkInputSalary("Enter salary: ");
        String workLocation;
        workLocation = validation.checkInputString("Enter work location:");
        if (!validation.checkWorkerExist(lw, id, name, age, salary, workLocation)) {
            System.err.println("Duplicate!");
            return;
        } else {
            lw.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success");
        }
    }

    public void changeSalary(ArrayList<Worker> lw,
            ArrayList<History> lh, int status) {
        if (lw.isEmpty()) {
            System.err.println("List empty!!!");
            return;
        }
        String id = validation.checkInputString("Enter ID: ");
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("worker not existed!");
        } else {
            int curSalary = worker.getSalary();
            int updSalary;

            if (status == 1) {
                while (true) {
                    updSalary = validation.checkInputSalaryIfNull("Enter new salary: ", curSalary);
                    if (updSalary <= curSalary) {
                        System.err.println("Must be greater than current salary.");
                        System.out.println("Enter again: ");
                    } else {
                        break;
          
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), updSalary,
                        worker.getWorkLocation()));
            } else {
                while (true) {
                    updSalary = validation.checkInputSalaryIfNull("Enter new salary: ", curSalary);
                    if (updSalary >= curSalary) {
                        System.err.println("Must be greater than current salary.");
                        System.out.println("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), updSalary,
                        worker.getWorkLocation()));
            }
            worker.setSalary(updSalary);
            System.err.println("Update success");
        }
    }

    public Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
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
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
