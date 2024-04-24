package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.service.CameraService;
import jakarta.inject.Inject;
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
@Path("/admin/camera")
public class CameraResource {

    @Inject
    public CameraService camerasService;

    @GET
    public Response findAll() {
        return Response.ok(camerasService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNomeProduto(@PathParam("nome") String nomeProduto){
        return Response.ok(camerasService.findByNomeProduto(nomeProduto)).build();
    }

    @GET
    @Path("/search/marca/{marca}") 
    public Response findByMarca(@PathParam("marca") String marca){
        return Response.ok(camerasService.findByMarca(marca)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CameraDTO dto) {
        camerasService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        camerasService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST  
    public Response create(CameraDTO dto){
        return Response.status(Status.CREATED).entity(camerasService.create(dto)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(camerasService.findById(id)).build(); 
    }
}
