package br.unitins.topicos1.resource;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PessoaResourceTest {
    
    @Test
     public void findAllTest(){
        given()
            .when()
                .get("/pessoas")
            .then()
                .statusCode(200)
                .body("nome", hasItem(is("Felipe")));
    }

    @Test
    public void findByNomeTest(){
        given()
            .when()
            .get("/pessoas/search/nome/Rafael")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Rafael")));  
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/pessoas/2")
            .then()
            .statusCode(200)
            .body("id", is(2));
    }

    @Test
    public void updateTest() {
        TelefoneDTO telefone = new TelefoneDTO("55", "987731477");

        PessoaDTO dto = new PessoaDTO("Leonardo", "leonardo@gmail.com", "01923124123", 1, LocalDate.parse("2005-05-12"), telefone);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/pessoas/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void createTest(){
        TelefoneDTO telefone = new TelefoneDTO("41", "987231277");

        PessoaDTO dto = new PessoaDTO("Paula", "paula@gmail.com",  "01832865798", 2, LocalDate.parse("2002-01-10"), telefone);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/pessoas")
        .then()
            .statusCode(201)
            .body("nome", is("Paula"));
    }

    @Test
     public void deleteTest(){
         given()
         .when()
         .pathParam("id", 4)
             .delete("/pessoas/{id}")
         .then()
             .statusCode(204);
     }

}
