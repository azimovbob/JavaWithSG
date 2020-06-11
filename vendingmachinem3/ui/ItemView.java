/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.ui;

import com.bobazimov.vendingmachinem3.dto.Item;
import java.util.List;

/**
 *
 * @author irabob
 */
public class ItemView {
    
    UserIO io;
    
    public ItemView(UserIO io){
        this.io = io;
    }
    
    public void listItems(List<Item> items){
        for(Item currentItem: items){
            io.print(currentItem.getName() + " $" + currentItem.getPrice());
        }
    }
    
    public double getPayment(){
        return io.readDouble("Insert money ");
    }
    
    public String getItem(){
        return io.readString("Choose item from the list "); 
    }
    
    public int displayMenu(){
        io.print("Main Menu");
        io.print("1. Buy Item");
        io.print("2. Exit");
        
        return io.readInt("Please select from above choice: ", 1, 2);
    }
    
    public void displayChange(String change){
        io.print(change);
    }
}
