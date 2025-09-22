package org.example;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class to write data into a CSV file using the OpenCSV library.
 */
public class CsvWriter {

    /**
     * Writes a list of maps into a CSV file.
     * The keys of the first map are used as the CSV headers.
     *
     * @param filePath The full path where the CSV file will be created.
     * @param data The list of maps containing the data to write.
     * @throws IOException If there’s an error while writing the file.
     */
    public void writeCsvFile(String filePath, List<Map<String, Object>> data) throws IOException {
        if (data == null || data.isEmpty()) {
            System.out.println("No data available to write into the CSV file.");
            return;
        }

        // Extract the headers from the first row (map keys).
        Set<String> headersSet = data.get(0).keySet();
        String[] headers = headersSet.toArray(new String[0]);

        // Open the file with CSVWriter (it will automatically close after the try block).
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write the headers first.
            writer.writeNext(headers);

            // Write each row of data.
            for (Map<String, Object> row : data) {
                String[] values = new String[headers.length];
                for (int i = 0; i < headers.length; i++) {
                    Object value = row.get(headers[i]);
                    values[i] = (value != null) ? value.toString() : "";
                }
                writer.writeNext(values);
            }
            System.out.println("CSV file successfully written at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing the CSV file: " + e.getMessage());
            throw e;
        }
    }
}
