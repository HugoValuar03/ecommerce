package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.service.FornecedorService;
import jakarta.annotation.security.RolesAllowed;
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
@Path("/fornecedores")
public class FornecedorResource {
    
    @Inject
    public FornecedorService fornecedorService;

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        return Response.ok(fornecedorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}") 
    @RolesAllowed({"Funcionario"})
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(fornecedorService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/cnpj/{cnpj}") 
    @RolesAllowed({"Funcionario"})
    public Response findByCnpj(@PathParam("cnpj") String cnpj){
        return Response.ok(fornecedorService.findByCnpj(cnpj)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        return Response.ok(fornecedorService.findById(id)).build(); 
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, FornecedorDTO dto) {
        fornecedorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST  
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid FornecedorDTO dto){
        return Response.status(Status.CREATED)
        .entity(fornecedorService.create(dto)).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        fornecedorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
