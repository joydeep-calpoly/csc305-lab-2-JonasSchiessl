package org.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

class JSONProcessor {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the JSON file name as a command-line argument.");
            return;
        }

        String fileName = "CSC305_Lab_2/src/" + args[0];  // Adjust based on your project structure

        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and map it to Dignitary record
            Dignitary dignitary = objectMapper.readValue(new File(fileName), Dignitary.class);

            // Display parsed data
            dignitary.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
