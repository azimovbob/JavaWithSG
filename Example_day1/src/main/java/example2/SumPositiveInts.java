/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;
import java.util.*;
/**
 *
 * @author irabob
 */
public class SumPositiveInts {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter positive number:");
        int number = scan.nextInt();
        int sum = 0;
        if(number>0){
        do{
           sum+=number%10;
           number/=10;
        
        }while(number>10);
        sum+=number;
        
        System.out.println("The sum is " + sum);
        }else{
            System.out.println("Number is not positive");
        }
    }
    
}
