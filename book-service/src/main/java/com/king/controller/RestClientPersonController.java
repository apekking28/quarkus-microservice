package com.king.controller;

import com.king.dto.PersonRequest;
import com.king.proxy.RestClientPerson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/v1/rest-client")
@Tag(name = "Rest client person controller", description = "Rest client person controller")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestClientPersonController {

    @RestClient
    RestClientPerson restClient;


    @GET
    @Operation(summary = "Get all persons data from person-service", description = "Get all persons data from person-service")
    public Response getAllPersons() {
        try {
            var response = restClient.getPersons();
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get detail person data from person-service", description = "Get detail person data from person-service")
    public Response getPersonById(@PathParam("id") Long id) {
        try {
            var response = restClient.getPersonById(id);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

    @POST
    @Operation(summary = "Add person data to person-service", description = "Add person data to person-service")
    public Response addPerson(PersonRequest request) {
        try {
            var response = restClient.createPerson(request);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update person data to person-service",description = "Update person data to person-service")
    public Response updatePerson(@PathParam("id")Long id, PersonRequest request) {
        try {
            var response = restClient.updatePerson(id,request);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
