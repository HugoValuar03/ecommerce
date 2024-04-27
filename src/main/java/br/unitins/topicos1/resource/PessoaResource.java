package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.service.PessoaService;
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
@Path("/pessoas")
public class PessoaResource {
    
    @Inject
    private PessoaService pessoaService;

    //Teste Feito
    @GET
    public Response findAll() {
        return Response.ok(pessoaService.findAll()).build();
    }

    //Teste Feito
    @GET
    @Path("/search/nome/{nome}") 
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(pessoaService.findBynome(nome)).build();
    }

    //Teste Feito
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(pessoaService.findById(id)).build(); 
    }

    //Teste Feito
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PessoaDTO dto) {
        pessoaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    //Teste Feito
    @POST
    public Response create(@Valid PessoaDTO dto){
        return Response.status(Status.CREATED)
        .entity(pessoaService.create(dto)).build();
    }

    //Teste Feito
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pessoaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
