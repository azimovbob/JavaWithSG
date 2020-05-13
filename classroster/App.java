/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bobazimov.classroaster;
import com.bobazimov.classroaster.controller.ClassRoasterController;

/**
 *
 * @author irabob
 */
public class App {

    public static void main(String[] args) {
        ClassRoasterController controller = new ClassRoasterController();
        controller.run();
    }   
}