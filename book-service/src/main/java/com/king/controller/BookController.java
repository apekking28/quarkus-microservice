package com.king.controller;

import com.king.service.BookService;
import com.king.entity.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/books")
@Tag(name = "Book", description = "Book operations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookController {
    @Inject
    BookService bookService;

    @GET
    @Operation(summary = "Get all books", description = "Retrieve a list of all books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get book by ID", description = "Retrieve book details by its ID")
    public Book getBookById(@PathParam("id") Long id) {
        return bookService.getBookById(id);
    }

    @POST
    @Operation(summary = "Add a new book", description = "Add a new book to the system")
    public Response addBook(Book newBook) {
        Book addedBook = bookService.addBook(newBook);
        return Response.status(Response.Status.CREATED)
            .entity(addedBook)
            .build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update a book", description = "Update book details by its ID")
    public Response updateBook(@PathParam("id") Long id, Book updatedBook) {
        Book updated = bookService.updateBook(id, updatedBook);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete a book", description = "Delete a book by its ID")
    public Response deleteBook(@PathParam("id") Long id) {
         String message = bookService.deleteBook(id);
        return Response.ok(message).build();
    }
}
