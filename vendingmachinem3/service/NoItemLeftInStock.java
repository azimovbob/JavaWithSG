/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.service;

/**
 *
 * @author irabob
 */
public class NoItemLeftInStock extends Exception{
    
    public NoItemLeftInStock(String msg){
        super(msg);
    }
    
    public NoItemLeftInStock(String msg, Throwable cause){
        super(msg, cause);
    }
    
    
}
