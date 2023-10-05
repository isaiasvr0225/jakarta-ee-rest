package com.example.controller;

import com.example.model.Pet;
import com.example.repository.PetRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/pets")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class PetController {

    PetRepository petRepository;

    @Inject
    public PetController(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @GET
    public List<Pet> listAll(){
        return petRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Pet findById(@PathParam("id") Long id){
        return petRepository.findById(id);
    }

    @POST
    public Response save(Pet pet){
        petRepository.save(pet);

        return Response
                .created(URI.create("/pets/" + pet.getId()))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateById(@PathParam("id") Long id, Pet pet){
        petRepository.update(pet);

        return Response
                .ok(pet)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id){
        Pet pet = petRepository.findById(id);

        if(pet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            petRepository.delete(pet);
            return Response.ok("Entidad eliminada:" + pet).build();
        }

    }


}
