package br.unitins.topicos1.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.LenteFIleServiceImpl;
import br.unitins.topicos1.service.LenteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
@Path("/lentes")
public class LenteResource {
    
    @Inject
    public LenteService lentesService;

    @Inject
    public LenteFIleServiceImpl fileService;

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        return Response.ok(lentesService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        return Response.ok(lentesService.findAll()).build();
    }

    @GET
    @Path("/search/montagem/{montagem}") 
    @RolesAllowed({"Funcionario"})
    public Response findByMontagem(@PathParam("montagem") String montagem){
        return Response.ok(lentesService.findByMontagem(montagem)).build();
    }

    @POST  
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid LentesDTO dto){
        return Response.status(Status.CREATED).entity(lentesService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, LentesDTO dto) {
        lentesService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
   }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        lentesService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@PathParam("id") Long id, @MultipartForm ImageForm form){
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("quarkus/imagem/lente/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed({"Funcionario"})
    public Response download(@PathParam("nomeImagem") String nomeImagem){
        fileService.download(nomeImagem);
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment; filename=" + nomeImagem);
        return response.build();
    }

}
