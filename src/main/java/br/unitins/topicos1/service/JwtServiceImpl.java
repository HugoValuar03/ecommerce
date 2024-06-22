package br.unitins.topicos1.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import br.unitins.topicos1.dto.AuthPessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(PessoaResponseDTO dto, AuthPessoaDTO dto2) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        if(dto2.perfil() == 1){
            roles.add("Funcionario");
        }else if (dto2.perfil() == 2){
            roles.add("Cliente");
        }

        return Jwt.issuer("unitins-jwt")
            .claim("id", dto.id())
            .subject(dto.username())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }

}