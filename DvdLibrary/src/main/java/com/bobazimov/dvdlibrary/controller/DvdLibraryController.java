/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.controller;

import com.bobazimov.dvdlibrary.dao.DvdLibraryDao;
import com.bobazimov.dvdlibrary.dto.DvdLibrary;
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
    private  DvdLibraryDao dao;
    private UserIO io = new UserIOImpl();
    
    
    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;
        
    }
    
    
    
    public void run() throws Exception{
        int menuOption = 0;
        boolean keepGoing = true;
        
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
                addDvd();
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
    }
    
    private int getMenuOption(){
        return view.printMenuAndGetSelection();
    }
    
    private void addDvd() throws Exception{
        DvdLibrary dvd = view.getDvdInfo();
        dao.addDvd(dvd.getTitle(), dvd);
    }
    
    private void listCollections() throws Exception{
        List<DvdLibrary> dvdList = dao.getCollections();
        view.getList(dvdList);
    }
    
    private void displayDvd() throws Exception{
        String dvd = view.getChosenDvd();
        DvdLibrary currentDvd = dao.getChosenDvd(dvd);
        view.displayChosenDvd(currentDvd);
    }
    
    private void removeDvd() throws Exception{
        String removedDvd = view.getChosenDvd();
        DvdLibrary dvdRecord = dao.removeDvd(removedDvd);
        view.displayRemovedDvd(dvdRecord);
    }
    
    public void updateDvd() throws Exception{
        String dvdTitle = view.getChosenDvd();
        DvdLibrary dvdRecord = dao.getChosenDvd(dvdTitle);
        dvdRecord = view.updateDvd(dvdRecord);
        dao.updateDvd(dvdTitle, dvdRecord);
         
    }
    
    public void displayEndofAcitivty(){
        view.displayEndMsg();
    }
    
    
}
