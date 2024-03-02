package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.repository.PessoaRepository;
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
@Path("/admin/pessoas")
public class PessoaResource {

    @Inject
    public PessoaRepository pessoaRepository;

    @GET
    public List<Pessoa> findAll() {
        return pessoaRepository.listAll();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<Pessoa> findByNome(@PathParam("nome") String nome){
        return pessoaRepository.findByNome(nome);
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<Pessoa> findByCargo(@PathParam("cargo") String cargo){
        return pessoaRepository.findByCargo(cargo);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Pessoa pessoa) {
        Pessoa estadoBanco =  pessoaRepository.findById(id);

        estadoBanco.setNome(pessoa.getNome());
        estadoBanco.setCargo(pessoa.getCargo());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        pessoaRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public Response createPessoa(Pessoa createPessoa){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(createPessoa.getNome());
        pessoa.setCargo(createPessoa.getCargo());

        pessoa.persist();

        return Response.ok(pessoa).build();

    }
}