package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.service.PedidoService;
import br.unitins.topicos1.validation.ValidationException;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pedido")
public class PedidoResource {
    
    public static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @Inject
    public PedidoService pedidoService;
    
    @Inject
    SecurityIdentity securityIdentity;

    @POST
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response create(@Valid PedidoDTO dto){
        LOG.info("Executando o método create de pedido ");
        String username = securityIdentity.getPrincipal().getName();

        if(!pedidoService.clienteEstaAutenticado(username, dto.idCliente())){
            throw new ValidationException("Verificando...", "Você não tem permissão para realizar o pedido.");
        }

        return Response.status(Status.CREATED).entity(pedidoService.create(dto)).build();
    }
        
    @GET
    @RolesAllowed({"Funcionario"})
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
            Response response = Response.ok(pedidoService.findById(id)).build();
            LOG.infof("Pedido encontrado com sucesso pelo id: %d", id);
            return response;
        } catch (Exception e) {
            LOG.errorf("Erro ao encontrar o id: %d", id);
            return null;
        }
    }

    @GET
    @Path("/search/cliente/{id_cliente}")
    @RolesAllowed({"Funcionario"})
    public Response findByCliente(@PathParam("id_cliente") Long idCliente){
        LOG.infof("Buscando cliente pelo id");
        try {
            return Response.ok(pedidoService.findByCliente(idCliente)).build();
        } catch (Exception e) {
            LOG.errorf("Cliente não encontrado");
            return null;
        }
    }

    @PATCH
    @Path("/alterarStatusPedido/{id}")
    @RolesAllowed({"Cliente"})
    public Response mudarStatusPedido(@PathParam("id") Long id){
        LOG.info("Executando o método mudarStatusPedido de pedido");
        pedidoService.mudarStatusPedido(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/meusPedidos")
    @RolesAllowed("Cliente")
    public Response meusPedidos(){
        LOG.info("Executando o método meusPedidos() de pedido. ");
        try {
            return Response.ok(pedidoService.meusPedidos()).build();
        } catch (NotFoundException e) {
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}