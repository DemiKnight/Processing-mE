package com.krypticalKnight.testApp;

import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.util.Logger;
import processing.core.PApplet;

public class TestApp extends MainApp {

    public static Logger testAppLogger = new Logger("TestApp");

    public static void main(String[] args){
        System.out.println("Helo");


        testAppLogger.LogInformation("TestApp Started");
        PApplet.main("com.krypticalKnight.testApp.TestApp");

    }

    @Override
    public void preInit()
    {
        super.preInit();

        entityM.Registry(new EntRegister());
    }

    @Override
    public void init()
    {
        super.init();

    }

    @Override
    public void postInit()
    {
        super.postInit();
    }

}
