/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.dao;

import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author irabob
 */
public interface DvdLibraryDao {
    /**
     Adds dvd to the file 
     * @param title
     * @param dvd
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryDaoException 
     */
    DvdLibrary addDvd(String title, DvdLibrary dvd) throws DvdLibraryDaoException;
    /**
     * 
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryDaoException 
     */
    List<DvdLibrary> getCollections() throws DvdLibraryDaoException;
    /**
     * 
     * @param title
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryDaoException 
     */
    DvdLibrary getChosenDvd(String title) throws DvdLibraryDaoException;
    /**
     * 
     * @param title
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryDaoException 
     */
    DvdLibrary removeDvd(String title) throws DvdLibraryDaoException;
    /**
     * 
     * @param title
     * @param dvdRecord
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryDaoException 
     */
    DvdLibrary updateDvd(String title, DvdLibrary dvdRecord) throws DvdLibraryDaoException;
    
    
}
