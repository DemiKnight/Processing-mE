package util;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
                

                System.out.println(lines.get(indexLine));
            }
            //ELse is the end of a object


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
