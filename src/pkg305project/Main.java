/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg305project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ا
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //--------------------------IO work------------------------ 

        //program will start writing the courses in a file 
        STEMCourses stem = new STEMCourses();
        ArtCourses art = new ArtCourses();
        stem.write();
        art.write();

        //--------------------------database work------------------------ 
        Connection con = null;
        try {

            // (1) set the path for the database
            String ConnectionURL = "jdbc:mysql://localhost:3306";

            // (2) create connection
            con = DriverManager.getConnection(ConnectionURL, "root", "2751088");

            // (3) create statment object
            Statement st = con.createStatement();

            // (4) excute sql statment
            //_______________Creating the DB_______________
            st.executeUpdate("CREATE DATABASE " + "USERS");

            System.out.println("DB created succssfully ");

            // (5) close connection
            con.close();
        } catch (SQLException s) {
            System.out.println("SQL statement is not executed!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //_______________Creating the table_______________
        try {
            String ConnectionURL = "jdbc:mysql://localhost:3306/users";
            con = DriverManager.getConnection(ConnectionURL, "root", "2751088");
            Statement st = con.createStatement();

            //creating the table 
            String createTable = "CREATE TABLE UsersInfo("
                    + "Name VARCHAR(255), "
                    + "Passowrd VARCHAR(255), "
                    + "Courses VARCHAR(255)"
                    + ")";
            st.executeUpdate(createTable);
            System.out.println("table created succssfully ");
            con.close();
        } catch (SQLException s) {
            System.out.println("SQL statement is not executed!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //---------------------------Initiate GUI------------------------------
        //calling the frame to open 
        Frame1 f = new Frame1();
        f.show();

    }

    //--------------------------database work methods------------------------ 
    
    //method-1 for the database sign-up button option  
    public void usersDBSignUp(String username, String password) {
        // (1) set the path for the database
        String ConnectionURL = "jdbc:mysql://localhost:3306/users";
        String insertData = null;
        // (2) create connection
        Connection con = null;
        try {
            con = DriverManager.getConnection(ConnectionURL, "root", "2751088");
            //checking whether this user exists in the DB table 
            boolean isUsernameExists = checkUserExistence(con, username, password);
            if (isUsernameExists == true) {
                //window will be dispalyed that will conatain a message indicating
                //that this user exists already 
                JOptionPane.showMessageDialog(null, "This username already exist");
                //otherwise the else function will be executed to insert this username and password to our DB table
            } else {
                insertData = "INSERT INTO UsersInfo("
                        + "Name, Passowrd, Courses) VALUES "
                        + "(?,?,null)";
            }

            PreparedStatement preparedStatement = con.prepareStatement(insertData);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            //displaying a window message after inserting 
            JOptionPane.showMessageDialog(null, "signing up was done succssfully");

        } catch (SQLException ex) {
            Logger.getLogger(SignUpFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //to make sure that the conncetion of the DB is closed 
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //------------------------------------------------------------
    //method-2 for the database login button option  
    public void usersDBLogin(String username, String password) {

        // (1) set the path for the database
        String ConnectionURL = "jdbc:mysql://localhost:3306/users";
        
        // (2) create connection
        Connection con = null;
        try {
            con = DriverManager.getConnection(ConnectionURL, "root", "2751088");
            //checking whether this user exists in the DB table 
            boolean isUsernameExists = checkUserExistence(con, username,password);
            if (isUsernameExists == true) {
                AccountFrame name=new AccountFrame();
                LoginFrame lf=new LoginFrame();
                name.AccountName.setText("Hello "+username);
                name.show();
              //  lf.dispose(); //to close the window of the login 
                
                //otherwise the else function will be executed to insert this username and password to our DB table
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, but you don't have an account yet\n"
                        + "try signing up :)");

            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUpFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //method-3 to check whether a specfic username & password exists in out DB table or not 
    //method-3 returns true if the username exists 
    private boolean checkUserExistence(Connection con, String username, String password) {
    boolean userExists = false;

    try {
        String query = "SELECT * FROM UsersInfo WHERE Name=? AND Password=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // If the result set has any rows, the username and password combination exists
            userExists = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return userExists;
}


}
