/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.dao;

import com.bobazimov.vendingmachinem3.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ItemDaoImpl implements ItemDao {

    private Map<String, Item> items;
    public final String ITEM_FILE;
    public static final String DELIMITER = "::";
    
    public ItemDaoImpl(){
        ITEM_FILE = "itemsfile.txt";
        this.items = new HashMap<>();
    }
    
    public ItemDaoImpl(String file, Map<String, Item> items){
        this.ITEM_FILE = file;
        this.items = items;
    }
 
    @Override
    public List<Item> getItems() throws Exception{
         read();
         List<Item> testItems = new ArrayList<>(items.values());
         return testItems; 
    }

    @Override
    public Item buyItem(String name)  throws Exception{
        read();
        Item aname = items.get(name);
        return aname;
        
    }
    
    private String marshalling (Item anItem){
        
        String itemAsText = (anItem.getName() + DELIMITER + Double.toString(anItem.getPrice()) + DELIMITER + Integer.toString(anItem.getQuantity()));
        return itemAsText;
        
    }
    
    private Item unmarshalling (String itemAsText) throws Exception{
        
        String[] token = itemAsText.split(DELIMITER);
        Item anItem;
        try{
            anItem = new Item(token[0], Double.parseDouble(token[1]), Integer.parseInt(token[2]));
            //System.out.println(token[0] + " " +  Double.parseDouble(token[1]) + " " + Integer.parseInt(token[2]));
    //        anItem.setPrice(Double.parseDouble(token[1]));
    //        anItem.setQuantity(Integer.parseInt(token[2]));
        }catch(Exception ex){
            throw new Exception("Something wrong ", ex);
        }
        return anItem;
    }
    
    private void read() throws Exception{
        
        Scanner scan;
        try{
            scan = new Scanner(new BufferedReader(new FileReader(ITEM_FILE)));
        }catch(FileNotFoundException ex){
            throw new Exception(ex);
        }
        
        String currentLine;
        Item currentItem;
        
        while(scan.hasNextLine()){
            currentLine = scan.nextLine();
            currentItem = unmarshalling(currentLine);
            
            items.put(currentItem.getName(), currentItem);
        }
        
        scan.close();
        
    }
    
    private void write() throws Exception{
    
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(ITEM_FILE));
        }catch(IOException ex){
            throw new Exception(ex);
        }
        
        String itemAsText;
        
        List<Item> itemList = new ArrayList<>(items.values());
        
        for(Item currentItem: itemList){
            itemAsText = marshalling(currentItem);
            out.println(itemAsText);
            out.flush();
        }
        
        out.close();
    }
    
    @Override
    public void update(String name, Item value) throws Exception{
        read();
        items.replace(name, value);
        write();
    }

    
    //add exeption classes and use BigDecimal if nessassary
}
