package br.unitins.topicos1.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.CameraFileServiceImpl;
import br.unitins.topicos1.service.CameraService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cameras")
public class CameraResource {

    @Inject
    public CameraService camerasService;

    @Inject
    public CameraFileServiceImpl fileService;

    @GET
    @RolesAllowed({"Cliente","Funcionario"})
    public Response findAll() {
        return Response.ok(camerasService.findAll()).build();
    }

    @GET
    @RolesAllowed({"Cliente", "Funcionario"})
    @Path("/search/marca/{marca}") 
    public Response findByMarca(@PathParam("marca") String marca){
        return Response.ok(camerasService.findByMarca(marca)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, CameraDTO dto) {
        camerasService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        camerasService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST  
    @RolesAllowed({"Funcionario"})
    public Response create(CameraDTO dto){
        return Response.status(Status.CREATED).entity(camerasService.create(dto)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response buscarPeloId(@PathParam("id")Long id){
        return Response.ok(camerasService.findById(id)).build(); 
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@PathParam("id") Long id, @MultipartForm ImageForm form){
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("quarkus/imagem/camera/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed({"Funcionario"})
    public Response download(@PathParam("nomeImagem") String nomeImagem){
        fileService.download(nomeImagem);
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment; filename=" + nomeImagem);
        return response.build();
    }
}
