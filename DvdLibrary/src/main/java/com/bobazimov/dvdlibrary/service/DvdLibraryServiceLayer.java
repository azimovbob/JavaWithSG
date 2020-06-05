/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.service;

import com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface DvdLibraryServiceLayer {
    
    public void createDvd(DvdLibrary dvd) throws 
            DvdLibraryDublicateException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException;
    
    List<DvdLibrary> getAllDvd() throws DvdLibraryPersistenceException;
    
    DvdLibrary getDvd(String dvdTitle) throws DvdLibraryPersistenceException;
    
    DvdLibrary removeDvd(String dvdTitle) throws DvdLibraryPersistenceException;
        
    DvdLibrary updateDvd(String dvdTitle, DvdLibrary dvd) throws 
            DvdLibraryPersistenceException,
            DvdLibraryDataValidationException,
            DvdLibraryDublicateException;
}
