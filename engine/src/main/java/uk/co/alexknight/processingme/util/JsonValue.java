package uk.co.alexknight.processingme.util;

import java.lang.reflect.Array;

public class JsonValue<T> {

    enum valueType{
        bool,
        string,
        numInt,
        floatNum,
        jsonObject,
        array
    }

    private valueType propValue;

    private T property;

    JsonValue(T valueToStore){
        this.property = valueToStore;



        if(valueToStore instanceof Boolean)
        {
            propValue = valueType.bool;
        } if (valueToStore instanceof Integer)
        {
            propValue = valueType.numInt;
        } if (valueToStore instanceof Float)
        {
            propValue = valueType.floatNum;
        } if (valueToStore instanceof String)
        {
            propValue = valueType.string;
        } if (valueToStore instanceof Array)
        {
            propValue = valueType.array;
        } else {
            propValue = valueType.string;
        }
    }

    public T getProperty()
    {
        return property;
    }

    /** WIll find the
     *
     *
     * @return
     */
    public static int getValueType()
    {


        return 2;
    }

}
