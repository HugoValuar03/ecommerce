package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.PessoaResponseDTO;

public interface JwtService {
    String generateJwt(PessoaResponseDTO dto, int perfil);
}