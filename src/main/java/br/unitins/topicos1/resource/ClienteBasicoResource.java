package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.ClienteBasicoDTO;
import br.unitins.topicos1.service.ClienteBasicoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/clienteBasico")
public class ClienteBasicoResource {
    @Inject
    ClienteBasicoService clienteBasicoService;

    private static final Logger LOG = Logger.getLogger(ClienteBasicoResource.class);

    @POST
    public Response create(@Valid ClienteBasicoDTO clienteBasico){
        LOG.info("Executando requisição create");
        return Response.status(Response.Status.CREATED).entity(clienteBasicoService.create(clienteBasico)).build();
    }

    @GET
    public Response findAll() {
        LOG.info("Executando requisição findAll()");
        return Response.ok(clienteBasicoService.findAll()).build();
    }
}
