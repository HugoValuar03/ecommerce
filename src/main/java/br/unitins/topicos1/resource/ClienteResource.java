package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.UpdateEmailDTO;
import br.unitins.topicos1.dto.UpdateNomeDTO;
import br.unitins.topicos1.dto.UpdateSenhaDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
import br.unitins.topicos1.service.ClienteService;
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
@Path("/cliente")
public class ClienteResource {

    public static final Logger LOG = Logger.getLogger(ClienteResource.class);
    
    @Inject
    public ClienteService clienteService;

    //Inserir update de senha, nome, email e username

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        LOG.info("Iniciando busca de todos os clientes");
        try {
            Response response = Response.ok(clienteService.findAll()).build();
            LOG.info("Busca concluída com sucesso");
            return response;
        } catch (Exception e) {
            LOG.info("Erro ao realizar requisição findAll()", e);
            return null;
        }
    }

    @GET
    @Path("/search/cpf/{cpf}") 
    @RolesAllowed({"Funcionario"})
    public Response findByCpf(@PathParam("cpf") String cpf){
        LOG.infof("Iniciando busca pelo CPF: ", cpf);
        try {
            Response response = Response.ok(clienteService.findByCpf(cpf)).build();
            LOG.infof("CPF '%s", cpf, "' encontrado");
            return response;
        } catch (Exception e) {
            LOG.error("CPF não encontrado ou não existente", e);
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Realizando pesquisa de cliente pelo id: ", id);
        try {
            Response response = Response.ok(clienteService.findById(id)).build();
            LOG.infof("Cliente %d", id, " encontrado");
            return  response;
        } catch (Exception e) {
            LOG.error("Cliente não encontrado ou inexistente", e);
            return null;
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        LOG.infof("Iniciando atualização dos dados do cliente: %d", id);
        try {
            clienteService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Atualização de dados concluída");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao atualizar ou cliente inexistente", e);
            return null;
        }
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid ClienteDTO dto){
        LOG.info("Iniciando cadastro de novo cliente");
        try {
            Response response = Response.status(Status.CREATED)
            .entity(clienteService.create(dto)).build();
            LOG.info("Cliente cadastrado com sucesso");
            return response; 
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar cliente", e);
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        LOG.warnf("Deletando cliente com id: %d", id);
        try {
            clienteService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Cliente deletado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao deletar cliente", e);
            return null;
        }
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/senha/{id}")
    @Transactional
    public ClienteResponseDTO updateSenha(@PathParam("id") Long id, UpdateSenhaDTO senha){
        return clienteService.updateSenha(id, senha);
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/email/{id}")
    @Transactional
    public ClienteResponseDTO updateEmail(@PathParam("id") Long id, UpdateEmailDTO email){
        LOG.info("Realizando upload do email");
        try {
            if (email == null) {
                LOG.error("É necessário digitar um email");
            }
            return clienteService.updateEmail(id, email);
        } catch (Exception e) {
            LOG.error("Erro ao alterar email");
            return null;
        }
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/username/{id}")
    @Transactional
    public ClienteResponseDTO updateUsername(@PathParam("id") Long id, UpdateUsernameDTO username){
        return clienteService.updateUsername(id, username);
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/nome/{id}")
    @Transactional
    public ClienteResponseDTO updateNome(@PathParam("id") Long id, UpdateNomeDTO nome){
        return clienteService.updateNome(id, nome);
    }
}
