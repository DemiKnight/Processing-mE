package uk.co.alexknight.processingme;

import uk.co.alexknight.processingme.entities.Entity;

import java.util.LinkedList;

/**
 * When a game/application wants to register their Entities, implementing this will then allow the
 * Entity Manager to use the class.
 * @author Alex Knight
 */
public interface EntityRegistry {

    void RegisterEntities(LinkedList<Entity> listToModify);
}
