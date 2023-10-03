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
        FileWriter fw=new FileWriter("C:\\Users\\ftoon\\Downloads\\Telegram Desktop\\305Project\\305Project\\ArtCourses.txt",true);
        fw.write("4- CERAMIC ARTS \n");
        fw.write("5- VISUAL ARTS  \n");
        fw.write("6- HAND CRAFTS AND SCULPTURING  \n");
        fw.write("---------------------------------  \n");
        
        fw.close();
    }
    
    
}
