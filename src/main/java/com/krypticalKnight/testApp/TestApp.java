package com.krypticalKnight.testApp;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.util.Logger;

public class TestApp extends Application {

    public static Logger testAppLogger = new Logger("TestApp");

    public void preInit()
    {
        entityM.Registry(new EntRegister());
        stageM.Registry(new StgRegistry());
        super.preInit();
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
