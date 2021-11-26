package uk.co.alexknight.processingme.util;

public class Logger {

    private String LogTag = "";
//    private static boolean E

    public Logger(String NewLogTAg)
    {
        LogTag = NewLogTAg;
    }


    public void LogError(String strToLOg)
    {
        System.out.println(String.format("[%s ERROR] %s",LogTag,strToLOg));
    }

    public void LogInformation(String strToLog)
    {
        System.out.println(String.format("[%s I] %s",LogTag,strToLog));
    }


}
