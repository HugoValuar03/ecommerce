package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.service.PedidoService;
import br.unitins.topicos1.service.PessoaServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pedidos")
public class PedidoResource {
    
    public static final Logger LOG = Logger.getLogger(PessoaServiceImpl.class);

    @Inject
    public PedidoService pedidoService;

    @POST
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response create(@Valid PedidoDTO dto){
        LOG.info("Iniciando cadastro de novo pedido");
        try {
            Response response = Response.status(Status.CREATED).entity(pedidoService.create(dto)).build();
            LOG.info("Pedido cadastrado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar novo pedido");
            return null;
        }
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        LOG.info("Iniciando busca de todos os pedidos");
        try {
            Response response = Response.ok(pedidoService.findAll()).build();
            LOG.info("Pedidos encontrados com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao buscar pedidos");
            return null;
        }
    }    

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario","Cliente"})
    public Response findById(@PathParam("id")Long id){
        LOG.infof("Iniciando busca pelo id: %d", id);
        try {
            Response response = Response.ok(pedidoService.findAll()).build();
            LOG.infof("Pedido encontrado com sucesso pelo id: %d", id);
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao encontrar o id: %d", id);
            return null;
        }
    }

    @DELETE
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response delete(@PathParam("id")Long id){
        LOG.warnf("Iniciando deletando pedido de id: %d", id);
        try {
            pedidoService.delete(id);
            Response response = Response.status(Status.NO_CONTENT).build();
            LOG.infof("Pedido deletado com sucesso pelo id: %d", id);
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao deletar pedido de id: %d", id);
            return null;
        }
    }

    @GET
    @Path("/search/cliente/{idCliente}")
    @RolesAllowed({"Funcionario"})
    public Response findByCliente(Long idCliente){
        LOG.infof("Buscando cliente pelo id: %d", idCliente);
        try {
            Response response = Response.ok(pedidoService.findByCliente(idCliente)).build();
            return response;
        } catch (Exception e) {
            LOG.errorf("Cliente de id %d", idCliente, " não encontrado");
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response mudarStatusPedido(@PathParam("id") long id, int idStatusPedido){
        LOG.info("Alterando status do pedido");
        try {
            Response response = pedidoService.mudarStatusPedido(id, idStatusPedido);
            LOG.info("Status alterado com sucesso");
            return response;
        } catch (Exception e) {
            LOG.error("Erro ao alterar status do pedido");
            return null;
        }
    }
}
