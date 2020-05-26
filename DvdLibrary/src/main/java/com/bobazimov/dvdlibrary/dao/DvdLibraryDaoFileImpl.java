/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.dao;

import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    private Map<String, DvdLibrary> dvds = new HashMap();
    
    public static final String DVD_FILE = "dvdlibrary.txt";
    public static final String DELIMITER = "::";

    @Override
    public DvdLibrary addDvd(String title, DvdLibrary dvd) throws DvdLibraryDaoException{
        read();
        DvdLibrary newDvd = dvds.put(title, dvd);
        write();
        return newDvd;
    }

    @Override
    public List<DvdLibrary> getCollections() throws DvdLibraryDaoException{
        read();
        return new ArrayList<DvdLibrary>(dvds.values());
    }

    @Override
    public DvdLibrary getChosenDvd(String title) throws DvdLibraryDaoException{
        read();
        return dvds.get(title);
    }

    @Override
    public DvdLibrary removeDvd(String title) throws DvdLibraryDaoException{
        read();
        DvdLibrary dvdRecord = dvds.remove(title);
        write();
        return dvdRecord;
    }

    @Override
    public DvdLibrary updateDvd(String title, DvdLibrary dvdRecord) throws DvdLibraryDaoException{
        read();
        DvdLibrary currentDvd = dvds.put(title, dvdRecord);
        write();
        return currentDvd;
    }
    
    private DvdLibrary unmarshalling(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DvdLibrary currentDvd = new DvdLibrary(title);
        currentDvd.setReleaseDate(dvdTokens[1]);
        currentDvd.setDirectorName(dvdTokens[2]);
        currentDvd.setStudio(dvdTokens[3]);
        currentDvd.setMpaaRating(dvdTokens[4]);
        currentDvd.setUserNote(dvdTokens[5]);
        
        return currentDvd;
    }
    
    private String marshalling(DvdLibrary aDvdLibrary){
        String dvdText = (aDvdLibrary.getTitle() + DELIMITER + aDvdLibrary.getReleaseDate() + DELIMITER +
                          aDvdLibrary.getDirectorName() + DELIMITER + aDvdLibrary.getStudio() + DELIMITER +
                          aDvdLibrary.getMpaaRating() + DELIMITER + aDvdLibrary.getUserNote());
        
        return dvdText;
    }
    
    private void write() throws DvdLibraryDaoException{
        PrintWriter out;
        try{
        out = new PrintWriter(new FileWriter(DVD_FILE));
        }catch(IOException e){
            throw new DvdLibraryDaoException("Cannot save the data", e);
        }
        String dvdAsText;
        
        List<DvdLibrary> dvdList = new ArrayList<>(dvds.values());
        
        for(DvdLibrary currentDvd: dvdList){
            dvdAsText = marshalling(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        
        out.close();
    }
    
    private void read() throws DvdLibraryDaoException{
        Scanner scanner;
        try{
        scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        }catch(FileNotFoundException e){
            throw new DvdLibraryDaoException("File not found ", e);
        }
        String currentLine;
        
        DvdLibrary currentDvd;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDvd = unmarshalling(currentLine);
            
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }
}
