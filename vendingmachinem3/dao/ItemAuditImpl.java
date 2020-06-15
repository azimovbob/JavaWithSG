/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.vendingmachinem3.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ItemAuditImpl implements ItemAudit {

    public final static String  AUDIT_TXT = "itemaudit.txt";
    
    @Override
    public void writeEntry(String message) throws Exception{
       
        PrintWriter out;
        
        
        try{
           out = new PrintWriter(new FileWriter(AUDIT_TXT, true));
           
        }catch(IOException ex){
            throw new IOException(ex);
        }
           LocalDateTime timeStamp = LocalDateTime.now();
           String timeStampStr = timeStamp.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
           out.println(timeStampStr + " " + message + " sold");
           out.flush();
           out.close();
            
    }
    
}
