/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.service;

import java.math.BigDecimal;

/**
 *
 * @author irabob
 */
public class Change {
    
    BigDecimal number;
    private double change;
    
    public Change(){}
    
    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
    
    public String calculate(){
        number = new BigDecimal("change");
        return number.toString();
    }
}

    
