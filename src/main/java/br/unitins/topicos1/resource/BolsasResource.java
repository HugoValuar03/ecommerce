package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.BolsasDTO;
import br.unitins.topicos1.dto.BolsasResponseDTO;
import br.unitins.topicos1.model.Bolsas;
import br.unitins.topicos1.repository.BolsasRepoistory;
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
@Path("/admin/bolsas")
public class BolsasResource {
    
    @Inject
    private BolsasRepoistory bolsasRepository;

    @GET
    public List<BolsasResponseDTO> findAll() {
        return bolsasRepository
        .listAll()
        .stream()
        .map(e -> BolsasResponseDTO.valueof(e)).toList();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<BolsasResponseDTO> findByNome(@PathParam("nome") String nome){
        return bolsasRepository
        .findByNome(nome)
        .stream()
        .map(e -> BolsasResponseDTO.valueof(e)).toList();
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<BolsasResponseDTO> findByCargo(@PathParam("marca") String marca){
        return bolsasRepository
        .findByMarca(marca)
        .stream()
        .map(e -> BolsasResponseDTO.valueof(e)).toList();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, BolsasDTO dto) {
        Bolsas estadoBanco =  bolsasRepository.findById(id);

        estadoBanco.setAltura(dto.altura());
        estadoBanco.setCor(dto.cor());
        estadoBanco.setLargura(dto.largura());
        estadoBanco.setMarca(dto.marca());
        estadoBanco.setModelo(dto.modelo());
        estadoBanco.setNome(dto.nome());
        estadoBanco.setValor(dto.valor());

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        bolsasRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public BolsasResponseDTO createCameras(BolsasDTO dto){
        Bolsas bolsas = new Bolsas();

        bolsas.setAltura(dto.altura());
        bolsas.setCor(dto.cor());
        bolsas.setLargura(dto.largura());
        bolsas.setMarca(dto.marca());
        bolsas.setModelo(dto.modelo());
        bolsas.setNome(dto.nome());
        bolsas.setValor(dto.valor());

        bolsasRepository.persist(bolsas);

        return BolsasResponseDTO.valueof(bolsas);

    }
}
