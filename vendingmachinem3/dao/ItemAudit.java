/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.dao;

/**
 *
 * @author irabob
 */
public interface ItemAudit {
    
    void writeEntry(String message) throws Exception;
}
