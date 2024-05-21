package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.service.ClienteService;
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
@Path("/clientes")
public class ClienteResource {
    
    @Inject
    public ClienteService clienteService;

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    @Path("/search/cpf/{cpf}") 
    @RolesAllowed({"Funcionario"})
    public Response findByCpf(@PathParam("cpf") String cpf){
        return Response.ok(clienteService.findByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        return Response.ok(clienteService.findById(id)).build(); 
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        clienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid ClienteDTO dto){
        return Response.status(Status.CREATED)
        .entity(clienteService.create(dto)).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        clienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
