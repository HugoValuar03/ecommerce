package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.AcessoriosDTO;
import br.unitins.topicos1.dto.AcessoriosResponseDTO;
import br.unitins.topicos1.model.Acessorios;
import br.unitins.topicos1.repository.AcessoriosRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/admin/acessorios")
public class AcessoriosResource {
    @Inject
    private AcessoriosRepository acessoriosRepository;

    @GET
    public List<AcessoriosResponseDTO> findAll() {
        return acessoriosRepository
        .listAll()
        .stream()
        .map(a -> AcessoriosResponseDTO.valueOf(a)).toList();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<AcessoriosResponseDTO> findByNome(@PathParam("nome") String nome){
        return acessoriosRepository
        .findByNomeAcessorios(nome)
        .stream()
        .map(a -> AcessoriosResponseDTO.valueOf(a)).toList();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, AcessoriosDTO dto) {
        Acessorios estadoBanco =  acessoriosRepository.findById(id);

        estadoBanco.setAcessorio(dto.acessorio());
        estadoBanco.setAltura(dto.altura());
        estadoBanco.setCompatibilidade(dto.compatibilidade());
        estadoBanco.setCor(dto.cor());
        estadoBanco.setLargura(dto.largura());
        estadoBanco.setMaterial(dto.material());
        estadoBanco.setNomeProduto(dto.nomeProduto());
        estadoBanco.setPeso(dto.peso());
        estadoBanco.setPreco(dto.preco());

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        acessoriosRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public AcessoriosResponseDTO createCameras(AcessoriosDTO dto){
        Acessorios acessorios = new Acessorios();

        acessorios.setAcessorio(dto.acessorio());
        acessorios.setAltura(dto.altura());
        acessorios.setCompatibilidade(dto.compatibilidade());
        acessorios.setCor(dto.cor());
        acessorios.setLargura(dto.largura());
        acessorios.setMaterial(dto.material());
        acessorios.setNomeProduto(dto.nomeProduto());
        acessorios.setPeso(dto.peso());
        acessorios.setPreco(dto.preco());

        acessoriosRepository.persist(acessorios);

        return AcessoriosResponseDTO.valueOf(acessorios);

    }
}
