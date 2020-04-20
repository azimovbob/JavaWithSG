/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addingNumbers;
import java.util.*;

/**
 *
 * @author irabob
 */
public class Adder {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
//  try{      
//        System.out.println("Enter first number:");
//        String stringOperand1 = myScanner.nextLine();
////        System.out.println("Enter second number:");
////        String stringOperand2 = myScanner.nextLine();
//        
//        int operand1 = Integer.parseInt(stringOperand1);
////        int operand2 = Integer.parseInt(stringOperand2);
////        
////        int sum = operand1 + operand2;
//  }
//  catch(NumberFormatException ex){
//        System.out.println("Input can not be converted to number");
//  } 

boolean isValid = false;

do {

    try {
        System.out.println("Please enter a whole number: ");

        String input = myScanner.nextLine();
        int number = Integer.parseInt(input);
        isValid = true;

    } catch(NumberFormatException ex) {
        System.out.println("That was not a whole number!");
    }

} while(!isValid);
    }
}
