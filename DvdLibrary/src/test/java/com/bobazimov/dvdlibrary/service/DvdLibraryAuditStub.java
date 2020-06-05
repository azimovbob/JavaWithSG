/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.service;

import com.bobazimov.dvdlibrary.dao.DvdAuditDao;
import com.bobazimov.dvdlibrary.dao.DvdLibraryPersistenceException;

/**
 *
 * @author irabob
 */
public class DvdLibraryAuditStub implements DvdAuditDao{

    @Override
    public void writeEntry(String entry) throws DvdLibraryPersistenceException {
        //do nothing
    }
    
}
