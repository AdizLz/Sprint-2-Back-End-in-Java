package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Main program class.
 * Responsible for coordinating the reading of a JSON file
 * and the writing of a CSV file.
 */
public class Main {
    /**
     * This is the starting point of the program.
     * 1. The path to the input JSON file.
     * 2. The path to the output CSV file.
     */
    public static void main(String[] args) {

    // Here we changed the code from the previous Sprint.
    // Sprint 3 called for the program to be more flexible
    // and for file names to be passed as arguments.
    // With this "if" statement, the program verifies that the user has given
    // the two arguments required for it to run.

        if (args.length < 2) {
            System.err.println("Uso: java -jar TuPrograma.jar <ruta-json-entrada> <ruta-csv-salida>");
            System.exit(1);
        }

    // The arguments are assigned to the variables.
    // Now the program can use any filename you pass to it.

        String jsonFilePath = args[0];
        String csvFilePath = args[1];

        JsonReader jsonReader = new JsonReader();
        CsvWriter csvWriter = new CsvWriter();

        try {
            // 1. Read the JSON file and load its data.
            List<Map<String, Object>> jsonData = jsonReader.readJsonFile(jsonFilePath);

            // 2. Write the read data to a CSV file.
            csvWriter.writeCsvFile(csvFilePath, jsonData);

            System.out.println("Process completed");

        } catch (IOException e) {

            System.err.println("An error occurred while executing the program: " + e.getMessage());
        }
    }
}