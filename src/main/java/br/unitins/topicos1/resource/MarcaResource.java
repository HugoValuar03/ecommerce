package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
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
@Path("/marca")
public class MarcaResource {
    
    public static final Logger LOG = Logger.getLogger(MarcaResource.class);

    @Inject
    private MarcaService marcaService;

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        LOG.info("Buscando todas as marcas");
        try {
            Response response = Response.ok(marcaService.findAll()).build();
            LOG.info("Requisição concluída com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar marcas", e);
            return null;
        }
    }

    @GET
    @Path("/search/marca/{marca}") 
    @RolesAllowed({"Funcionario"})
    public Response findByMarca(@PathParam("marca") String marca){
        LOG.infof("Realizando busca pela marca: %s", marca);
        try {
            Response response = Response.ok(marcaService.findByMarca(marca)).build();
            LOG.info("Requisição concluída com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar marca", e);
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Buscando marca pelo id: %d", id);    
        try {
            Response response = Response.ok(marcaService.findById(id)).build();  
            LOG.info("Requisição concluída com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar marca", e);
            return null;
        }
    } 

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, MarcaDTO dto) {
        LOG.infof("Realiazando update da marca de id: %d", id);
        try {
            marcaService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Update realizado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realizar update");
            return null;
        }
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid MarcaDTO dto){
        LOG.info("Cadastrando nova marca");
        try {
            Response response = Response.status(Status.CREATED)
            .entity(marcaService.create(dto)).build();
            LOG.info("Marca cadastrada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar nova marca");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        LOG.warnf("Excluindo marca de id: %d", id);
        try {
            marcaService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Marca excluída com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao excluir marca");
            return null;
        }
    }
}
