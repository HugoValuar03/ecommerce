package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.LenteDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.LenteFIleServiceImpl;
import br.unitins.topicos1.service.LenteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
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
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/lente")
public class LenteResource {
    
    public static final Logger LOG = Logger.getLogger(LenteResource.class);
    
    @Inject
    public LenteService lenteService;

    @Inject
    public LenteFIleServiceImpl fileService;

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        LOG.info("Iniciando busca por todas as lentes");
        try {
            Response response = Response.ok(lenteService.findAll()).build();
            LOG.info("Busca por todas as lentes realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar todas as lentes", e);
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Iniciando busca por lente pelo id: %d" + id);
        try {
            Response response = Response.ok(lenteService.findById(id)).build();
            LOG.info("Busca por lente pelo id realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Lente de id: %d" + id + " não existe ou não foi encontrado", e);
            return null;
        }
        
    }

    @GET
    @Path("/search/montagem/{montagem}") 
    @RolesAllowed({"Funcionario"})
    public Response findByMontagem(@PathParam("montagem") String montagem){
        LOG.info("Iniciando busca pelo tipo de montagem: %s" + montagem);

        try {
            Response response = Response.ok(lenteService.findByMontagem(montagem)).build();
            LOG.infof("Montagem %s", montagem ," encontrada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar montagem " + montagem, e);
            return null;
        }
    }

    @POST  
    @RolesAllowed({"Funcionario"})
    public Response create(@Valid LenteDTO dto){
        LOG.info("Iniciando cadastro de nova lente");
        try {
            Response response = Response.status(Status.CREATED).entity(lenteService.create(dto)).build();
            LOG.info("Lente cadastrada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar lente");
            return null;
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, LenteDTO dto) {
        LOG.info("Realizando update da lente com id: " + id);
        try {
            lenteService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Update realizado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realizar update", e);
            return null;
        }
   }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        LOG.warn("Deletando lente de id: " + id);
        try {
            lenteService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Lente deletada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao deletar lente", e);
            return null;
        }
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@PathParam("id") Long id, @MultipartForm ImageForm form){
        LOG.info("Realizando requisição para salvar imagem");
        try {
            fileService.salvar(id, form.getNomeImagem(), form.getImagem());
            LOG.info("Imagem salva com sucesso");
            Response response = Response.noContent().build();
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao salvar imagem", e);
            return null;
        }
    }

    @GET
    @Path("quarkus/imagem/lente/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed({"Funcionario"})
    public Response download(@PathParam("nomeImagem") String nomeImagem){
        LOG.info("Iniciando download de imagem");
        try {
            fileService.download(nomeImagem);
            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment; filename=" + nomeImagem);
            LOG.info("Imagem baixada com sucesso");
            return response.build();
        } catch (Exception e) {
            LOG.error("Erro ao baixar imagem", e);
            return null;
        }
    }

}
