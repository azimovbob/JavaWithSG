/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.dvdlibrary.view;

import com.bobazimov.dvdlibrary.dto.DvdLibrary;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author irabob
 */
public class DvdLibraryView {
    
    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
    
    
    
    public int printMenuAndGetSelection(){
    
        io.print("Main Menu");
        io.print("1. List Dvd Collections");
        io.print("2. Create New Dvd");
        io.print("3. View a Dvd");
        io.print("4. Remove a Dvd record");
        io.print("5. Update a Dvd record");
        io.print("6. Exit");
        io.print("7. Display dvds for given year");
        io.print("8. Display dvds for given rating");
        io.print("9. Display dvds for given director name");
        io.print("10. Display average rating");
        
        return io.readInt("Please select from above choice: ", 1, 10);
    }
    
    
    public DvdLibrary getDvdInfo(){
        String title = io.readString("Enter name");
        String releaseDate = getReleaseDate();
        String mpaaRating = io.readString("Enter rating");
        String directorName = io.readString("Enter director's name");
        String studio = io.readString("Enter studio");
        String userNote = io.readString("Enter review");
        DvdLibrary currentDvd = new DvdLibrary(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setUserNote(userNote);
        
        return currentDvd;
    }
    
    public void getList(List<DvdLibrary> dvdList){
        
        for(DvdLibrary currentDvd: dvdList){
            String dvdInfo = String.format("#%s: %s %s %s %s %s", 
                    
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getUserNote());
            
            io.print(dvdInfo);
            
        }
     
    }
    
    public String getChosenDvd(){
        return io.readString("Enter the title");
        
    }
    
    public void displayChosenDvd(DvdLibrary chosenDvd){
      if(chosenDvd!=null){
          io.print(chosenDvd.getTitle());
          io.print(chosenDvd.getReleaseDate());
          io.print(chosenDvd.getDirectorName());
          io.print(chosenDvd.getStudio());
          io.print(chosenDvd.getMpaaRating());
          io.print(chosenDvd.getUserNote());
      }else{
          io.print("No such record");
      }
    }
    
    public void displayRemovedDvd(DvdLibrary dvdRecord){
        if(dvdRecord!=null){
            io.print("Dvd successfully deleted");
        }else{
            io.print("No such record");
        }
    }
    
    public DvdLibrary updateDvd(DvdLibrary dvdRecord){
        if(dvdRecord!=null){
            String newReleaseDate = getReleaseDate();
            String newDirectorName = io.readString("Enter director name");
            String newStudio = io.readString("Enter studio");
            String newMpaaRating = io.readString("Enter mpaa rating");
            String newUserReview = io.readString("Enter user review");
            
            dvdRecord.setDirectorName(newDirectorName);
            dvdRecord.setReleaseDate(newReleaseDate);
            dvdRecord.setMpaaRating(newMpaaRating);
            dvdRecord.setStudio(newStudio);
            dvdRecord.setUserNote(newUserReview);
        }else{
            io.print("No record found");
        }
        
        return dvdRecord;
    }
    
    public void DisplayContinueMsg(){
        io.readString("Please enter to continue");
    }
    
    public void displayDvdCollectionMsg(){
        io.print("=== Display Collections =====\n");
    }
    
    public void displayEndMsg(){
        io.print("===============\n");
        io.readString("Please hit enter continue");
    }
    
    public void displaySingleDvdMsg(){
        io.print("=== Display a DVD =====\n");
    }
    
    public void displayDvdCreateMsg(){
        io.print("=== Create a DVD =====\n");
    }
    
    public void displayUpdateDvdMsg(){
        io.print("=== Update DVD Info =====\n");
    }
    
    public void displayRemoveDvdMsg(){
        io.print("=== Remove dvd ====\n");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public String getReleaseDate(){
        
        LocalDate ld;
        String isoDate;
        isoDate = io.readString("Enter relaese date MM/dd/yyyy");
        ld = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String iso = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return iso;
                
    }
    
    public void getDvdNYear(List<DvdLibrary> dvdList){
        
        for(DvdLibrary currentDvd: dvdList){
            String dvdInfo = String.format("#%s: %s %s %s %s %s", 
                    
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getUserNote());
            
            io.print(dvdInfo);
            
        }
    }
    
    public void getDvdNRating(List<DvdLibrary> dvdList){
    
        for(DvdLibrary currentDvd: dvdList){
            String dvdInfo = String.format("#%s: %s %s %s %s %s", 
                    
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getUserNote());
            
            io.print(dvdInfo);
        }
    }
    
    public void getDvdNDirector(List<DvdLibrary> dvdList){
        
        for(DvdLibrary currentDvd: dvdList){
            String dvdInfo = String.format("#%s: %s %s %s %s %s", 
                    
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getUserNote());
            
            io.print(dvdInfo);
        }
    }
    
    public void showAverageRating(OptionalDouble average){
        
        io.print(average.toString());
    }
}
