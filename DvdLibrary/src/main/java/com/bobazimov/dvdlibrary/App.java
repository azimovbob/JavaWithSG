/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary;

import com.bobazimov.dvdlibrary.controller.DvdLibraryController;
import com.bobazimov.dvdlibrary.dao.DvdLibraryDao;
import com.bobazimov.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.bobazimov.dvdlibrary.view.DvdLibraryView;
import com.bobazimov.dvdlibrary.view.UserIO;
import com.bobazimov.dvdlibrary.view.UserIOImpl;

/**
 *
 * @author irabob
 */
public class App {
    public static void main(String[] args) throws Exception {
            
        UserIO myIo = new UserIOImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myView, myDao);

        controller.run();
    
    
    }
    
}
