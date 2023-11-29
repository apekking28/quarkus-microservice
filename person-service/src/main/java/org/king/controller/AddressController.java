package org.king.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.king.dto.request.AddressRequestDTO;
import org.king.dto.response.AddressWithPersonsResponseDTO;
import org.king.entity.Address;
import org.king.service.AddressService;

import java.util.List;

@Path("/addresses")
@Tag(name = "Addresses", description = "Addresses operations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {

    @Inject
    AddressService addressService;

    @GET
    @Operation(summary = "Get all addresses with persons", description = "Retrieve a list of all Addresses")
    public Response getAllAddresses() {
        List<AddressWithPersonsResponseDTO> response = addressService.getAllAddress();
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get detail address", description = "Create a new address")
    public Response getAddressById(@PathParam("id") Long id) {
        AddressWithPersonsResponseDTO response = addressService.getAddressById(id);
        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @GET
    @Path("/get")
    @Operation(summary = "Get all address", description = "Get all address")
    public Response getAddress() {
        List<Address> response = addressService.getAddresses();
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }

    @POST
    @Operation(summary = "Add new addresses", description = "Create a new address")
    public Response createAddress(AddressRequestDTO requestDTO) {
        Address response = addressService.createAddress(requestDTO);
        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete address", description = "Delete address by id")
    public Response updateAddressById(@PathParam("id") Long id, AddressRequestDTO requestDTO) {
        Address response = addressService.updateAddressById(id, requestDTO);
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete address", description = "Delete address by id")
    public Response DeleteAddressById(@PathParam("id") Long id) {
        String response = addressService.deleteAddressById(id);
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }

}
