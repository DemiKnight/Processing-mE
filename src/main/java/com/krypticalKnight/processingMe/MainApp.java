package com.krypticalKnight.processingMe;

import com.krypticalKnight.processingMe.util.Logger;
import processing.core.PApplet;

import java.math.BigInteger;

public class MainApp
{
    private static String version = "0.1.0";

    public static Logger mainLogger = new Logger("Processing-Me");

    private static Application app = new Application();

    public static void main(String[] args)
    {
        mainLogger.LogInformation("Processing-Me Started! Made By Alex Knight");

        app.setupApplication();

        PApplet.main("com.krypticalKnight.processingMe.Application");
    }
}
