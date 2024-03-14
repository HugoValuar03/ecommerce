package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.AcessoriosDTO;
import br.unitins.topicos1.service.AcessoriosService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
@Path("/admin/acessorios")
public class AcessoriosResource {
    @Inject
    private AcessoriosService acessoriosService;

    @GET
    public Response findAll() {
        return Response.ok(acessoriosService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(acessoriosService.findByNome(nome)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AcessoriosDTO dto) {
        acessoriosService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        acessoriosService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST  
    @Transactional
    public Response create(AcessoriosDTO dto){
        return Response.status(Status.CREATED).entity(acessoriosService.create(dto)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(acessoriosService.findById(id)).build(); 
    }
    
}
