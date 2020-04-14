/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingG;
import java.util.*;


/**
 *
 * @author irabob 
 */
public class GuessingG {
    
    
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    int number;
    int randNum = rand.nextInt(99)+1;
    int count = 0;
    // System.out.println(randNum); 

    do{
        System.out.println("Enter a number between 0 and 100"); 
        number = scan.nextInt();
        if(number<randNum){
          System.out.println("Number is low"); 
        }else if(number>randNum){
          System.out.println("Number is high"); 
        }else{
          System.out.println("Bingo!!!"); 
        }
        count++;
    }while(number!=randNum);
     System.out.println("Total count is: " + count);
  }
    
}
