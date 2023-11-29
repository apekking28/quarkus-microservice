package org.king.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.king.proxy.RestDummy;

@Path("/v1/rest-client")
@Tag(name = "Rest Client Pokemon Controller", description = "Rest client controller")
public class RestClientPokemonController {

    @RestClient
    RestDummy restDummy;

    @GET
    @Path("/pokemon")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get All Pokemon", description = "Get All Pokemon Data's")
    public Response helloAuthService() {
        var response = restDummy.getPikachu();
        return Response.ok().entity(response).build();
    }
}