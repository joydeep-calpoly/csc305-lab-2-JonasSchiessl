package org.json;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class JSONProcessor {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the JSON file name as a command-line argument.");
            return;
        }

        String fileName = "CSC305_Lab_2/src/" + args[0];

        try {
            // Load JSON file
            InputStream inputStream = new FileInputStream(fileName);
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONObject root = new JSONObject(tokener);

            // Parse "awards"
            JSONArray awardsArray = root.getJSONArray("awards");
            List<Award> awards = new ArrayList<>();
            for (int i = 0; i < awardsArray.length(); i++) {
                JSONObject awardObj = awardsArray.getJSONObject(i);
                String awardName = awardObj.getString("name");
                int awardYear = awardObj.getInt("year");
                awards.add(new Award(awardName, awardYear));
            }

            // Parse "knownFor"
            JSONArray knownForArray = root.getJSONArray("knownFor");
            List<String> knownFor = new ArrayList<>();
            for (int i = 0; i < knownForArray.length(); i++) {
                knownFor.add(knownForArray.getString(i));
            }

            // Parse "name"
            String name = root.getString("name");

            // Create Dignitary instance and display
            Dignitary dignitary = new Dignitary(name, knownFor, awards);
            dignitary.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
