package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.service.LenteService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
@Path("/admin/lentes")
public class LenteResource {
    
    @Inject
    public LenteService lentesService;

    @GET
    public Response findAll() {
        return Response.ok(lentesService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(lentesService.findAll()).build();
    }

    @GET
    @Path("/search/marca/{marca}") 
    public Response findByMarca(@PathParam("marca") String marca){
        return Response.ok(lentesService.findByMarca(marca)).build();
    }
    
    @POST  
    @Transactional
    public Response create(@Valid LentesDTO dto){
        return Response.status(Status.CREATED).entity(lentesService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, LentesDTO dto) {
        lentesService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
   }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        lentesService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}