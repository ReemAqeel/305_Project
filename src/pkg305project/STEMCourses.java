/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305project;
import java.util.*;
import java.io.*;
import java.nio.*;

/**
 *
 * @author Surface
 */

//in this class we will only write the type of courses in a file using FileWriter
//later on these courses will be displayed to the user
public class STEMCourses {

    //write method
    public void write() throws IOException{
        FileWriter fw=new FileWriter("C:\\Users\\ftoon\\Downloads\\Telegram Desktop\\305Project\\305Project\\STEMCourses.txt");
        fw.write("1- ARTIFICAL INTALEGENT \n");
        fw.write("2- IP ADRESSING AND SUBNETTING  \n");
        fw.write("3- INFORMATION SECURITY IN PYTHON  \n");
        fw.write("---------------------------------  \n");
        
        fw.close();
    }
    
}
