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
public class DvdLibraryDaoException extends Exception{
    
    public DvdLibraryDaoException(String msg){
        super(msg);
    }
    
    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
