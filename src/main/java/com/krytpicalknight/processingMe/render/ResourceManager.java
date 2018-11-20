package com.krytpicalknight.processingMe.render;

import org.jetbrains.annotations.Contract;
import processing.core.PImage;
import processing.core.PShape;

import java.util.Arrays;
import java.util.HashMap;
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
    private static List<PImage> imageList = new LinkedList<>();;

    /**
     * The list storing all the shape data. Using the processing class PShape
     */
    private static List<PShape> shapeList = new LinkedList<>();

    /**
     * Contains the ID for each image, generated using <tt>hashCode</tt>
     * <ul>
     *     <li>
     *         <tt>String</tt> - Hash Code
     *     </li>
     *     <li>
     *         <tt>Integer</tt> - The Index of the relating image within the List.
     *     </li>
     * </ul>
     */
    private HashMap<String, Integer> nameStore;

    /**
     *
     */
    public ResourceManager()
    {
        nameStore = new HashMap<>();
    }

    @Contract(pure = true)
    public static PImage getPImageResource(int index)
    {
        return imageList.get(index);
    }

    @Contract(pure = true)
    public static PShape getPShapeResource(int index)
    {
        return shapeList.get(index);
    }

    /**
     * Used to add the resources required by each function.
     * @param resourceRequired The entity with the <tt>registerResourcesPImage(List<PImage> pImageList)</tt> function.
     */
    public void addResource(ResourceRequirements resourceRequired)
    {
        int imageSize = imageList.size();
        int shapeSize = shapeList.size();

        resourceRequired.registerResources(this);

        System.out.print(String.format("%d PImages & ", imageList.size()-imageSize));
        System.out.println(String.format("%d PShapes added!", shapeList.size()-shapeSize));
    }

    /**
     * Will add the given image, using <tt>loadImage()</tt>, to the list and make it available for use.
     * @param resource The PImage to be stored.
     */
    public static void addResource(PImage resource)
    {
        imageList.add(resource);
    }

    /**
     * WIll add the shape, using <tt>loadShape()</tt>, to the list and make it available for use.
     * @param resource The PShape to be stored.
     */
    public void addResource(PShape resource)
    {
        shapeList.add(resource);
    }

    /**
     * Will add the given image, using <tt>loadImage()</tt>, to the list and make it available for use.
     * @param resource The PImage to be stored.
     * @return The index of the resource just stored.
     */
    public int addResourceI(PImage resource)
    {
        if (!nameStore.containsKey(String.valueOf(Arrays.hashCode(resource.pixels))))
        {
            imageList.add(resource);
            nameStore.put(String.valueOf(Arrays.hashCode(resource.pixels)),imageList.size() - 1);
        }

        return imageList.size() - 1;
    }
    
    /**
     * WIll add the shape, using <tt>loadShape()</tt>, to the list and make it available for use.
     * @param resource The PShape to be stored
     * @return THe index of the resource just stored.
     */
    public int addResourceI(PShape resource)
    {
        if (!shapeList.contains(resource)) shapeList.add(resource);

        return imageList.size() - 1;
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
