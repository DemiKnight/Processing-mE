package com.krytpicalKnight.processingMe.render;

import java.util.HashMap;

/**
 *
 */
public interface ResourceRequirements {

    /**
     *
     * @param resourceManager Instance of the resource manager
     */
    default void registerResources(ResourceManager resourceManager){}

    /**
     * Identifty the a specific texture relevant to the Entity
     */
    enum textures{};

    /**
     * The map that stores the link between a relvant texture for that entity and the entire entity cache in ResourceManager.
     */
    HashMap<ResourceRequirements.textures, Integer> textureMap = new HashMap<>();

}
