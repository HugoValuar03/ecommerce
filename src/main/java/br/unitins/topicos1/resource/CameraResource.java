package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.CamerasDTO;
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
import jakarta.ws.rs.core.Response;



@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/admin/cameras")
public class CameraResource {
    @Inject
    public CamerasRepository camerasRepository;

    @GET
    public List<Cameras> findAll() {
        return camerasRepository.listAll();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<Cameras> findByNome(@PathParam("nome") String nome){
        return camerasRepository.findByNomeProduto(nome);
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<Cameras> findByCargo(@PathParam("marca") String marca){
        return camerasRepository.findByMarca(marca);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Cameras cameras) {
        Cameras estadoBanco =  camerasRepository.findById(id);

        estadoBanco.setNomeProduto(cameras.getNomeProduto());
        estadoBanco.setMarca(cameras.getMarca());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        camerasRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public CamerasDTO createCameras(CamerasDTO dto){
        Cameras cameras = new Cameras();

        cameras.setNomeProduto(dto.nomeProduto());

        CamerasRepository.pe;

        return Response.ok(cameras).build();

    }
}
