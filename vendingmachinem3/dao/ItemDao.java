/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.dao;

import com.bobazimov.vendingmachinem3.dto.Item;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface ItemDao {
    /**
     * It will list all available items in stock
     * @return List of items
     * @throws java.lang.Exception
     */
    List<Item> getItems() throws Exception;
    
    /**
     * It gets item name and returns item with associated  name
     * @param name 
     * @return  item
     * @throws java.lang.Exception
     */
    Item buyItem(String name) throws Exception;
    
    /**
     * 
     * @param name
     * @param item 
     */
    void update(String name, Item item) throws Exception;
    
    
}
