/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//AS2019503 GBC PRABHASHWARA
package exam;

/**
 *
 * @author CHAMOD
 */
import java.time.LocalDate;
import java.util.Scanner;

public class InputValidator {

    private final Scanner sc = new Scanner(System.in);

    //validating inrtger values of user 
    public int getInt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message+" ");
        while (!sc.hasNextInt()) {
            //error output
            System.err.print("Please enter valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }
 
    /*public int getPh(){
        int phValue = getInt("enter valid PH value :");
        
    }*/
    
    //validating double values what user enters
    public Double getDouble(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message+" ");
        while (!sc.hasNextDouble()) {
            //error output
            System.err.print("Please enter valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
    
    public String getString(String message) {
        System.out.print(message+" ");
        return sc.next();
    }
    

    public int getState(String message) {
        System.out.print(message+" ");
        return sc.nextInt();
    }

    //validate user date input according to the real world date format
    public LocalDate getDate(String message) {
        LocalDate date = null;
        boolean validDate = true;
        System.out.println(message);
        while(validDate){
            try{
                date = LocalDate.of(getInt("\tEnter Year :"), getInt("\tEnter Month :"), getInt("\tEnter Date :"));
                validDate = false;
            } catch (Exception e){
                System.out.println("Please enter valid value and try again: ");
            }
        }
        return date;
    }
    
}