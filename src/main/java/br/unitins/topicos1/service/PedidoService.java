package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface PedidoService {

    public PedidoResponseDTO create(@Valid PedidoDTO dto);
    public void delete(@PathParam("id")Long id);
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findAll();
    public List<PedidoResponseDTO> findByCliente(Long idCliente);
    public Response realizarPagamento(@PathParam("id")Long id);
    public Response mudarStatusPedido(Long id, int idStatusPedido);

}