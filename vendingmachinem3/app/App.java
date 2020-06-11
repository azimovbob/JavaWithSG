/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.app;

import com.bobazimov.vendingmachinem3.controller.ItemController;
import com.bobazimov.vendingmachinem3.dao.ItemDao;
import com.bobazimov.vendingmachinem3.dao.ItemDaoImpl;
import com.bobazimov.vendingmachinem3.service.ItemService;
import com.bobazimov.vendingmachinem3.service.ItemServiceImpl;
import com.bobazimov.vendingmachinem3.ui.ItemView;
import com.bobazimov.vendingmachinem3.ui.UserIO;
import com.bobazimov.vendingmachinem3.ui.UserIOImpl;

/**
 *
 * @author irabob
 */
public class App {
    
    public static void main(String[] args) throws Exception{
        
        UserIO myIo = new UserIOImpl();
        ItemView myView = new ItemView(myIo);
        
        ItemDao myDao = new ItemDaoImpl();
        ItemService myService = new ItemServiceImpl(myDao);
        
        ItemController myController = new ItemController(myView, myService);
        
        myController.run();
    }
    
}
