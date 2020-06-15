/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.service;

import com.bobazimov.vendingmachinem3.dto.Coin;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author irabob
 */
public class Change {
    
    BigDecimal quater, dime, nickle, penny;
    private BigDecimal change;
    Coin coin;
    int quat, dim, nick, pen;
    
    
    public Change(BigDecimal change){
        
        quater = new BigDecimal("0.25");
        dime = new BigDecimal("0.10");
        nickle = new BigDecimal("0.05");
        penny = new BigDecimal("0.01");
        this.change = change;
          
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    
    public String calculate(){
        
        
        if( change.compareTo(quater) == 0 || change.compareTo(quater)==1 ){
                    quat = change.divide(quater, RoundingMode.UP).intValue();
                    change = change.remainder(quater);
            
        }
        
        if( change.compareTo(quater) == 0 || change.compareTo(quater)==1 ){
                    dim = change.divide(dime, RoundingMode.UP).intValue();
                    change = change.remainder(dime);
            
        }
       
        if( change.compareTo(nickle) == 0 || change.compareTo(nickle)==1 ){
                    nick = change.divide(nickle, RoundingMode.UP).intValue();
                    change = change.remainder(nickle);
            
        }
        
        pen = change.divide(penny, RoundingMode.UP).intValue();
        
        
        return (Coin.QUATER + " x " + quat + "\n" + 
                Coin.DIME + " x " + dim + "\n" + 
                Coin.NICKLE + " x " + nick + "\n" + 
                Coin.PENNY + " x " + pen);
    }
}

    
