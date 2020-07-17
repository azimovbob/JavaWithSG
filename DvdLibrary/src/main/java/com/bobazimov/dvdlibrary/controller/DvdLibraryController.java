/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.controller;

import com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import com.bobazimov.dvdlibrary.service.DvdLibraryDataValidationException;
import com.bobazimov.dvdlibrary.service.DvdLibraryDublicateException;
import com.bobazimov.dvdlibrary.service.DvdLibraryServiceLayer;
import com.bobazimov.dvdlibrary.view.DvdLibraryView;
import com.bobazimov.dvdlibrary.view.UserIO;
import com.bobazimov.dvdlibrary.view.UserIOImpl;
import java.util.List;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author irabob
 */
@Component
public class DvdLibraryController {
    
    private DvdLibraryView view;
    
    
    private DvdLibraryServiceLayer service;
    private UserIO io = new UserIOImpl();
    
    @Autowired
    public DvdLibraryController(DvdLibraryView view, DvdLibraryServiceLayer service) {
        this.view = view;
        this.service = service;
        
    }
    
    
    
    public void run() throws Exception{
        int menuOption = 0;
        boolean keepGoing = true;
        try{
            while(keepGoing){
                menuOption = getMenuOption();
                switch(menuOption){
                    case 1: 
                        view.displayDvdCollectionMsg();
                        listCollections();
                        displayEndofAcitivty();
                        break;
                    case 2: 
                        view.displayDvdCreateMsg();
                        createDvd();
                        displayEndofAcitivty();
                        break;
                    case 3:
                        view.displaySingleDvdMsg();
                        displayDvd();
                        displayEndofAcitivty();
                        break;
                    case 4: 
                        view.displayRemoveDvdMsg();
                        removeDvd();
                        displayEndofAcitivty();
                        break;
                    case 5:
                        view.displayRemoveDvdMsg();
                        updateDvd();
                        displayEndofAcitivty();
                        break;
                    case 6:
                        io.print("Bye Bye");
                        keepGoing = false;
                        break;
                    case 7:
                        displayDvdWithNYears();
                        break;
                    case 8:
                        displayDvdWithNRaing();
                        break;
                    case 9:
                        displayDvdWithGivenDirector();
                        break;
                    case 10:
                        showAvg();
                        break;
                    default: 
                        io.print("Unkown command");
                        break;
                }
            }
        }catch(DvdLibraryPersistenceException e){
            view.displayErrorMessage(e.toString());
        }
    }
    
    private int getMenuOption(){
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryPersistenceException{
        boolean hasError = false;
        do{
            DvdLibrary dvd = view.getDvdInfo();
            try{
                service.createDvd(dvd);
                view.displayDvdCreateMsg();
                hasError = false;
            }catch(DvdLibraryDublicateException | DvdLibraryDataValidationException e ){
                hasError = true;
                view.displayErrorMessage(e.toString());
            }
        }while(hasError);
        
    }
    
    private void listCollections() throws Exception{
        List<DvdLibrary> dvdList = service.getAllDvd();
        view.getList(dvdList);
    }
    
    private void displayDvd() throws Exception{
        String dvd = view.getChosenDvd();
        DvdLibrary currentDvd = service.getDvd(dvd);
        view.displayChosenDvd(currentDvd);
    }
    
    private void removeDvd() throws Exception{
        String removedDvd = view.getChosenDvd();
        DvdLibrary dvdRecord = service.removeDvd(removedDvd);
        view.displayRemovedDvd(dvdRecord);
    }
    
    public void updateDvd() throws Exception{
        String dvdTitle = view.getChosenDvd();
        DvdLibrary dvdRecord = service.getDvd(dvdTitle);
        dvdRecord = view.updateDvd(dvdRecord);
        service.updateDvd(dvdTitle, dvdRecord);
         
    }
    
    public void displayEndofAcitivty(){
        view.displayEndMsg();
    }
    
    
    public void displayDvdWithNYears() throws Exception{
        int year = io.readInt("Enter year of movies");
        List<DvdLibrary> dvdList = service.getDvdNYear(year);
        view.getDvdNYear(dvdList);
    }
    
    public void displayDvdWithNRaing() throws Exception{
        float rating = io.readFloat("Enter rating of movies");
        List<DvdLibrary> dvdList = service.getDvdRating(rating);
        view.getDvdNRating(dvdList);
        
    }
    
    public void displayDvdWithGivenDirector() throws Exception{
        String directorName = io.readString("Enter director name");
        List<DvdLibrary> dvdList = service.getDvdDirector(directorName);
        view.getDvdNDirector(dvdList);
    }
    
    public void showAvg() throws Exception{
        List<DvdLibrary> dvdList = service.getAllDvd();
        OptionalDouble avg = service.getAverage(dvdList);
        view.showAverageRating(avg);
    }
}
