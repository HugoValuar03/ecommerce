package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.PessoaUpdateEmailDTO;
import br.unitins.topicos1.dto.PessoaUpdateNomeDTO;
import br.unitins.topicos1.dto.PessoaUpdateSenhaDTO;
import br.unitins.topicos1.dto.PessoaUpdateUsernameDTO;
import br.unitins.topicos1.service.PessoaService;
import br.unitins.topicos1.service.PessoaServiceImpl;
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
@Path("/pessoas")
public class PessoaResource {
    
    public static final Logger LOG = Logger.getLogger(PessoaServiceImpl.class);

    @Inject
    private PessoaService pessoaService;

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        LOG.info("Buscando todas as pessoas");
        try {
            Response response = Response.ok(pessoaService.findAll()).build();
            LOG.info("Busca concluída");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar todas as pessoas", e);
            return null;
        }
    }

    @GET
    @Path("/search/nome/{nome}") 
    @RolesAllowed({"Funcionario"})
    public Response findByNome(@PathParam("nome") String nome){
        LOG.infof("Buscando pessoa pelo nome: %s", nome);
        try {
            Response response = Response.ok(pessoaService.findBynome(nome)).build();
            LOG.info("Busca concluída");
            return response;
        } catch (Exception e) {
            LOG.errorf("Pessoa com nome de: %s", nome, " não encontrado");
            return null;
        }
    }

    @GET
    @Path("/{id}")  
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Buscando pessoa pelo id: %s", id);
        try {
            Response response = Response.ok(pessoaService.findById(id)).build(); 
            LOG.info("Busca realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Pessoa com id: %d", id, " encontrado com sucesso");
            return null;
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, PessoaDTO dto) {
        LOG.info("Realizando update");
        try {
            pessoaService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Update realizado com sucesso");
            return response; 
        } catch (Exception e) {
            LOG.error("Erro ao realizar atualização");
            return null;
        }
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid PessoaDTO dto){
        LOG.info("Realizando cadastro");
        try {
            Response response = Response.status(Status.CREATED)
            .entity(pessoaService.create(dto)).build();
            LOG.info("Cadastro realizado");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realiar cadastro");
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        LOG.warnf("Deletando pessoa de id: %d", id);
        try {
            pessoaService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Deletado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao deletar pessoa");
            return null;
        }
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/senha/{id}")
    @Transactional
    public PessoaResponseDTO updateSenha(@PathParam("id") Long id, PessoaUpdateSenhaDTO senha){
        return pessoaService.updateSenha(id, senha);
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/email/{id}")
    @Transactional
    public PessoaResponseDTO updateEmail(@PathParam("id") Long id, PessoaUpdateEmailDTO email){
        LOG.info("Realizando upload do email");
        try {
            if (email == null) {
                LOG.error("É necessário digitar um email");
            }
            return pessoaService.updateEmail(id, email);
        } catch (Exception e) {
            LOG.error("Erro ao alterar email");
            return null;
        }
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/login/{id}")
    @Transactional
    public PessoaResponseDTO updateUsername(@PathParam("id") Long id, PessoaUpdateUsernameDTO username){
        return pessoaService.updateUsername(id, username);
    }

    @PATCH
    @RolesAllowed({"Funcionario"})
    @Path("/nome/{id}")
    @Transactional
    public PessoaResponseDTO updateNome(@PathParam("id") Long id, PessoaUpdateNomeDTO nome){
        return pessoaService.updateNome(id, nome);
    }
}
