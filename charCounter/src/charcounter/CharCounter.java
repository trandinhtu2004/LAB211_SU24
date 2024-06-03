/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package charcounter;
import java.util.HashMap;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map;
/**
 *
 * @author ADMIN
 */
public class CharCounter {

    /**
     * @param args the command line arguments
     */
    public Map<Character, Integer> charCounter = new HashMap<>();
    public Map<String, Integer> wordCounter = new HashMap<String, Integer>();
    
    public void analyze(String content){
        for (char c : content.toCharArray()){
            if (Character.isSpaceChar(c)){
                continue;
            }
            if (!charCounter.containsKey(c)){
                charCounter.put(c ,1);
            } else{
                charCounter.put(c, charCounter.get(c) + 1);
            }
        }
        StringTokenizer stn = new StringTokenizer(content);
        
        while (stn.hasMoreTokens()){
            String token = stn.nextToken();
            if (!wordCounter.containsKey(token)){
                wordCounter.put(token, 1);
            }else{
                wordCounter.put(token, wordCounter.get(token)+1);
            }
        }
    }
    public void display (){
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content;
        System.out.println("input a String: ");
        content = sc.nextLine();
        CharCounter charCounter = new CharCounter();
        charCounter.analyze(content);
        charCounter.display();
    }
    
}
