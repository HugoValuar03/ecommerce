package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.TelefoneService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/admin/telefone")
public class TelefoneResource {
    
    @Inject
    private TelefoneService telefoneService;

    @GET
    public Response findAll() {
        return Response.ok(telefoneService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(telefoneService.findById(id)).build(); 
    }

    @GET
    @Path("/search/{codigoArea}") 
    public Response findByNome(@PathParam("codigoArea") String codigoArea){
        return Response.ok(telefoneService.findByCodigoArea(codigoArea)).build();  
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TelefoneDTO dto) {
        telefoneService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    public Response create(@Valid TelefoneDTO dto){
        return Response.status(Status.CREATED)
        .entity(telefoneService.create(dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        telefoneService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
