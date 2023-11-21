/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg305project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ا
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //program will start writing the courses in a file 
        STEMCourses stem=new STEMCourses();
        ArtCourses art=new ArtCourses();
        stem.write();
        art.write();
        
        //calling the frame to open 
        Frame1 f=new Frame1();
        f.show();
        
        
        
        
        
        
        
        
        
        
        
        
        
        //database 
//         Connection con = null;
//       try
//       {
//           //Creating the DB
//        String ConnectionURL = "jdbc:mysql://localhost:3306";
//        con = DriverManager.getConnection(ConnectionURL,"root","Nada123") ;
//        Statement st = con.createStatement();
//        st.executeUpdate("CREATE DATABASE "+" Users");
//    con.close();
//        }
//  
//  
//        catch (SQLException s){
//         System.out.println("SQL statement is not executed!");
//        }
// 
//        catch (Exception e){
//          e.printStackTrace();
//        }
 
    
    }
    
}
