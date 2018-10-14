package util;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
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


    private HashMap<String, JsonValue> storecMap;

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


    }

    /**
     * Convert all the lines in the {@link JsonReader#lines} to json format
     */
    private void convertLines(){

    }


}
