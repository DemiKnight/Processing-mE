package uk.co.alexknight.processingme.exampleapp;

import uk.co.alexknight.processingme.Application;
import uk.co.alexknight.processingme.util.Logger;

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
