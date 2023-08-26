package com.king.proxy;

import com.king.dto.PersonRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080")
@Produces(MediaType.APPLICATION_JSON)
public interface RestClientPerson {

    @GET
    @Path("/persons")
    String getPersons();


    @GET
    @Path("/persons/{id}")
    String getPersonById(Long id);

    @POST
    @Path("/persons")
    String createPerson(PersonRequest request);

    @PUT
    @Path("/persons/{id}")
    String updatePerson(Long id, PersonRequest request);

}
