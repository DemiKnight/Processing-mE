package com.krypticalKnight.testApp;

import processing.core.PApplet;

import static com.krypticalKnight.testApp.TestApp.testAppLogger;

public class TestMain {

    private static TestApp app = new TestApp();



    public static void main(String[] args){
        System.out.println("Hello");

        app.setupApplication();

        testAppLogger.LogInformation("TestApp Started");
        PApplet.main("com.krypticalKnight.testApp.TestApp");

    }

}
