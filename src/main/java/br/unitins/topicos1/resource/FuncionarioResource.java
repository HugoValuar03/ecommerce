package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.service.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON) //Usada para fornecer instâncias de objetos que podem ser injetadas em outros componentes da aplicação
@Consumes(MediaType.APPLICATION_JSON) //Usada para indicar que um método de um recurso web ou um endpoint de serviço web pode consumir uma determinada representação de dados recebida  em uma solicitação HTTP.
@Path("/funcionarios") //Define o caminho da pesquisa, ex: "localhost:8080/admin/pessoas"
public class FuncionarioResource {

    @Inject //Usado para indicar que o objeto deve ser injetado automaticamente pelo conteiner CDI.
    public FuncionarioService funcionarioService;


    //Teste Feito
    @GET //Usado para retornar uma solicitação feita pelo usuário.
    public Response findAll(){
        return Response.ok(funcionarioService.findAll()).build();
    }

    //Teste Feito
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        return Response.ok(funcionarioService.findById(id)).build(); 
    }

        // public List<PessoaResponseDTO> findAll() { //Declara uma lista de objetos do tipo `Pessoa`
        //     Object pessoaRepository;
        //     return pessoaRepository
        //     .listAll()
        //     .stream()
        //     .map(e -> PessoaResponseDTO.valueOf(e)).toList(); //Lista todo os elementos da tabela Pessoa
        //}
        
    //Teste Feito
    @GET
    @Path("/search/cargo/{cargo}") 
    public Response findByCargo(@PathParam("cargo") String cargo){
        return Response.ok(funcionarioService.findByCargo(cargo)).build();
    }

    //Teste Feito
    @POST //Chamado para criar um novo objeto de Pessoa
    public Response create(@Valid FuncionarioDTO dto){
        
        return Response.status(Status.CREATED)
            .entity(funcionarioService.create(dto)).build();
        // Pessoa pessoa = new Pessoa();
        // pessoa.setNome(dto.nome());
        // pessoa.setCargo(dto.cargo());
        // pessoa.setAniversario(dto.aniversario());
        // pessoa.setCep(dto.cep());
        // pessoa.setCidade(dto.cidade());
        // pessoa.setComplemento(dto.complemento());
        // pessoa.setCpf(dto.cpf());
        // pessoa.setEmail(dto.email());
        // pessoa.setEndereco(dto.endereco());
        // pessoa.setTelefone(dto.telefone());
        // pessoa.setEstado(dto.estado());

        // pessoaRepository.persist(pessoa);

    }

    //Teste Feito
    @PUT //Chamado quando para atualizar algum dado
    @Path("/{id}") //"localhost:8080/admin/funcionarios/{id que o usuario passar}"
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        funcionarioService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();

        // Pessoa estadoBanco =  pessoaRepository.findById(id);

        // estadoBanco.setNome(dto.nome());
        // estadoBanco.setCargo(dto.cargo());
        // estadoBanco.setCep(dto.cep());
        // estadoBanco.setCidade(dto.cidade());
        // estadoBanco.setComplemento(dto.complemento());
        // estadoBanco.setEmail(dto.email());
        // estadoBanco.setEndereco(dto.endereco());
        // estadoBanco.setEstado(dto.estado());
        // estadoBanco.setNome(dto.nome());
        // estadoBanco.setTelefone(dto.telefone());
        
    }

    //Teste Feito
    @DELETE //Chamado para deletar algum elemento, neste método, será deletado apartir o id passado
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        funcionarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
        // pessoaRepository.deleteById(id);
    }
}
