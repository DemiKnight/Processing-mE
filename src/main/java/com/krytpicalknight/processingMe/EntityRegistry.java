package com.krytpicalknight.processingMe;

import processing.core.PApplet;

/**
 * When a game/application wants to register their Entities, implementing this will then allow the
 * Entity Manager to use the class.
 * @author Alex Knight
 */
public interface EntityRegistry {

    void RegisterEntities(EntityManager manager);


}
