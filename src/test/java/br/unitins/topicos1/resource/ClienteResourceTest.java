package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ClienteResourceTest {
    
    @Test
    public void createTest(){
        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");
        
        LocalDate dataNascimento = LocalDate.parse("2005-03-01");

        PessoaDTO pessoa = new PessoaDTO("João", "joao@gmail.com", "01824865798", 1, dataNascimento, telefone);

        ClienteDTO dto = new ClienteDTO(pessoa);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/clientes")
        .then()
            .statusCode(201)
            .body("nome", is("João"));
    }

    @Test
    public void updateTest(){
        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        LocalDate dataNascimento = LocalDate.parse("2004-03-12");

        PessoaDTO pessoa = new PessoaDTO("Rafael", "rafael@gmail.com", "08015749532", 1, dataNascimento, telefone);

        ClienteDTO dto = new ClienteDTO(pessoa);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/clientes/{id}")
        .then()
            .statusCode(204);
    }

}
