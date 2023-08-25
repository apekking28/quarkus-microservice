package org.king.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://pokeapi.co/api/v2")
public interface RestDummy {
    @GET
    @Path("/pokemon/pikachu")
    String getPikachu();
}