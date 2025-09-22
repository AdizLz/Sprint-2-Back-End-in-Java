package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Make sure this JSON file exists in the root of your project
        String jsonFilePath = "data.json";
        String csvFilePath = "output.csv";

        JsonReader jsonReader = new JsonReader();
        CsvWriter csvWriter = new CsvWriter();

        try {
            // 1. Read the JSON file and load its data into a list
            List<Map<String, Object>> jsonData = jsonReader.readJsonFile(jsonFilePath);

            // 2. Write the data we just read into a CSV file
            csvWriter.writeCsvFile(csvFilePath, jsonData);

            System.out.println("Process completed successfully!");

        } catch (IOException e) {
            // Catch and handle any errors that may happen along the way
            System.err.println("An error occurred while running the program: " + e.getMessage());
        }
    }
}
