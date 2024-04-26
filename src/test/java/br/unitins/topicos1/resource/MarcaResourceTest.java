package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MarcaResourceTest {
    
    //hasItem(): É usado para verificar se uma determinada coleção contém um item específico.
    //is(): é usado para verificar se o resultado de um teste é igual a um valor esperado. Ele pode ser usado para comparar valores simples ou objetos complexos.
    //everyItem(): é usado para verificar se todos os elementos de uma coleção atendem a determinados critérios. Ele é útil para verificar se todos os elementos de uma coleção satisfazem uma determinada condição.

    @Inject
    public MarcaService marcaService;

    @Test
    public void createTest(){
        MarcaDTO dto = new MarcaDTO("Canon");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/marcas")
        .then()
            .statusCode(201)
            .body("nome", is("Canon"));
    }

    @Test
    public void findAllTest(){
        given()
            .when()
            .get("/marcas")
            .then()
            .statusCode(200)
            .body("nome", hasItem("Canon"));
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/marcas/1")
            .then()
            .statusCode(200)
            .body("idMarca", equalTo(1));
    }

    @Test
    public void findByNomeTest(){
        given()
            .when()
            .get("/marcas/search/nome/Canon")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Canon")));  
    }

    @Test
    public void updateTest() {
        
        MarcaDTO dto = new MarcaDTO("Fujifilm");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/marcas/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void deleteTest() {
        given()
            .when()
            .pathParam("id", 3)
            .delete("/marcas/{id}")
            .then()
            .statusCode(204);
    }

}
