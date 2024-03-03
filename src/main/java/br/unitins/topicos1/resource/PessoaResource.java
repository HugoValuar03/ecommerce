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

@Produces(MediaType.APPLICATION_JSON) //Usada para fornecer instâncias de objetos que podem ser injetadas em outros componentes da aplicação
@Consumes(MediaType.APPLICATION_JSON) //Usada para indicar que um método de um recurso web ou um endpoint de serviço web pode consumir uma determinada representação de dados recebida  em uma solicitação HTTP.
@Path("/admin/pessoas") //Define o caminho da pesquisa, ex: "localhost:8080/admin/pessoas"
public class PessoaResource {

    @Inject //Usado para indicar que o objeto deve ser injetado automaticamente pelo contêiner CDI.
    public PessoaRepository pessoaRepository;

    @GET //Usado para retornar uma solicitação feita pelo usuário.
    public List<Pessoa> findAll() { //Declara uma lista de objetos do tipo `Pessoa`
        return pessoaRepository.listAll(); //Lista todo os elementos da tabela Pessoa
    }

    @GET
    @Path("/search/nome/{nome}") //Neste caso o caminho será "localhost:8080//admin/pesoas/search/nome/{Nome passado pelo usuário}".
    public List<Pessoa> findByNome(@PathParam("nome") String nome){
        return pessoaRepository.findByNome(nome);
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<Pessoa> findByCargo(@PathParam("cargo") String cargo){
        return pessoaRepository.findByCargo(cargo);
    }

    @PUT //Chamado quando para atualizar algum dado
    @Transactional
    @Path("/{id}") //"localhost:8080/admin/pessoas/{id que o usuario passar}"
    public void update(@PathParam("id") Long id, Pessoa pessoa) {
        Pessoa estadoBanco =  pessoaRepository.findById(id);

        estadoBanco.setNome(pessoa.getNome());
        estadoBanco.setCargo(pessoa.getCargo());
    }

    @DELETE //Chamado para deletar algum elemento, neste método, será deletado apartir o id passado
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        pessoaRepository.deleteById(id);
    }

    @POST //Chamado para criar um novo objeto de Pessoa
    @Transactional
    public Response createPessoa(Pessoa createPessoa){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(createPessoa.getNome());
        pessoa.setCargo(createPessoa.getCargo());

        pessoa.persist();

        return Response.ok(pessoa).build();

    }
}