package com.krytpicalKnight.processingMe.util;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonReader {


    /**
     * Will store the file to be read.
     * @implNote May be removed in the future.
     */
    private File fileToRead;

    /**
     * Store the loaded config lines in here until it can be converted.
     * @implNote May be removed in the future.
     */
    private List<String> lines;


    private static HashMap<String, JsonValue> storeMap = new HashMap<String, JsonValue>();

    /**
     * This will read the file specified and store it within the class, converted.
     *
     * @param fileName Name of the file to be read
     */
    public JsonReader(String fileName)
    {
        lines = Collections.emptyList();

        try
        {
            URL url = JsonReader.class.getResource(fileName);

            //Read the loaded file
            lines = Files.readAllLines(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//        convertLines();

        storeMap = getChild(1);
    }


    public HashMap<String, JsonValue> getStoreMap() {
        return storeMap;
    }

    /**
     *
     *
     * @param startingIndex The line of the file file to start from.
     * @return {HashMap} The contents of the
     */
    private HashMap<String, JsonValue> getChild(int startingIndex){
       HashMap<String, JsonValue> tempHashMap = new HashMap<String, JsonValue>();

        Pattern findPropertyIDPatern = Pattern.compile("([A-Za-z0-9]\\w+)|(\\d+.\\d+)|(\\d)");

        int indexLine = startingIndex;

        while(!lines.get(indexLine).equals("}"))
       {

           //Uses the regex to find both the property ID and value. index 0 = ID, 1 = Value
           Matcher matcher = findPropertyIDPatern.matcher(lines.get(indexLine));

            //line is the beginning of a JSON object
            if(lines.get(indexLine).contains("{") && matcher.find())
            {
                HashMap<String, JsonValue> passback;

                //Gets the next object within the jsonArray
                passback = getChild(indexLine+1);

                JsonValue<HashMap> newJsonValue = new JsonValue(passback);

                storeMap.put(matcher.group(0), newJsonValue);
                System.out.println("Group Property: " + matcher.group(0));
            }

            //This is a normal JSON property
            if(matcher.find())
            {
                System.out.println("Group Property: " + matcher.group(0));


                JsonValue<Integer> newJsonValue = new JsonValue<Integer>(2);

                storeMap.put(matcher.group(0), newJsonValue);
            }

           indexLine++;
       }

       return tempHashMap;
    }

    /**
     * Convert all the lines in the {@link JsonReader#lines} to json format
     */
    private void convertLines(){

//        for (String line : lines)
        for (int index = 0;index < lines.size() ;index++)
        {
//            System.out.println(lines.get(index)); //Print entire config file, before
        }
    }

}
