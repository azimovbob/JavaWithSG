/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.dao;

import com.bobazimov.dvdlibrary.dao.DvdLibraryDao;
import com.bobazimov.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author irabob
 */
public class DvdLibraryTest {
    
    
    DvdLibraryDao dao;
    
    public DvdLibraryTest() {
    }
      
    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testfile.txt";
        
        new FileWriter(testFile);
        dao = new DvdLibraryDaoFileImpl(testFile);
        
    }

    @Test
    public void testSomeMethod() {
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testAddDvd() throws DvdLibraryPersistenceException{
        
        String testTitle = "Brat2";
        
        DvdLibrary testDvd = new DvdLibrary(testTitle);
        //Arrange
        testDvd.setDirectorName("Sergey Bagrov");
        testDvd.setReleaseDate("1998");
        testDvd.setStudio("Moskva Studio");
        testDvd.setMpaaRating("4.9");
        testDvd.setUserNote("Samiy luchshiy film");
      
        //Act
        dao.addDvd(testTitle, testDvd);
        
        DvdLibrary retrievedDvd = dao.getChosenDvd(testTitle);
        
        //Assert
        assertEquals(testDvd.getTitle(), retrievedDvd.getTitle(), "Checking the titles");
        assertEquals(testDvd.getDirectorName(), retrievedDvd.getDirectorName(), "Checking director's name");
        assertEquals(testDvd.getStudio(), retrievedDvd.getStudio(), "Checking a studio");
        assertEquals(testDvd.getMpaaRating(), retrievedDvd.getMpaaRating(), "Checking mpaa rating");
        assertEquals(testDvd.getUserNote(), retrievedDvd.getUserNote(), "Checking user note");
        
    }
    
    @Test
    public void testAddGetAll() throws Exception{
        
        //Arrange
        String titleOne = "Avatar";
        
        DvdLibrary testOne = new DvdLibrary(titleOne);
        testOne.setDirectorName("Cameron");
        testOne.setStudio("Paramount");
        testOne.setReleaseDate("January 6th");
        testOne.setMpaaRating("5");
        testOne.setUserNote("Cool movie");
        
        String titleTwo = "Brigada";
        DvdLibrary testTwo = new DvdLibrary(titleTwo);
        testTwo.setDirectorName("Aleksander");
        testTwo.setStudio("Piter Studio");
        testTwo.setReleaseDate("January 6th");
        testTwo.setMpaaRating("4.5");
        testTwo.setUserNote("Mafia movie");
        
        //Act
        dao.addDvd(titleOne, testOne);
        dao.addDvd(titleTwo, testTwo);
        
        List<DvdLibrary> dvds = dao.getCollections();
        //Assert
        assertNotNull(dvds, "List must not be null");
        assertEquals(2, dvds.size(), "Size must be two");

        
        //assertTrue(dvds.contains(testOne), "It should contain testOne object");
        assertTrue(dao.getCollections().contains(testTwo), "It should contain testOne object");
        assertTrue(dao.getCollections().contains(testOne), "It should contain testTwo object");
        
    }
    
    @Test
    public void testGetRemove() throws Exception{
        
        //Arrange
        String titleOne = "Avatar";
        
        DvdLibrary testOne = new DvdLibrary(titleOne);
        testOne.setDirectorName("Cameron");
        testOne.setStudio("Paramount");
        testOne.setReleaseDate("January 6th");
        testOne.setMpaaRating("5");
        testOne.setUserNote("Cool movie");
        
        String titleTwo = "Brigada";
        DvdLibrary testTwo = new DvdLibrary(titleTwo);
        testTwo.setDirectorName("Aleksander");
        testTwo.setStudio("Piter Studio");
        testTwo.setReleaseDate("January 6th");
        testTwo.setMpaaRating("4.5");
        testTwo.setUserNote("Mafia movie");
        
        //Act
        dao.addDvd(titleOne, testOne);
        dao.addDvd(titleTwo, testTwo);
        
        DvdLibrary removedDvd =  dao.removeDvd(testOne.getTitle());
        
        //Assert
        List<DvdLibrary> allDvds = dao.getCollections();
        assertEquals(testOne, removedDvd, "These two objects must be equal");
        assertFalse(allDvds.contains(testOne), "These is false statement");
       
    }
    
    @Test
    public void testGetUpdate() throws Exception{
                //Arrange
        String titleOne = "Avatar";
        
        DvdLibrary testOne = new DvdLibrary(titleOne);
        testOne.setDirectorName("Cameron");
        testOne.setStudio("Paramount");
        testOne.setReleaseDate("January 6th");
        testOne.setMpaaRating("5");
        testOne.setUserNote("Cool movie");
        
        String titleTwo = "Brigada";
        DvdLibrary testTwo = new DvdLibrary(titleTwo);
        testTwo.setDirectorName("Aleksander");
        testTwo.setStudio("Piter Studio");
        testTwo.setReleaseDate("January 6th");
        testTwo.setMpaaRating("4.5");
        testTwo.setUserNote("Mafia movie");
        
        
        
        //Act
        dao.addDvd(titleOne, testOne);
        dao.addDvd(titleTwo, testTwo);
        
        testTwo.setDirectorName("Sergey");
        testTwo.setReleaseDate("02202020");
        testTwo.setStudio("Piter Studio");
        testTwo.setMpaaRating("3");
        testTwo.setUserNote("Mafia movie");
        
        dao.addDvd(testTwo.getTitle(), testTwo);
        DvdLibrary updatedDvd = dao.updateDvd(titleTwo, testTwo);
        
        assertEquals(testTwo, updatedDvd,"It mustbe equal");
    }
    
}
