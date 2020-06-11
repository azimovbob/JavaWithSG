/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.dto;

/**
 *
 * @author irabob
 */
public class Item {
    
    private String name;
    private Double price;
    private int quantity;

    public Item (String name, Double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

//Change the setters and getter 