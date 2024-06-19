package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.CameraFileServiceImpl;
import br.unitins.topicos1.service.CameraService;
import br.unitins.topicos1.service.PessoaServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
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
@Path("/cameras")
public class CameraResource {

    public static final Logger LOG = Logger.getLogger(PessoaServiceImpl.class);

    @Inject
    public CameraService cameraService;

    @Inject
    public CameraFileServiceImpl fileService;

    @GET
    @RolesAllowed({"Cliente","Funcionario"})
    public Response findAll() {
        LOG.info("Iniciando busca de todas as câmeras");
        try {
            Response response = Response.ok(cameraService.findAll()).build();
            LOG.info("Busca de todas as câmeras concluída");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realizar requisição findAll()");
            return null;
        }
    }
    
    @GET
    @RolesAllowed({"Cliente", "Funcionario"})
    @Path("/search/marca/{marca}") 
    public Response findByMarca(@PathParam("marca") String marca){
        LOG.infof("Iniciando busca pela marca: %s", marca);
        try {
            Response response = Response.ok(cameraService.findByMarca(marca)).build();
            LOG.infof("Marca: %s",  marca, " encontrada");
            return response;
        } catch (Exception e) {
            LOG.errorf("Marca '%s", marca, "' não encontrada ou inexistente", e);
            return null;
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, CameraDTO dto) {
        LOG.infof("Iniciando update da câmera com id: %d", id);
        try {
            cameraService.update(id, dto);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.info("Requisição concluída");
            return response;

        } catch (Exception e) {
            LOG.error("Erro na requisição do update()", e);
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.warnf("Deletando câmera com ID: %d", id);
            cameraService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Câmera com id %d", id, " deletada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.errorf("Camêra com id %d", id, "não foi deletada ou não foi encontrada", e);
            return null;
        }
    }

    @POST  
    @RolesAllowed({"Funcionario"})
    public Response create(CameraDTO dto){
        LOG.info("Iniciando criação de câmera");
        try {
            Response response = Response.status(Status.CREATED).entity(cameraService.create(dto)).build();
            LOG.info("Criação realizada com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro de requisição create()", e);
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Realizando busca pelo ID: %d", id);
        try {
            Response response = Response.ok(cameraService.findById(id)).build(); 
            LOG.infof("Câmera com ID %d", id, " encontrado");
            return response;
        } catch (Exception e) {
            LOG.errorf("Câmera com id %d", id, " não encontrado", e);
            return null;
        }
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @RolesAllowed({"Funcionario"})
    public Response salvarImagem(@PathParam("id") Long id, @MultipartForm ImageForm form){
        LOG.info("Iniciando inserção de imagem");
        try {
            fileService.salvar(id, form.getNomeImagem(), form.getImagem());
            Response response = Response.noContent().build();
            LOG.info("Inserção concluída");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao realizar inserção", e);
            return null;
        }
    }

    @GET
    @Path("quarkus/imagem/camera/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed({"Funcionario"})
    public Response download(@PathParam("nomeImagem") String nomeImagem){
        LOG.info("Iniciando download");
        try {
            fileService.download(nomeImagem);
            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment; filename=" + nomeImagem);
            LOG.info("Download realizado com sucesso");
            LOG.info("Nome da imagem: " + nomeImagem);
            return response.build();
        } catch (Exception e) {
            LOG.error("Erro ao realizar download", e);
            return null;
        }
    }
}
