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
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class CourseManager {

    private String filePath;

    public CourseManager(String filePath) {
        this.filePath = filePath;
    }

    public void addCourse(String courseName, String courseDetails) {
        // Use BufferedWriter to write to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Construct the course entry
            String courseEntry = courseName + " - " + courseDetails + "\n";

            // Write the course entry to the file
            writer.write(courseEntry);

            System.out.println("Course added successfully: " + courseEntry);
        } catch (IOException e) {
            System.err.println("Error occurred while adding the course: " + e.getMessage());
        }
    }

    public void deleteCourse(String courseName) {
        // Read all lines from the file
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Filter out the line containing the course to be deleted
            List<String> updatedLines = lines.stream()
                    .filter(line -> !line.contains(courseName))
                    .collect(Collectors.toList());

            // Rewrite the file without the deleted course
            try (FileWriter writer = new FileWriter(filePath)) {
                for (String line : updatedLines) {
                    writer.write(line + System.lineSeparator());
                }
            }

            System.out.println("Course deleted successfully: " + courseName);
        } catch (IOException e) {
            System.err.println("Error occurred while deleting the course: " + e.getMessage());
        }
    }

}


