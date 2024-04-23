package br.unitins.topicos1.resource;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class FornecedorResourceTeste {
    
    @Test
    public void createTest(){
        List<TelefoneDTO> telefone = new ArrayList<>();

        telefone.add(new TelefoneDTO("63", "984460444"));

        FornecedorDTO dto = new FornecedorDTO("Americanas", "Rua das flores", "americanas@gmail.com", telefone , "123456789456123");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/admin/fornecedores")
        .then()
            .statusCode(201)
            .body("nome", is("Americanas"));
    }
}
