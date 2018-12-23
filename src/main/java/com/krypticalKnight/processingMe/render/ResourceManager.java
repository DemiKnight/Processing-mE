package com.krypticalKnight.processingMe.render;


import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityManager;
import com.krypticalKnight.processingMe.util.UseableResource;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The object which will hold all visual data, preventing data redundancy and exceeding load times.
 * Currently supporting PImage & PShape.
 * @author Alex James Knight
 * @since 0.0.4
 * @see Entity
 * @see RenderManager
 */
public class ResourceManager
{
    private List<String> resourceLocations;

    private PShape[] shapeStore;
    private PImage[] imageStore;

    private UseableResource[] resourceDictionary;


    /**
     * The types currently supported, relating to the lists
     */


    /**
     *
     * @param entityManager
     */
    public void gatherResources(EntityManager entityManager)
    {
        resourceLocations = new LinkedList<>();

        for (Entity selectedEntity: entityManager.getEntities())
        {
            if(selectedEntity instanceof ResourceRequirements)
            {
                ((ResourceRequirements) selectedEntity).initResource();
                for (Map.Entry<String, String> selectedResourced: ((ResourceRequirements) selectedEntity).textureMapV.entrySet())
                {
                    //If the resource is already added, skip
                    if(!resourceLocations.contains(selectedResourced.getValue()))
                    resourceLocations.add(selectedResourced.getValue());
                }
            }
        }
    }

    /**
     *
     * @param application Used to get access to LoadImage.
     */
    public void loadResources(PApplet application)
    {
        LinkedList<PShape> tempShapeStore = new LinkedList<>();
        LinkedList<PImage> tempImageStore = new LinkedList<>();

        LinkedList<UseableResource> tempDictionary = new LinkedList<>();

        for(String resourceLocation : resourceLocations)
        {
            if (resourceLocation.endsWith(".png") || resourceLocation.endsWith(".jpg"))
            {
                //Add the object to the temp store.
                tempImageStore.add(application.loadImage(resourceLocation));
                //Get the last object added, which would be the previous item.
                tempDictionary.add(new UseableResource<>(tempImageStore.getLast(), resourceLocation));
            }
            else if (resourceLocation.endsWith(".svg"))
            {

                tempShapeStore.add(application.loadShape(resourceLocation));

                tempDictionary.add(new UseableResource<>(tempShapeStore.getLast(), resourceLocation));
            }
        }

        shapeStore = tempShapeStore.toArray(new PShape[0]);
        imageStore = tempImageStore.toArray(new PImage[0]);

        resourceDictionary = new UseableResource[tempDictionary.size()];

        for (int i = 0; i < resourceDictionary.length; i++)
        {
            resourceDictionary[i] = tempDictionary.get(i);
        }

//        resourceDictionary = tempTransfer.clone();

        resourceLocations = null; //Clear the memory
    }

