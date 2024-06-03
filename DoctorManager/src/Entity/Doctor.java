/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int avaiability;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Doctor{" + "code=" + code + ", name=" + name + ", specialization=" + specialization + ", avaiability=" + avaiability + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvaiability() {
        return avaiability;
    }

    public void setAvaiability(int avaiability) {
        this.avaiability = avaiability;
    }

    public Doctor(String code, String name, String specialization, int avaiability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.avaiability = avaiability;
    }

    public Doctor() {
    }
           
}
