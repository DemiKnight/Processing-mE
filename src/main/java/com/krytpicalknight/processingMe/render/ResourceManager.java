package com.krytpicalknight.processingMe.render;

import processing.core.PImage;
import processing.core.PShape;

import java.util.LinkedList;
import java.util.List;

/**
 * The object which will hold all visual data, preventing data redundancy and exceeding load times.
 * Currently supporting PImage & PShape.
 * @author Alex James Knight
 * @since 0.0.4
 * @see Entity
 * @see RenderManager
 */
public class ResourceManager {

    /**
     * The types currently supported, relating to the lists
     */
    enum supportedTypes{
        PShape,
        PImage
    }

    /**
     * The List storing all the image data. Using the processing class PImage.
     */
    private List<PImage> imageList;

    /**
     * The list storing all the shape data. Using the processing class PShape
     */
    private List<PShape> shapeList;

    private List<String> pathStore;

    /**
     *
     */
    public ResourceManager()
    {

        this.shapeList = new LinkedList<>();
        this.imageList = new LinkedList<>();
    }

    public PImage getPImageResource(int index)
    {
        return imageList.get(index);
    }

    public PShape getPShapeResource(int index)
    {
        return shapeList.get(index);
    }

    /**
     * Used to add the resources required by each function.
     * @param resourceRequired The entity with the <tt>registerResourcesPImage(List<PImage> pImageList)</tt> function.
     */
    public void addResource(ResourceRequirements resourceRequired)
    {
        int imageSize = this.imageList.size();
        int shapeSize = this.shapeList.size();

        resourceRequired.registerResourcesPImage(this.imageList);
        resourceRequired.registerResourcesPShape(this.shapeList);
        resourceRequired.registerResources(this);

        System.out.print(String.format("%d PImages & ", this.imageList.size()-imageSize));
        System.out.println(String.format("%d PShapes added!", this.shapeList.size()-shapeSize));
    }

    /**
     * Will add the given image, using <tt>loadImage()</tt>, to the list and make it available for use.
     * @param resource The PImage to be stored.
     */
    public void addResource(PImage resource)
    {
        this.imageList.add(resource);
    }

    /**
     * WIll add the shape, using <tt>loadShape()</tt>, to the list and make it available for use.
     * @param resource The PShape to be stored.
     */
    public void addResource(PShape resource)
    {
        this.shapeList.add(resource);
    }

    /**
     * Will add the given image, using <tt>loadImage()</tt>, to the list and make it available for use.
     * @param resource The PImage to be stored.
     * @return The index of the resource just stored.
     */
    public int addResourceI(PImage resource)
    {
        if (!imageList.contains(resource)) this.imageList.add(resource);

        return this.imageList.size() - 1;
    }

    /**
     * WIll add the shape, using <tt>loadShape()</tt>, to the list and make it available for use.
     * @param resource The PShape to be stored
     * @return THe index of the resource just stored.
     */
    public int addResourceI(PShape resource)
    {
        if (!shapeList.contains(resource)) this.shapeList.add(resource);

        return this.imageList.size() - 1;
    }

    /**
     * Remove a resource from the Resource Manager, specifically from the image Store
     * @param resourceToRemove The resource to remove from the imageList
     */
    public void removeResource(PImage resourceToRemove)
    {
        imageList.remove(resourceToRemove);
    }

    /**
     * Remove a resource from the Resource Manager, specifically from the shape Store
     * @param resourceToRemove The resource to remove from the shapeList
     */
    public void removeResource(PShape resourceToRemove)
    {
        shapeList.remove(resourceToRemove);
    }

    /**
     * Remove a resource from the Resource Manager, using the index and a given type.
     * @param index The index of the resource to remove.
     * @param type The type of resource, indicating wether it is a PShape or PImage.
     */
    public void removeResource(int index, supportedTypes type)
    {
        switch (type)
        {
            case PImage:
                imageList.remove(index);
                break;
            case PShape:
                shapeList.remove(index);
                 break;
        }
    }
}