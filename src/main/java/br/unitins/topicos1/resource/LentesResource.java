package br.unitins.topicos1.resource;

import java.util.List;

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
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/admin/lentes")
public class LentesResource {
    @Inject
    public LentesRepository lentesRepository;

    @GET
    public List<Lentes> findAll() {
        return lentesRepository.listAll();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<Lentes> findByNome(@PathParam("nome") String nome){
        return lentesRepository.findByNome(nome);
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<Lentes> findByMarca(@PathParam("marca") String marca){
        return lentesRepository.findByMarca(marca);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Lentes lentes) {
        Lentes estadoBanco =  lentesRepository.findById(id);

        estadoBanco.setNome(lentes.getNome());
        estadoBanco.setMarcaLente(lentes.getMarcaLente());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        lentesRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public Response createLente(Lentes createLente){
        Lentes lente = new Lentes();

        lente.setNome(createLente.getNome());
        lente.setMarcaLente(createLente.getMarcaLente());
        

        lente.persist();

        return Response.ok(lente).build();

    }
}
