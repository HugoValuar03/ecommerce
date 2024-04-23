package br.unitins.topicos1.resource;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MarcaResourceTest {
    
    //hasItem(): É usado para verificar se uma determinada coleção contém um item específico.
    //is(): é usado para verificar se o resultado de um teste é igual a um valor esperado. Ele pode ser usado para comparar valores simples ou objetos complexos.
    //everyItem(): é usado para verificar se todos os elementos de uma coleção atendem a determinados critérios. Ele é útil para verificar se todos os elementos de uma coleção satisfazem uma determinada condição.

    @Test
    public void createTest(){
        MarcaDTO dto = new MarcaDTO("Canon");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/admin/marca")
        .then()
            .statusCode(201)
            .body("nome", is("Canon"));
    }

    @Test
    public void findAllTest(){
        given()
            .when()
            .get("/admin/marca")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/admin/marca/2")
            .then()
            .statusCode(200)
            .body("id", is(2));

    }

    @Test
    public void findByNomeTest(){
        given()
            .when()
            .get("/admin/marca/search/Canon")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Canon")));
    }

}
