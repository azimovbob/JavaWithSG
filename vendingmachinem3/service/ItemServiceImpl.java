/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.service;

import com.bobazimov.vendingmachinem3.dao.ItemAudit;
import com.bobazimov.vendingmachinem3.dao.ItemDao;
import com.bobazimov.vendingmachinem3.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;


public class ItemServiceImpl implements ItemService {
    
    ItemDao dao;
    ItemAudit audit;
    Change change;
    BigDecimal customerCash, itemPrice;
    
    
    public ItemServiceImpl(ItemDao dao, ItemAudit audit){
        this.dao = dao;
        this.audit = audit;
        
    }

    @Override
    public List<Item> getItems() throws Exception{
        
        List<Item> itemsList = dao.getItems();
        return  itemsList.stream()
                    .filter((x)-> x.getQuantity() != 0 )
                    .collect(Collectors.toList());
    }

    @Override
    public String buyItem(String name, double cash) throws Exception{
        
       validateItem(name);
       Item item = dao.buyItem(name);
       int count = item.getQuantity()-1;
       if(cash < item.getPrice() ) {
           throw new NoEnoughMoneyException("Insuficent fund " + item.getName() + " is cost " + item.getPrice());
       } 
       item.setQuantity(count);
       dao.update(name, item);
       audit.writeEntry(name);
       customerCash = new BigDecimal(Double.toString(cash));
       itemPrice = new BigDecimal(Double.toString(item.getPrice()));
       change = new Change(customerCash.subtract(itemPrice));
       return change.calculate();
    
    }
 
    
    private void validateItem(String item) throws NoItemLeftInStock,Exception{
        if(dao.buyItem(item) == null){
            throw new Exception("Item not exist");
        }
        else if(dao.buyItem(item).getQuantity() == 0){
            throw new NoItemLeftInStock("Out of stock");
        }
    }
    
   
    
}
