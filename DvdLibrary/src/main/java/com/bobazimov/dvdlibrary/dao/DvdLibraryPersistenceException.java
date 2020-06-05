/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.dao;

/**
 *
 * @author irabob
 */
public class DvdLibraryPersistenceException extends Exception{
    
    public DvdLibraryPersistenceException(String msg){
        super(msg);
    }
    
    public DvdLibraryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
