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
public class NoEnoughMoneyException extends Exception{

    public NoEnoughMoneyException(String message) {
        super(message);
    }
    
    public NoEnoughMoneyException(String message, Throwable cause){
        super(message, cause);
    }
    
    
}
