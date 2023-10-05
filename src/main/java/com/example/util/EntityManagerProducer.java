package com.example.util;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init(){
        if(entityManagerFactory == null) entityManagerFactory = Persistence.createEntityManagerFactory("default-pu");
    }

    // Creador
    @Produces
    @Default
    @Dependent
    public EntityManager createEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    // Destructor
    public void closeEntityManager(@Disposes EntityManager entityManager){
        if (entityManager.isOpen()) entityManager.close();
    }
}
