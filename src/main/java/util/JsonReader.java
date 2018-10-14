package util;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class JsonReader {

    private File fileToRead;
    private List<String> lines;


    public JsonReader(String fileName)
    {
        lines = Collections.emptyList();

        try
        {
            URL url = JsonReader.class.getResource(fileName);

            lines = Files.readAllLines(Paths.get(url.toURI()), StandardCharsets.UTF_8);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void ReadLines(){

    }


}
