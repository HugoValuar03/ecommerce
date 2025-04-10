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

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTk3NTcyNSwiaWF0IjoxNzE5ODg5MzI1LCJqdGkiOiI5NDBlNmI4OC1iYWViLTRiM2MtYWMzOC1iOTI4NGUyOTRjYzkifQ.Abl5SP3p_8eHU2VmhR6LPBCujJufoJw6jqJEoxX0KyZqxmR74ewLGUHxb-x98REHOuqTNZbUobI4Edbrzf3mGGYFnOgZ335hKTwb0UP10E9pzLd1o8rhXxfUMCmjxc2bdX56ibezo2FgsARyQ_ywIdFlNmFQbEpVQE1i1xnGkshFhBMUSAwfCQPEBM3t8k-rjpUlqjLioiIiH7evONqI0fev7ikQzYb8Cx0BOVtpsp6vuKw-QDjTQtLEXwx3xFOfwtDSXK2f5_Lzn7mdeVysP3RoGv3dA8QZId5gi7pNbYHy2gu3-nqw7CNhgnASAXeItQxlGNusA5aRTF_gDKpsMw";

    @Inject
    public MarcaService marcaService;

    @Test
    public void createTest(){
        

        MarcaDTO dto = new MarcaDTO("Panasonic");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/marca")
        .then()
            .statusCode(201)
            .body("marca", equalTo("Panasonic"));
    }

    @Test
    public void findAllTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/marca")
            .then()
            .statusCode(200)
            .body("marca", hasItem("Canon"));
    }

    @Test
    public void findByIdTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/marca/1")
            .then()
            .statusCode(200)
            .body("idMarca", equalTo(1));
    }

    @Test
    public void findByNomeTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/marca/search/marca/Canon")
            .then()
            .statusCode(200)
            .body("marca", everyItem(is("Canon")));  
    }

    @Test
    public void updateTest() {
        
        
        MarcaDTO dto = new MarcaDTO("Fujifilm");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/marca/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void deleteTest() {
        

        given()
        .when()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .pathParam("id", 4)
            .delete("/marca/{id}")
        .then()
            .statusCode(204);
    }

}
