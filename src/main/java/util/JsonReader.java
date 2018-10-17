package util;

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


    private static HashMap<String, JsonValue> storeMap;

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


    public static HashMap<String, JsonValue> getStoreMap() {
        return storeMap;
    }

    private HashMap<String, JsonValue> getChild(int startingIndex){
       HashMap<String, JsonValue> tempHashMap = new HashMap<String, JsonValue>();



        int indexLine = startingIndex;
       while(!lines.get(indexLine).equals("}"))
       {
//           System.out.println(lines.contains("{"));

            if(lines.get(indexLine).contains("{"))
            {
                JsonValue<HashMap<String,JsonValue>> passback;



                //Gets the next object within the jsonArray
                getChild(indexLine+1);
            }
            if (lines.get(indexLine).contains("\"")){
                //Is a property
                
                Pattern findPropertyIDPatern = Pattern.compile("([a-zA-Z]\\w+)");
                Pattern findValuePattern = Pattern.compile("(?<=\\:)( \\d+\\.\\d+)");

//                (?<=\:)( \d+\.\d+| \d+) - Currently finds numeric values
                // ([A-Za-z0-9]\w+)|(\d+.\d+)|(\d) -  Finds ever numeric and alphabetic values

                Matcher m = findPropertyIDPatern.matcher(lines.get(indexLine));

                if(m.find())
                {
//                    tempHashMap.put(m.group(), );
                }

                System.out.println((m.find() ? m.group() : ""));

                System.out.println(lines.get(indexLine));
            }
            //Else is the end of a object

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
