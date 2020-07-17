/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.service;

import com.bobazimov.dvdlibrary.dao.DvdAuditDao;
import com.bobazimov.dvdlibrary.dao.DvdLibraryDao;
import com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.util.List;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DvdLibraryServiceLayerImpl implements DvdLibraryServiceLayer {

    DvdLibraryDao dvdDao;
    DvdAuditDao audit;
    @Autowired
    public DvdLibraryServiceLayerImpl(DvdLibraryDao dvdDao, DvdAuditDao audit) {
        this.dvdDao = dvdDao;
        this.audit = audit;
        
    }
    
    
    private void validateDvdData(DvdLibrary dvd) throws DvdLibraryDataValidationException{
        if(dvd.getTitle()==null 
                || dvd.getTitle().trim().length()==0
                || dvd.getDirectorName() == null
                || dvd.getDirectorName().trim().length() == 0
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0
                || dvd.getMpaaRating() == null
                || dvd.getMpaaRating().trim().length() == 0
                || dvd.getUserNote() == null
                || dvd.getUserNote().trim().length() == 0){
            throw new DvdLibraryDataValidationException(
                    "ERROR: All fields [title, release date, director name, studio, rating, review] required ");
        }
    }
    
    @Override
    public void createDvd(DvdLibrary dvd) throws 
            DvdLibraryDublicateException, 
            DvdLibraryDataValidationException, 
            DvdLibraryPersistenceException {
        if(dvdDao.getChosenDvd(dvd.getTitle()) != null){
            throw new DvdLibraryDublicateException(
              "ERROR: Could not create DVD " + 
                      dvd.getTitle() + 
                      " Already exists. "
                   
            );
        }
        
        validateDvdData(dvd);
        dvdDao.addDvd(dvd.getTitle(), dvd);
        audit.writeEntry("DVD " + dvd.getTitle() + " CREATED ");
    }

    @Override
    public List<DvdLibrary> getAllDvd() throws DvdLibraryPersistenceException {
        if(dvdDao.getCollections().isEmpty()){
            throw new DvdLibraryPersistenceException(" ERROR: Collection is empty");
        }
        
        return dvdDao.getCollections();
    }

    @Override
    public DvdLibrary getDvd(String dvdTitle) throws DvdLibraryPersistenceException {
        
        if(!dvdDao.getCollections().contains(dvdDao.getChosenDvd(dvdTitle))){
           throw new DvdLibraryPersistenceException("ERROR: Such student not exists");
        }
        
         return dvdDao.getChosenDvd(dvdTitle);
    }

    @Override
    public DvdLibrary removeDvd(String dvdTitle) throws DvdLibraryPersistenceException {
        DvdLibrary removedDvd = dvdDao.removeDvd(dvdTitle);
        audit.writeEntry("DVD " + dvdTitle + " REMOVED ");
        return removedDvd;
    }

    @Override
    public DvdLibrary updateDvd(String dvdTitle, DvdLibrary dvd) throws 
            DvdLibraryPersistenceException,
            DvdLibraryDataValidationException,
            DvdLibraryDublicateException{
        if(dvdDao.getChosenDvd(dvdTitle) == null) {
            throw new DvdLibraryPersistenceException("ERROR: No such student");
        }
        
        validateDvdData(dvd);
        
        return dvdDao.updateDvd(dvdTitle, dvd);

    }

    @Override
    public List<DvdLibrary> getDvdNYear(int year) throws DvdLibraryPersistenceException {
        return dvdDao.getDvdNYears(year);
    }

    @Override
    public List<DvdLibrary> getDvdRating(float rating) throws DvdLibraryPersistenceException {
        return dvdDao.getDvdInGivenRating(rating);
    }

    @Override
    public List<DvdLibrary> getDvdDirector(String director) throws DvdLibraryPersistenceException {
        return dvdDao.getDvdWithGivenDirector(director);
    }

    @Override
    public OptionalDouble getAverage(List<DvdLibrary> dvdList) throws DvdLibraryPersistenceException {
        return dvdDao.getAverageRating(dvdList);
    }
    
    
    
    
    
}
