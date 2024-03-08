package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
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

@Produces(MediaType.APPLICATION_JSON) //Usada para fornecer instâncias de objetos que podem ser injetadas em outros componentes da aplicação
@Consumes(MediaType.APPLICATION_JSON) //Usada para indicar que um método de um recurso web ou um endpoint de serviço web pode consumir uma determinada representação de dados recebida  em uma solicitação HTTP.
@Path("/admin/pessoas") //Define o caminho da pesquisa, ex: "localhost:8080/admin/pessoas"
public class PessoaResource {

    @Inject //Usado para indicar que o objeto deve ser injetado automaticamente pelo contêiner CDI.
    public PessoaRepository pessoaRepository;

    @GET
    @Path("/{id}")
    public PessoaResponseDTO findById(@PathParam("id")Long id){
        return PessoaResponseDTO.valueof(pessoaRepository.findById(id)); 
    }

    @GET //Usado para retornar uma solicitação feita pelo usuário.
    public List<PessoaResponseDTO> findAll() { //Declara uma lista de objetos do tipo `Pessoa`
        return pessoaRepository
        .listAll()
        .stream()
        .map(e -> PessoaResponseDTO.valueof(e)).toList(); //Lista todo os elementos da tabela Pessoa
    }

    @GET
    @Path("/search/nome/{nome}") //Neste caso o caminho será "localhost:8080/admin/pesoas/search/nome/{Nome passado pelo usuário}".
    public List<PessoaResponseDTO> findByNome(@PathParam("nome") String nome){
        return pessoaRepository
        .findByNome(nome)
        .stream()
        .map(e -> PessoaResponseDTO.valueof(e)).toList();
    }

    @GET
    @Path("/search/cargo/{cargo}") 
    public List<PessoaResponseDTO> findByCargo(@PathParam("cargo") String cargo){
        return pessoaRepository.findByCargo(cargo)
        .stream()
        .map(e -> PessoaResponseDTO.valueof(e)).toList();
    }

    @POST //Chamado para criar um novo objeto de Pessoa
    @Transactional
    public PessoaResponseDTO create(PessoaDTO dto){

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setCargo(dto.cargo());
        pessoa.setAniversario(dto.aniversario());
        pessoa.setCep(dto.cep());
        pessoa.setCidade(dto.cidade());
        pessoa.setComplemento(dto.complemento());
        pessoa.setCpf(dto.cpf());
        pessoa.setEmail(dto.email());
        pessoa.setEndereco(dto.endereco());
        pessoa.setTelefone(dto.telefone());
        pessoa.setEstado(dto.estado());

        pessoaRepository.persist(pessoa);

        return PessoaResponseDTO.valueof(pessoa);
    }

    @PUT //Chamado quando para atualizar algum dado
    @Transactional
    @Path("/{id}") //"localhost:8080/admin/pessoas/{id que o usuario passar}"
    public void update(@PathParam("id") Long id, PessoaDTO dto) {
        Pessoa estadoBanco =  pessoaRepository.findById(id);

        estadoBanco.setNome(dto.nome());
        estadoBanco.setCargo(dto.cargo());
    }

    @DELETE //Chamado para deletar algum elemento, neste método, será deletado apartir o id passado
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        pessoaRepository.deleteById(id);
    }
}
