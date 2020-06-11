/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.service;

import com.bobazimov.vendingmachinem3.dao.ItemDao;
import com.bobazimov.vendingmachinem3.dto.Item;
import java.util.List;
import java.util.stream.Collectors;


public class ItemServiceImpl implements ItemService {
    
    ItemDao dao;
    
    public ItemServiceImpl(ItemDao dao){
        this.dao = dao;
    }

    @Override
    public List<Item> getItems() throws Exception{
        
        List<Item> itemsList = dao.getItems();
        return  itemsList.stream()
                    .filter((x)-> x.getQuantity() != 0 )
                    .collect(Collectors.toList());
    }

    @Override
    public String buyItem(String name, double price) throws Exception{
        
       validateItem(name);
       Item item = dao.buyItem(name);
       int count = item.getQuantity()-1;
       if(price < item.getPrice() ){
           return ("Insuficent fund " + item.getName() + " is cost " + item.getPrice());
       } 
       item.setQuantity(count);
       dao.update(name, item);

       return (Double.toString(price-item.getPrice()));
    
    }
 
    
    private void validateItem(String item) throws Exception{
        if(dao.buyItem(item) == null){
            throw new Exception("Item not exist");
        }
    }
    
}
