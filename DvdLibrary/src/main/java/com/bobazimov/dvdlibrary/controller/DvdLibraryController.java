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

/**
 *
 * @author irabob
 */
public class DvdLibraryController {
    
    private DvdLibraryView view;
    private DvdLibraryServiceLayer service;
    private UserIO io = new UserIOImpl();
    
    
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
    
    
}
