/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ulities;
import java.util.Random;
/**
 *
 * @author ADMIN
 */
public class GenerateCaptcha {
    Random random = new Random();
    
    public int randomRange(int min, int max){
        return random.nextInt(max - min - 1) + min;
    }
    
    public String generateCaptcha(){
        String alphabet = "abcdefghikmnopqrstuvwxyz";
        String digit = "0123456789";
        String alphaNumeric = alphabet + alphabet.toUpperCase() + digit;
        
        String res = "";
        
        for (int i = 0 ; i < alphaNumeric.length();i++){
            res += alphaNumeric.charAt(randomRange(0, alphaNumeric.length()-1));
        }
        return res;
    }
}
