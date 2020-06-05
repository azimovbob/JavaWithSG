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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author irabob
 */
public class DvdLibraryServiceLayerImplTest {
    
    DvdLibraryServiceLayer service;
    
    public DvdLibraryServiceLayerImplTest() {
        
        DvdLibraryDao dao = new DvdLibraryDaoStubImpl();
        DvdAuditDao audit = new DvdLibraryAuditStub();
        
        service = new DvdLibraryServiceLayerImpl(dao, audit);
    }
    
    @Test
    public void testSomeMethod() {
        fail("The test case is a prototype.");
    }
    
    @Test 
    public void testCreatValidDvd() throws Exception{
    
        //Arrange
        DvdLibrary dvd = new DvdLibrary("Robocob");
        dvd.setDirectorName("Johnatan");
        dvd.setReleaseDate("2000");
        dvd.setMpaaRating("3");
        dvd.setStudio("21 Century");
        dvd.setUserNote("Cool");
        //Act
        try{
            service.createDvd(dvd);
        //Assert
        }catch(DvdLibraryDublicateException | DvdLibraryPersistenceException | DvdLibraryDataValidationException e){
            fail("Student was valid. No exception should be thrown");
        }
        
    }
    
    @Test
    public void testCreateDublicateDvd() throws Exception{
        //Arrage
        DvdLibrary dublicateDvd = new DvdLibrary("Avatar");
        dublicateDvd.setDirectorName("Johnatan");
        dublicateDvd.setReleaseDate("2000");
        dublicateDvd.setMpaaRating("3");
        dublicateDvd.setStudio("21 Century");
        dublicateDvd.setUserNote("Cool");
        //Act
        try{
            //Assert
            service.createDvd(dublicateDvd);
            fail("Dublicated dvd, it shouldn't create dvd");
        }catch(DvdLibraryDataValidationException | DvdLibraryPersistenceException e){
            fail("Wrong exception been thrown");
        }catch(DvdLibraryDublicateException ex){
            return;
        }
    }
    
    @Test
    public void testCreateInvalidDataDvd(){
        //Arrange
        DvdLibrary invalidDvd = new DvdLibrary("Pokemon");
        invalidDvd.setDirectorName("Johnatan");
        invalidDvd.setReleaseDate("");
        invalidDvd.setMpaaRating("");
        invalidDvd.setStudio("21 Century");
        invalidDvd.setUserNote("Cool");
        
        //Act
        try{
            //Assert
            service.createDvd(invalidDvd);
            fail("Invalid dvd, it shouldn't create dvd");
        }catch(DvdLibraryDublicateException | DvdLibraryPersistenceException e){
            fail("Wrong exception been thrown");
        }catch(DvdLibraryDataValidationException ex){
            return;
        }
    }
}
