package com.krypticalKnight.processingMe.util;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.Stage;
import processing.core.PImage;
import processing.core.PShape;

import java.util.LinkedList;

/**
 * TODO Remove this class and just extend all classes
 * @param <Type>
 */
public class UseableResource <Type>
{
    enum supportedTypes
    {
        Shape,
        Image,
        Stage,
        Entity
    }

    private final Type shapeResoure;
    private final supportedTypes typeStored;
    private final String ID;

    public UseableResource(final Type resourceToStore, final String newID)
    {
        this.shapeResoure = resourceToStore;

        if(resourceToStore instanceof PShape)
        {
            typeStored = supportedTypes.Image;
        } else
        if(resourceToStore instanceof PImage)
        {
            typeStored = supportedTypes.Shape;
        }else if(resourceToStore instanceof Entity)
        {
            typeStored = supportedTypes.Entity;
        } else if(resourceToStore instanceof Stage)
        {
            typeStored = supportedTypes.Stage;
        }else
        {
            System.out.println("RESOURCE NOT SUPPORTED?");
            typeStored = null;
        }

        this.ID = newID;
    }

    public Type getResoure()
    {
        return shapeResoure;
    }

    public supportedTypes getTypeStored()
    {
        return typeStored;
    }

    public String getID()
    {
        return ID;
    }

//    public static <T> void SetupDictionary(LinkedList<T> listToAddFrom, UseableResource<T>[] arrayToPopulate)
//    {
//        for (int index = 0; index < arrayToPopulate.length; index++) {
//            arrayToPopulate[index] = new UseableResource<T>(listToAddFrom.get(index), listToAddFrom.get(index).getID());
//        }
//
//    }

}
