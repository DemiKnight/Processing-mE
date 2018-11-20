package com.krytpicalknight.processingMe.render;

import processing.core.PImage;
import processing.core.PShape;

import java.util.List;

public interface ResourceRequirements {

    /**
     * @deprecated
     * @param pImageList
     */
    default void registerResourcesPImage(List<PImage> pImageList) {}

    /**
     * @deprecated
     * @param pShapeList
     */
    default void registerResourcesPShape(List<PShape> pShapeList){}

    /**
     *
     * @param resourceManager Instance of the resource manager
     */
    default void registerResources(ResourceManager resourceManager){}


}
