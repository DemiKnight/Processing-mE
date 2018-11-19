package com.krytpicalknight.processingMe.render;

import processing.core.PImage;
import processing.core.PShape;

import java.util.List;

public interface ResourceRequirements {

    default void registerResourcesPImage(List<PImage> pImageList) {}

    default void registerResourcesPShape(List<PShape> pShapeList){}
}
