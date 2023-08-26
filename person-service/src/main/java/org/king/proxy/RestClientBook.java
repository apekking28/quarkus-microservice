package org.king.proxy;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.king.dto.BookRequest;

@RegisterRestClient(baseUri = "http://localhost:9090")
@Produces(MediaType.APPLICATION_JSON)
public interface RestClientBook {

    @GET
    @Path("/books")
    String getAllBooks();

    @GET
    @Path("/books/{id}")
    String getBookById(Long id);

    @POST
    @Path("/books")
    String addBook(BookRequest request);

    @PUT
    @Path("/books/{id}")
    String updateBook(Long id, BookRequest request);
}
