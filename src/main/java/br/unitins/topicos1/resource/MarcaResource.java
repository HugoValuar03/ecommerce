package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
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
@Path("/marcas")
public class MarcaResource {
    
    @Inject
    private MarcaService marcaService;

    @GET
    public Response findAll() {
        return Response.ok(marcaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(marcaService.findByNome(nome)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(marcaService.findById(id)).build(); 
    } 

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MarcaDTO dto) {
        marcaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    public Response create(@Valid MarcaDTO dto){
        return Response.status(Status.CREATED)
        .entity(marcaService.create(dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        marcaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
