package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.BolsasDTO;
import br.unitins.topicos1.service.BolsasService;
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
@Path("/admin/bolsas")
public class BolsasResource {
    
    @Inject
    private BolsasService bolsasService;

    @GET
    public Response findAll() {
        return Response.ok(bolsasService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(bolsasService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/marca/{marca}") 
    public  Response findByMarca(@PathParam("marca") String marca){
        return Response.ok(bolsasService.findByMarca(marca)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, BolsasDTO dto) {
        bolsasService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        bolsasService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST  
    @Transactional
    public Response create(BolsasDTO dto){
        return Response.status(Status.CREATED).entity(bolsasService.create(dto)).build();
    }
}
