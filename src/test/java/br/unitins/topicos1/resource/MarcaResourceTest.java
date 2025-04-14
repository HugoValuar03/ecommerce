package br.unitins.topicos1.resource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MarcaResourceTest {

    
    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDcxNjcyMCwiaWF0IjoxNzQ0NjMwMzIwLCJqdGkiOiJlNzY5ZTBkYS00MGVlLTRiMTgtODFmYy1lMDE4NDI2NzEyMjQifQ.qD7tgfyNebZGyRdJ935_GM4E5heSr163AY5LT3A-CKPcBd0UkxIxRTYjSikwCFAfHbv60f7b8jOc_RsgFHdTm9gCkCbtjzDB-yp8y7hLO-jl4Y0mAmMCWYYb_bsXxKqly8tlTS6OxirOrAFlapW0P05ANjLLFfDDAwZ9xFsD-nAzj5Iu-srLSdQDwyqo_hhd7CwuAn11fFUnd_lGkuxew0R7Aq3kG0PfDdLXZYYMS2qRnf3a4ZLrOIYw-Ox3SbX0Bc8XXFGzOcwGqbCyKMSpsIhsSdFcM6hU1xXzIl5pnb1aRmyP6QQv0H71jC2L3pS57gykr9Pt7P9uh7att2hNdA ";

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
