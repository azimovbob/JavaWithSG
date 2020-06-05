/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.service;

/**
 *
 * @author irabob
 */
public class DvdLibraryDublicateException extends Exception {

    public DvdLibraryDublicateException(String message) {
        super(message);
    }
    
    public DvdLibraryDublicateException(String message, Throwable cause){
        super(message, cause);
    }
}
