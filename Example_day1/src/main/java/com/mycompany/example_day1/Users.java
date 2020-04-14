/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.example_day1;
import java.util.Scanner;

/**
 *
 * @author irabob
 */
public class Users {
     public static void main(String[] args){
         
         Scanner scan = new Scanner(System.in);
         
         System.out.println("What's yoyr name?: ");
         String name = scan.nextLine();
         System.out.println("How old are you?: ");
         int age = scan.nextInt();
         
         
         int month = age*12;
         int days = age*365;
         int hours = days*24;
         long minutes = hours*60;
         long seconds = hours*60;
         long milis = seconds * 60;
         
         System.out.println("Name :" + name);
         System.out.println(age + " Years");
         System.out.println(month + " Months");
         System.out.println(days + " Days");
         System.out.println(hours + " Hours");
         System.out.println(minutes + " Minutes");
         System.out.println(seconds + " Seconds");
         System.out.println(milis + " Milis");
         
         
     }
}
