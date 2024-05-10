package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ClienteResourceTest {
    
    @Test
    public void createTest(){
        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");

        ClienteDTO dto = new ClienteDTO("João", "joao@gmail.com",  "018.248.657-98", 1, LocalDate.parse("2003-03-10"), telefone);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/clientes")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("João"));
    }

    @Test
    public void updateTest(){
        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        ClienteDTO dto = new ClienteDTO("Rafael", "rafael@gmail.com", "08015749532", 1, LocalDate.parse("2003-03-10"), telefone);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/clientes/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        given()
            .when()
                .get("/clientes")
            .then()
                .statusCode(200)
                .body("cliente.nome", everyItem(is("Ana")));
    }

    @Test
    public void findByCpf(){
        given()
            .when()
            .get("/clientes/search/cpf/123.456.729-12")
            .then()
            .statusCode(200)
            .body("cpf.cpf", everyItem(is("123.456.729-12"))); 
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/clientes/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
     public void deleteTest(){
         given()
         .when()
         .pathParam("id", 1)
             .delete("/clientes/{id}")
         .then()
             .statusCode(204);
     }
}
