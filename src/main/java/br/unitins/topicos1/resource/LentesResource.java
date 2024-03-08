package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import br.unitins.topicos1.model.Lentes;
import br.unitins.topicos1.repository.LentesRepository;
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
@Path("/admin/lentes")
public class LentesResource {
    @Inject
    public LentesRepository lentesRepository;

    @GET
    public List<LentesResponseDTO> findAll() {
        return lentesRepository
        .listAll()
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<LentesResponseDTO> findByNome(@PathParam("nome") String nome){
        return lentesRepository
        .findByNome(nome)
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<LentesResponseDTO> findByMarca(@PathParam("marca") String marca){
        return lentesRepository
        .findByMarca(marca)
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, LentesDTO dto) {
        Lentes estadoBanco =  lentesRepository.findById(id);

        estadoBanco.setNomeProduto(dto.nomeProduto());
        estadoBanco.setMarcaLente(dto.marcaLente());
        estadoBanco.setAbertura(dto.abertura());
        estadoBanco.setCompatibilidade(dto.compatibilidade());
        estadoBanco.setDimensoes(dto.dimensoes());
        estadoBanco.setDistanciaFocal(dto.distanciaFocal());
        estadoBanco.setLente(dto.lentes());
        estadoBanco.setPeso(dto.peso());
        estadoBanco.setPreco(dto.preco());
        estadoBanco.setTipoMontagem(dto.tipoMontagem());

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        lentesRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public LentesResponseDTO createLente(LentesDTO dto){
        Lentes lente = new Lentes();

        lente.setNomeProduto(dto.nomeProduto());
        lente.setMarcaLente(dto.marcaLente());
        lente.setAbertura(dto.abertura());
        lente.setCompatibilidade(dto.compatibilidade());
        lente.setDimensoes(dto.dimensoes());
        lente.setDistanciaFocal(dto.distanciaFocal());
        lente.setLente(dto.lentes());
        lente.setPeso(dto.peso());
        lente.setPreco(dto.preco());
        lente.setTipoMontagem(dto.tipoMontagem());
    
        lente.persist();

        return LentesResponseDTO.valueOf(lente);

    }
}
