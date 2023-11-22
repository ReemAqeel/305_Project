/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305project;

import java.io.*;
import java.io.*;

/**
 *
 * @author Surface
 */

//in this class we will only write the type of courses in a file using FileWriter
//later on these courses will be displayed to the user
public class ArtCourses {
    
    //write method
    public void write() throws IOException{
        FileWriter fw=new FileWriter("C:\\Users\\Surface\\Downloads\\305project\\ArtCourses.txt",true);
        fw.write("1- CERAMIC ARTS \n");
        fw.write("2- VISUAL ARTS  \n");
        fw.write("3- HAND CRAFTS AND SCULPTURING  \n");
        fw.write("---------------------------------  \n");
        
        fw.close();
    }
    
    
}
