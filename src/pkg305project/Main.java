/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305project;
import java.util.*;
import java.io.*;
import java.nio.*;
public class Main {

    public static void main(String[] args) throws IOException {
        
        //program will start writing the courses in a file 
        STEMCourses stem=new STEMCourses();
        ArtCourses art=new ArtCourses();
        stem.write();
        art.write();
        
        
    }
    
}
