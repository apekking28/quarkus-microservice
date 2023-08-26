package org.king.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.king.dto.BookRequest;
import org.king.proxy.RestClientBook;

@Path("/v1/rest-client/books")
@Tag(name = "Rest Client Book Controller", description = "Rest book controller")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestClientBookController {

    @RestClient
    RestClientBook restClientBook;

    @GET
    @Operation(summary = "Get All Books", description = "Get all books Data's")
    public Response getAllBooks() {
        try {
            var response = restClientBook.getAllBooks();
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Detail Book", description = "Detail book from book service")
    public Response getAllBooks(@PathParam("id")Long id) {
        try {
            var response = restClientBook.getBookById(id);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Operation(summary = "Add Book", description = "Add new book to book service")
    public Response addBook(BookRequest request) {
        try {
            var response = restClientBook.addBook(request);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update Book", description = "Update a book to book-service")
    public Response updateBook(@PathParam("id")Long id,BookRequest request) {
        try {
            var response = restClientBook.updateBook(id,request);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

}
