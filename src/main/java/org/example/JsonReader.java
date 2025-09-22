package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * This class is used to read JSON files.
 * In simple words: we use the Gson library to open a file
 * and turn its content into something Java can understand.
 */
public class JsonReader {

    /**
     * Main function for reading a JSON file.
     * Basically, it opens the file and transforms
     * its content into a list that we can loop through in Java.
     *
     * @param filePath The path of the JSON file we want to read.
     * @return A list (List<Map<String, Object>>) with all the data from the JSON.
     * @throws IOException If the file doesn’t exist or can’t be read.
     */
    public List<Map<String, Object>> readJsonFile(String filePath) throws IOException {
        // We create a Gson object — this is the tool that does the magic.
        Gson gson = new Gson();

        // We tell Gson what we expect: a list of maps.
        // (A map is like a table of key → value pairs).
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();

        // try-with-resources: opens the file and makes sure it closes automatically at the end.
        try (FileReader reader = new FileReader(filePath)) {
            // Here’s the magic: Gson reads the file and turns it into the structure we asked for.
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            // If something goes wrong, we print the error and throw it again
            // so the program knows what happened.
            System.err.println("⚠️ Error reading the JSON file: " + e.getMessage());
            throw e;
        }
    }
}
