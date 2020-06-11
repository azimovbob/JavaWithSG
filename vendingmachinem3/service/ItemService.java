/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.service;

import com.bobazimov.vendingmachinem3.dto.Item;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface ItemService {
    
    /**
     * return items that has quantity is greater that 0
     * @return List of items 
     * @throws java.lang.Exception 
     */
    List<Item> getItems() throws Exception;
    
    /**
     * It gets a name and price, first it checks if that item is exist 
     * second checks for price match
     * third if price match or cash is greater than price call change object
     * @param name itemName
     * @param price itemPrice
     * @return double
     * @throws java.lang.Exception
     */
    String buyItem(String name, double price) throws Exception;
    
    
}
