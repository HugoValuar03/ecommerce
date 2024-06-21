package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.UpdateEmailDTO;
import br.unitins.topicos1.dto.UpdateNomeDTO;
import br.unitins.topicos1.dto.UpdateSenhaDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
import br.unitins.topicos1.service.FuncionarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON) 
@Path("/funcionario")
public class FuncionarioResource {

    public static final Logger LOG = Logger.getLogger(FuncionarioResource.class);

    @Inject 
    public FuncionarioService funcionarioService;

    @GET
    @RolesAllowed({"Funcionario"})
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
    @RolesAllowed({"Funcionario"})
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
    @RolesAllowed({"Funcionario"})
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
    @RolesAllowed({"Funcionario"})
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
    @RolesAllowed({"Funcionario"})
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
    @RolesAllowed({"Funcionario"})
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

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/senha/{id}")
    @Transactional
    public FuncionarioResponseDTO updateSenha(@PathParam("id") Long id, UpdateSenhaDTO senha){
        return funcionarioService.updateSenha(id, senha);
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/email/{id}")
    @Transactional
    public FuncionarioResponseDTO updateEmail(@PathParam("id") Long id, UpdateEmailDTO email){
        LOG.info("Realizando upload do email");
        try {
            if (email == null) {
                LOG.error("É necessário digitar um email");
            }
            return funcionarioService.updateEmail(id, email);
        } catch (Exception e) {
            LOG.error("Erro ao alterar email");
            return null;
        }
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/username/{id}")
    @Transactional
    public FuncionarioResponseDTO updateUsername(@PathParam("id") Long id, UpdateUsernameDTO username){
        return funcionarioService.updateUsername(id, username);
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/nome/{id}")
    @Transactional
    public FuncionarioResponseDTO updateNome(@PathParam("id") Long id, UpdateNomeDTO nome){
        return funcionarioService.updateNome(id, nome);
    }
}
