/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class DvdAuditDaoImpl implements DvdAuditDao {

    public static final String AUDIT_FILE= "dvdaudit.txt";
    
    @Override
    public void writeEntry(String entry) throws DvdLibraryPersistenceException {
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
            
        }catch(IOException ex){
            throw new DvdLibraryPersistenceException("Could not find file. ", ex);
        }
        
        LocalDateTime timeStamp =  LocalDateTime.now();
        
        out.println(timeStamp.toString() + " : " + entry);
        out.flush();
        out.close();
    }
    
}
