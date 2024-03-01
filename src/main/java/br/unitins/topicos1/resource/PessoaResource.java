package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pessoas")
public class PessoaResource {

    @GET
    public List<Pessoa> findAll() {
        return Pessoa.listAll();
    }
    
}