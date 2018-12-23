package com.krypticalKnight.testApp;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.testApp.entities.TestEntity;
import com.krypticalKnight.processingMe.entities.EntityManager;
import com.krypticalKnight.processingMe.EntityRegistry;

import java.util.LinkedList;

public class EntRegister implements EntityRegistry {

    private TestEntity test1 = new TestEntity();
//    private TestEntity test2 = new TestEntity();

    @Override
    public void RegisterEntities(LinkedList<Entity> listToModify) {
        listToModify.add(test1);
//        listToModify.add(test2);
    }


//    @Override
//    public static void RegisterEntities(EntityManager manager) {
//
//        manager.addToRegistry(test1, true);
//        manager.addToRegistry(test2, true);
//    }
}
