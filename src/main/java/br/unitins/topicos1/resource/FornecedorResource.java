package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

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
@Path("/fornecedor")
public class FornecedorResource {
    
    public static final Logger LOG = Logger.getLogger(FornecedorResource.class);

    @Inject
    public FornecedorService fornecedorService;

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll() {
        LOG.info("Iniciando busca de todos os fornecedores");
        try {
            Response response = Response.ok(fornecedorService.findAll()).build();
            LOG.info("Busca concluída com sucesso!");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao encontrar fornecedores", e);
            return null;
        }
    }

    @GET
    @Path("/search/nome/{nome}") 
    @RolesAllowed({"Funcionario"})
    public Response findByNome(@PathParam("nome") String nome){
        LOG.infof("Procurando fornecedor com o nome: %s", nome);
        try {
            Response response = Response.ok(fornecedorService.findByNome(nome)).build(); 
            LOG.info("Fornecedor encontrado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao localizar o fornecedor: " , nome, e);
            return null;
        }
    }

    @GET
    @Path("/search/cnpj/{cnpj}") 
    @RolesAllowed({"Funcionario"})
    public Response findByCnpj(@PathParam("cnpj") String cnpj){
        LOG.infof("Iniciando busca pelo CNPJ : %s", cnpj);
        try {
            Response response = Response.ok(fornecedorService.findByCnpj(cnpj)).build();
            LOG.info("CNPJ encontrado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao localizar o CNPJ", e);
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Buscando fornecedor de id: %d", id);
        try {
            Response response = Response.ok(fornecedorService.findById(id)).build();
            LOG.infof("Fornecedor de id %d", id," encontrado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao localizar o fornecedor de id: %d", id, e);
            return null;
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, FornecedorDTO dto) {
        LOG.infof("Realiando update do fornecedor %d", id);
        try {
            fornecedorService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Fornecedor atualizado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Fornecedor não encontrado", e);
            return null;
        }
    }

    @POST  
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid FornecedorDTO dto){
        LOG.info("Inserindo novo fonecedor");
        
        try {
            Response response = Response.status(Status.CREATED)
            .entity(fornecedorService.create(dto)).build();
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao criar novo fornecedor", e);
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        LOG.warnf("Deletando fornecedor de id: %d", id);
        try {
            fornecedorService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Fornecedor deletado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao deletar fornecedor", e);
            return null;
        }
    }

}
