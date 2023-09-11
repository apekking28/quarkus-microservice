package org.king.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.king.dto.PersonRequestDTO;
import org.king.entity.Person;
import org.king.service.PersonService;

import java.util.List;

@Path("/persons")
@Tag(name = "Person", description = "Person operations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {
    @Inject
    PersonService personService;

    @GET
    @Operation(summary = "Get all persons", description = "Retrieve a list of all persons")
    public List<Person> getAllPersons() {
        return personService.getAllPeople();
    }

    @POST
    @Operation(summary = "Add new person", description = "Create a new person")
    public Response createPerson(PersonRequestDTO personRequestDTO) {
        Person person = personService.createPerson(personRequestDTO);
        return Response.status(Response.Status.CREATED)
                .entity(person)
                .build();
    }


    @GET
    @Path("/{id}")
    @Operation(summary = "Get detail person", description = "Detail a person")
    public Person getPersonById(@PathParam("id") Long id) {
        return personService.getPersonById(id);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update person", description = "Update a person")
    public Person updatePerson(@PathParam("id") Long id, PersonRequestDTO request) {
        return personService.updatePerson(id, request);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete person by ID", description = "Delete a person by their ID")
    public Response deletePerson(@PathParam("id") Long id) {
        String message = personService.deletePersonById(id);
        return Response.ok(message).build();
    }

}
