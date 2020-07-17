/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary;

import com.bobazimov.dvdlibrary.controller.DvdLibraryController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author irabob
 */

public class App {
    public static void main(String[] args) throws Exception {
            
//        UserIO myIo = new UserIOImpl();
//        DvdLibraryView myView = new DvdLibraryView(myIo);
//        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
//        DvdAuditDao myAudit = new DvdAuditDaoImpl();
//        DvdLibraryServiceLayer myService = new DvdLibraryServiceLayerImpl(myDao, myAudit);
//        DvdLibraryController controller = new DvdLibraryController(myView, myService);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.bobazimov.dvdlibrary");
        ctx.refresh();
        
        DvdLibraryController controller = ctx.getBean("dvdLibraryController", DvdLibraryController.class);

        controller.run();
    
    
    }
    
}
