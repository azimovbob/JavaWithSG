/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.controller;

import com.bobazimov.vendingmachinem3.dto.Item;
import com.bobazimov.vendingmachinem3.service.Change;
import com.bobazimov.vendingmachinem3.service.ItemService;
import com.bobazimov.vendingmachinem3.ui.ItemView;
import java.util.List;

/**
 *
 * @author irabob
 */
public class ItemController {
    
    private ItemView view;
    private ItemService service;
    private Change change;
    
    public ItemController(ItemView view, ItemService service){
    
        this.view = view;
        this.service = service;
    }
    
    public void run() throws Exception{
        
        int choice = 0;
        boolean keepGoing = true;
        
        while(keepGoing){
            choice = view.displayMenu();
            
            switch(choice){
                case 1: displayItems();
                        getMoney();
                break;
                case 2: 
                System.exit(0);
                break;
                default:
                    System.out.println("Unknown command");
                    break;
              
            }
        }
    }
    
    private void displayItems() throws Exception{
    
        List<Item> items = service.getItems();
        view.listItems(items);
    }
    
    public void getMoney() throws Exception{
        
        double cash = view.getPayment();
        String itemSelected = view.getItem();
        String change = service.buyItem(itemSelected, cash);
        view.displayChange(change);
    }
    
    
}