    /**
     *
     * @param resourceID
     * @return Resource /w given ID. Or null if not found.
     */
    public PImage getResource(String resourceID)
    {
        for (UseableResource selectedResource: resourceDictionary)
        {
            if(selectedResource.getID().equals(resourceID)) return (PImage) selectedResource.getResoure();
        }

        MainApp.mainLogger.LogError("Unable to find resource: " + resourceID );

        return null;
    }

//
//    /**
//     * The List storing all the image data. Using the processing class PImage.
//     */
//    private static List<PImage> imageList = new LinkedList<>();;
//
//    /**
//     * The list storing all the shape data. Using the processing class PShape
//     */
//    private static List<PShape> shapeList = new LinkedList<>();
//
//    private static List<String> pathStage = new LinkedList<>();
//
//    /**
//     * Contains the ID for each image, generated using <tt>hashCode</tt>
//     * <ul>
//     *     <li>
//     *         <tt>String</tt> - Hash Code
//     *     </li>
//     *     <li>
//     *         <tt>Integer</tt> - The Index of the relating image within the List.
//     *     </li>
//     * </ul>
//     */
//    private HashMap<String, Integer> nameStore;
//
//    /**
//     *
//     */
//    public ResourceManager()
//    {
//        nameStore = new HashMap<>();
//    }
//
//    @Contract(pure = true)
//    public static PImage getPImageResource(int index)
//    {
//        return imageList.get(index);
//    }
//
//    @Contract(pure = true)
//    public static PShape getPShapeResource(int index)
//    {
//        return shapeList.get(index);
//    }
//
//    /**
//     * Used to add the resources required by each function.
//     * @param resourceRequired The entity with the <tt>registerResourcesPImage(List<PImage> pImageList)</tt> function.
//     */
//    public void addResource(ResourceRequirements resourceRequired)
//    {
//        int imageSize = imageList.size();
//        int shapeSize = shapeList.size();
//
//        resourceRequired.registerResources(this);
//
//        System.out.print(String.format("%d PImages & ", imageList.size()-imageSize));
//        System.out.println(String.format("%d PShapes added!", shapeList.size()-shapeSize));
//    }
//
//    /**
//     * Will add the given image, using <tt>loadImage()</tt>, to the list and make it available for use.
//     * @param resource The PImage to be stored.
//     */
//    public void addResource(PImage resource)
//    {
//        if (!nameStore.containsKey(String.valueOf(Arrays.hashCode(resource.pixels))))
//        {
//            imageList.add(resource);
//            nameStore.put(String.valueOf(Arrays.hashCode(resource.pixels)),imageList.size() - 1);
//        }
//    }
//
//    /**
//     * Add a given file to be loaded with the rest of the resources, is tested in case a duplicate exists.
//     * @param pathToStage Path to resources needed by a Entity
//     */
//    public static void stagePath(String pathToStage)
//    {
//        if (!pathStage.contains(pathToStage)) pathStage.add(pathToStage);
//    }
//
//    /**
//     * Will load a resource and place within the relevant list.
//     * @param pathToFile Path to resource to load
//     */
//    private static void loadResource(String pathToFile)
//    {
////        System.out.println(pathToFile.substring(pathToFile.indexOf('.')));
//        switch (pathToFile.substring(pathToFile.indexOf('.'))){
//
//            case ".png": case ".jpg": case ".gif":
//
//                imageList.add
//                        (
//                                MainApp.getInstance().loadImage(pathToFile)
//                        );
//
//                MainApp.mainLogger.LogInformation(String.format("Image: \"%s\" Index: %d",pathToFile,imageList.size()-1));
//
//                break;
//            case "svg":
////                System.out.println("Loading Shape");
//
//                shapeList.add
//                        (
//                                MainApp.getInstance().loadShape(pathToFile)
//                        );
//
//                MainApp.mainLogger.LogInformation(String.format("Shape: \"%s\" Index: %d",pathToFile,imageList.size()-1));
//
//                break;
//        }
//    }
//
//    /**
//     * Load all files found within the <tt>pathStage</tt> list.
//     */
//    public static void LoadResources()
//    {
//        for (String pathToLoad: pathStage)
//        {
//            loadResource(pathToLoad);
//        }
//
//        pathStage = null;
//    }
//
//    /**
//     * WIll add the shape, using <tt>loadShape()</tt>, to the list and make it available for use.
//     * @param resource The PShape to be stored.
//     */
//    public void addResource(PShape resource)
//    {
//        shapeList.add(resource);
//        if (nameStore.containsKey(String.valueOf(Arrays.hashCode(resource.getParams()))))
//        {
//            shapeList.add(resource);
//            nameStore.put(
//                    String.valueOf(Arrays.hashCode(resource.getParams())),
//                    shapeList.size() - 1
//            );
//        }
//    }
//
//    /**
//     * Will add the given image, using <tt>loadImage()</tt>, to the list and make it available for use.
//     * @param resource The PImage to be stored.
//     * @return The index of the resource just stored.
//     */
//    public int addResourceI(PImage resource)
//    {
//        if (!nameStore.containsKey(String.valueOf(Arrays.hashCode(resource.pixels))))
//        {
//            imageList.add(resource);
//            nameStore.put(String.valueOf(Arrays.hashCode(resource.pixels)),imageList.size() - 1);
//        }
//
//        return imageList.size() - 1;
//    }
//
//    /**
//     * WIll add the shape, using <tt>loadShape()</tt>, to the list and make it available for use.
//     * @param resource The PShape to be stored
//     * @return THe index of the resource just stored.
//     */
//    public int addResourceI(PShape resource)
//    {
//        if (nameStore.containsKey(String.valueOf(Arrays.hashCode(resource.getParams()))))
//        {
//            shapeList.add(resource);
//            nameStore.put(
//                    String.valueOf(Arrays.hashCode(resource.getParams())),
//                    shapeList.size() - 1
//            );
//        }
//        return shapeList.size() - 1;
//    }
//
//    /**
//     * Remove a resource from the Resource Manager, specifically from the image Store
//     * @param resourceToRemove The resource to remove from the imageList
//     */
//    public void removeResource(PImage resourceToRemove)
//    {
//        imageList.remove(resourceToRemove);
//    }
//
//    /**
//     * Remove a resource from the Resource Manager, specifically from the shape Store
//     * @param resourceToRemove The resource to remove from the shapeList
//     */
//    public void removeResource(PShape resourceToRemove)
//    {
//        shapeList.remove(resourceToRemove);
//    }
//
//    /**
//     * Remove a resource from the Resource Manager, using the index and a given type.
//     * @param index The index of the resource to remove.
//     * @param type The type of resource, indicating wether it is a PShape or PImage.
//     */
//    public void removeResource(int index, supportedTypes type)
//    {
//        switch (type)
//        {
//            case PImage:
//                imageList.remove(index);
//                break;
//            case PShape:
//                shapeList.remove(index);
//                 break;
//        }
//    }
}
