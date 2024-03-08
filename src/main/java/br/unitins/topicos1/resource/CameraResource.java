package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.CamerasDTO;
import br.unitins.topicos1.dto.CamerasResponseDTO;
import br.unitins.topicos1.model.Cameras;
import br.unitins.topicos1.repository.CamerasRepository;
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
@Path("/admin/cameras")
public class CameraResource {
    @Inject
    public CamerasRepository camerasRepository;

    @GET
    public List<CamerasResponseDTO> findAll() {
        return camerasRepository
        .listAll()
        .stream()
        .map(e -> CamerasResponseDTO.valueof(e)).toList();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<CamerasResponseDTO> findByNome(@PathParam("nome") String nome){
        return camerasRepository
        .findByNomeProduto(nome)
        .stream()
        .map(e -> CamerasResponseDTO.valueof(e)).toList();
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<CamerasResponseDTO> findByCargo(@PathParam("marca") String marca){
        return camerasRepository
        .findByMarca(marca)
        .stream()
        .map(e -> CamerasResponseDTO.valueof(e)).toList();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, CamerasDTO dto) {
        Cameras estadoBanco =  camerasRepository.findById(id);

        estadoBanco.setNomeProduto(dto.nomeProduto());
        estadoBanco.setMarca(dto.marca());
        estadoBanco.setBateria(dto.bateria());
        estadoBanco.setFormatoAudio(dto.formatoAudio());
        estadoBanco.setFormatoImagem(dto.formatoImagem());
        estadoBanco.setFormatoVideo(dto.formatoVideo());
        estadoBanco.setIso(dto.iso());
        estadoBanco.setLente(dto.lentes());
        estadoBanco.setObturador(dto.obturador());
        estadoBanco.setPreco(dto.preco());
        estadoBanco.setProcessador(dto.processador());
        estadoBanco.setSensor(dto.sensor());

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        camerasRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public CamerasResponseDTO createCameras(CamerasDTO dto){
        Cameras cameras = new Cameras();

        cameras.setNomeProduto(dto.nomeProduto());
        cameras.setBateria(dto.bateria());
        cameras.setFormatoAudio(dto.formatoAudio());
        cameras.setFormatoImagem(dto.formatoImagem());
        cameras.setFormatoVideo(dto.formatoVideo());
        cameras.setIso(dto.iso());
        cameras.setLente(dto.lentes());
        cameras.setMarca(dto.marca());
        cameras.setObturador(dto.obturador());
        cameras.setPreco(dto.preco());
        cameras.setProcessador(dto.processador());
        cameras.setSensor(dto.sensor());

        camerasRepository.persist(cameras);

        return CamerasResponseDTO.valueof(cameras);

    }
}
