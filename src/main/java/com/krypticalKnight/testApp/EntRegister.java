package com.krypticalKnight.testApp;

import com.krypticalKnight.testApp.entities.TestEntity;
import com.krypticalKnight.processingMe.EntityManager;
import com.krypticalKnight.processingMe.EntityRegistry;

public class EntRegister implements EntityRegistry {

    private TestEntity test1 = new TestEntity();
    private TestEntity test2 = new TestEntity();

    @Override
    public void RegisterEntities(EntityManager manager) {
        manager.addToRegistry(test1);
        manager.addToRegistry(test2);

    }

//    @Override
//    public static void RegisterEntities(EntityManager manager) {
//
//        manager.addToRegistry(test1, true);
//        manager.addToRegistry(test2, true);
//    }
}
