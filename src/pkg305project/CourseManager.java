/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305project;

/**
 *
 * @author Surface
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class CourseManager {

    //private String filePath;
    String username;
    String password;
    String CourseName;
    private Connection con;

//    public CourseManager(String filePath) {
//        this.filePath = filePath;
//    }
    //constructors
    public CourseManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CourseManager(String username, String password, String CourseName) {
        this.username = username;
        this.password = password;
        this.con = con;
    }

    public CourseManager(String username, String password, Connection con) {
        this.username = username;
        this.password = password;
        this.con = con;
    }

    //----------------method-1 for the Manager to add a course----------------
    public void AddCourseQuery() throws SQLException {
        //intiating the connection 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2751088");
        //update the course attribute in the UserInfo table from null to the required course
        String updateQuery = "UPDATE UserInfo SET course = ? WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, CourseName);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Course updated successfully for user: " + username);
            } else {
                System.out.println("User not found or password incorrect.");
            }
        }

    }
 //----------------method-2 for the Manager to delete a course----------------
    public void DeleteCourseQuery() throws SQLException {

        //intiating the connection 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2751088");
        // Delete the course for the specific user
         // Delete the specific course for the user
            String deleteQuery = "UPDATE UserInfo SET course = NULL WHERE username = ? AND password = ? AND course = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, CourseName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
               System.out.println("Course '" + CourseName + "' deleted successfully for user: " + username);
            } else {
                System.out.println("User not found or password incorrect.");
            }
        }

    }
}
