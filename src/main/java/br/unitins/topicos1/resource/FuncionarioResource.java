package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.service.FuncionarioService;
import br.unitins.topicos1.service.PessoaServiceImpl;
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
@Path("/funcionarios")
public class FuncionarioResource {

    public static final Logger LOG = Logger.getLogger(PessoaServiceImpl.class);

    @Inject 
    public FuncionarioService funcionarioService;

    @GET
    public Response findAll(){
        LOG.info("Iniciando busca de todos os funcionários");
        try {
            Response response = Response.ok(funcionarioService.findAll()).build();
            LOG.info("Busca realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realizar busca", e);
            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Iniciando busca pelo ID: %d", id);
        try {
            Response response = Response.ok(funcionarioService.findById(id)).build(); 
            LOG.infof("Funcionário com id %d", id, " com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar busca de id: %d", id, e);
            return null;
        }
    }

    @GET
    @Path("/search/cargo/{cargo}")
    public Response findByCargo(@PathParam("cargo") String cargo){
        LOG.infof("Iniciando busca pelo cargo: %s", cargo);
        try {
            Response response = Response.ok(funcionarioService.findByCargo(cargo)).build();
            LOG.info("Busca realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar busca pelo cargo: %s", cargo, e);
            return null;
        }
    }

    @POST
    public Response create(@Valid FuncionarioDTO dto){
        LOG.info("Iniciando cadastro de novo funcionário");
        try {
            Response response = Response.status(Status.CREATED)
            .entity(funcionarioService.create(dto)).build();
            LOG.info("Cadastro realizado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realizar cadastro", e);
            return null;
        }
        
    }

    @PUT 
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        LOG.infof("Iniciando atualização do funcionário com id: %d", id);
        try {
            funcionarioService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Atualização realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar atualização do funcionário com id: %d", id, e);
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.warnf("Iniciando exclusão do funcionário com id: %d", id);
        try {
            funcionarioService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Exclusão realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar exclusão do funcionário com id: %d", id, e);
            return null;
        }
    }
}
