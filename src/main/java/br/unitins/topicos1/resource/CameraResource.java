package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CamerasDTO;
import br.unitins.topicos1.service.CamerasService;
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
@Path("/admin/cameras")
public class CameraResource {

    @Inject
    public CamerasService camerasService;

    @GET
    public Response findAll() {
        return Response.ok(camerasService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(camerasService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/cargo/{marca}") 
    public Response findByCargo(@PathParam("marca") String marca){
        return Response.ok(camerasService.findByMarca(marca)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CamerasDTO dto) {
        camerasService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        
    }

    @POST  
    public Response createCameras(@Valid CamerasDTO dto){
        return Response.status(Status.CREATED).entity(camerasService.create(dto)).build();
    }
}
