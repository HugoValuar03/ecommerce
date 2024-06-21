package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

    public List<Pedido> findByCliente(Long idCliente) {
        return find("cliente.id", idCliente).list();
    }

}