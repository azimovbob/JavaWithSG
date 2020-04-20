/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowMaster;
import java.util.*;

/**
 *
 * @author irabob
 */
public class WindowMaster {
    public static void main(String[] args){
        //Scanner object
        Scanner myScanner = new Scanner(System.in);
        //Variable intialization
        double height;
        double width;
        String stringHeight;
        String stringWidth;
        double sqFoot = 3.5;
        double lnFoot = 2.25;
        double areaOfWindow ;
        double parameterOfWindow;
        double cost;
        boolean isValid = false;
        
        //do while starts here
        do{
        //try/catch
        try{
            System.out.println("Enter the height: ");
            stringHeight = myScanner.nextLine();
            System.out.println("Enter the width: ");
            stringWidth = myScanner.nextLine();
            height = Double.parseDouble(stringHeight);
            width = Double.parseDouble(stringWidth);
            areaOfWindow = height * width;
            parameterOfWindow = 2 * (height + width);
            cost = areaOfWindow + parameterOfWindow;
            //isValid true if inputs are positive
            if(width > 0 && height > 0){
                isValid = true;
                System.out.println("Total price: $" + cost);
            //else ask user to re-enter valid input
            }else{
                System.out.println("Please enter valid input");
            }
        }catch(NumberFormatException ex){
            System.out.println("Invalid input");
        }
        
        }while(!isValid);//while isValid is false
        
    }
}


