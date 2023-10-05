package com.example.repository;

import com.example.model.Pet;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class PetRepository {

    @Inject
    EntityManager entityManager;

    public List<Pet> findAll(){
        return entityManager.createQuery("SELECT p FROM Pet p", Pet.class).getResultList();
    }

    public Pet findById(Long id){
        return entityManager.find(Pet.class, id);
    }

    public Pet save(Pet pet){
        entityManager.persist(pet);
        return pet;
    }

    public Pet update(Pet pet){
        return entityManager.merge(pet);
    }

    public void delete(Pet pet){
        entityManager.remove(pet);
    }
}
