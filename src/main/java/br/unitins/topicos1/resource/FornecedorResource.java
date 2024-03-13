package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.FornecedorResponseDTO;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.repository.FornecedorRepository;
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
@Path("/admin/fornecedores")
public class FornecedorResource {
    
    @Inject
    public FornecedorRepository fornecedorRepository;

    @GET
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository
        .listAll()
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/nome/{nome}") 
    public List<FornecedorResponseDTO> findByNome(@PathParam("nome") String nome){
        return fornecedorRepository
        .findByNome(nome)
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, FornecedorDTO dto) {
        Fornecedor estadoBanco =  fornecedorRepository.findById(id);

        estadoBanco.setNome(dto.nome());
        estadoBanco.setEndereco(dto.endereco());
        estadoBanco.setCnpj(dto.cnpj());
        estadoBanco.setEmail(dto.email());
        estadoBanco.setTelefone(dto.telefone());

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        fornecedorRepository.deleteById(id);
    }

    @POST  
    @Transactional
    public FornecedorResponseDTO createLente(FornecedorDTO dto){
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(dto.nome());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmail(dto.email());
        fornecedor.setTelefone(dto.telefone());
    
        fornecedorRepository.persist(fornecedor);

        return FornecedorResponseDTO.valueOf(fornecedor);

    }
}
