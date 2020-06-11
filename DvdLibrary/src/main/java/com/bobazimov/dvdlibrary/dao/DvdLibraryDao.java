/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.dao;

import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.util.List;
import java.util.OptionalDouble;

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
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException 
     */
    DvdLibrary addDvd(String title, DvdLibrary dvd) throws DvdLibraryPersistenceException;
    /**
     * 
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException 
     */
    List<DvdLibrary> getCollections() throws DvdLibraryPersistenceException;
    /**
     * 
     * @param title
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException 
     */
    DvdLibrary getChosenDvd(String title) throws DvdLibraryPersistenceException;
    /**
     * 
     * @param title
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException 
     */
    DvdLibrary removeDvd(String title) throws DvdLibraryPersistenceException;
    
    /**
     * 
     * @param title
     * @param dvdRecord
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException 
     */
    DvdLibrary updateDvd(String title, DvdLibrary dvdRecord) throws DvdLibraryPersistenceException;
    
    /**
     * 
     * 
     * @param years
     * @return 
     * @throws com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException 
     */
    List<DvdLibrary> getDvdNYears(int years) throws DvdLibraryPersistenceException;
 
    /**
     * 
     * @param rating
     * @return
     * @throws DvdLibraryPersistenceException 
     */
    List<DvdLibrary> getDvdInGivenRating(float rating) throws DvdLibraryPersistenceException;
    
    /**
     * Given director name, return list of dvds with assosiated name
     * @param director
     * @return
     * @throws DvdLibraryPersistenceException 
     */
    List<DvdLibrary> getDvdWithGivenDirector(String director) throws DvdLibraryPersistenceException;
    
    OptionalDouble getAverageRating(List<DvdLibrary> dvdList) throws DvdLibraryPersistenceException;
}
