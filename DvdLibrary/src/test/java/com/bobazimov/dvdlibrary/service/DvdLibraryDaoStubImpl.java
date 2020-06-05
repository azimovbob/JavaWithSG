/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.service;

import com.bobazimov.dvdlibrary.dao.DvdLibraryDao;
import com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irabob
 */
public class DvdLibraryDaoStubImpl implements DvdLibraryDao{

    public DvdLibrary onlyDvd;
    
    public DvdLibraryDaoStubImpl() {
        String titleOne = "Avatar";
        
        onlyDvd = new DvdLibrary(titleOne);
        onlyDvd.setDirectorName("Cameron");
        onlyDvd.setStudio("Paramount");
        onlyDvd.setReleaseDate("January 6th");
        onlyDvd.setMpaaRating("5");
        onlyDvd.setUserNote("Cool movie");
    }
    
    public DvdLibraryDaoStubImpl(DvdLibrary testDvd) {
        this.onlyDvd = testDvd;
    }
    
    @Override
    public DvdLibrary addDvd(String title, DvdLibrary dvd) throws DvdLibraryPersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else {
            return null;
        }
    }

    @Override
    public List<DvdLibrary> getCollections() throws DvdLibraryPersistenceException {
        List<DvdLibrary> dvdList = new ArrayList<>();
        dvdList.add(onlyDvd);
        return dvdList;
    }

    @Override
    public DvdLibrary getChosenDvd(String title) throws DvdLibraryPersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }
    }

    @Override
    public DvdLibrary removeDvd(String title) throws DvdLibraryPersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }
    }

    @Override
    public DvdLibrary updateDvd(String title, DvdLibrary dvdRecord) throws DvdLibraryPersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }
    }
    
}
