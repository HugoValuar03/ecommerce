package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.AuthPessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.service.ClienteService;
import br.unitins.topicos1.service.FuncionarioService;
import br.unitins.topicos1.service.HashService;
import br.unitins.topicos1.service.JwtService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject
    public ClienteService clienteService;

    @Inject
    public FuncionarioService funcionarioService;

    @Inject
    public HashService hashService;

    @Inject
    public JwtService jwtService;

    @POST
    public Response login(AuthPessoaDTO dto) {
        String hash = hashService.getHashSenha(dto.senha());

        PessoaResponseDTO pessoa = null;

        if (dto.perfil() == 1) { // perfil 1 = cliente
            pessoa = funcionarioService.login(dto.username(), hash);
        } else if(dto.perfil() == 2) { // Perfil 2 = Funcionario
            pessoa = clienteService.login(dto.username(), hash);
        } else{
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(pessoa)
        .header("Authorization", jwtService.generateJwt(pessoa,dto.perfil()))
        .build();
    }
}