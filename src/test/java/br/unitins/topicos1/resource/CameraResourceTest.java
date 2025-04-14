package br.unitins.topicos1.resource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDcxNjcyMCwiaWF0IjoxNzQ0NjMwMzIwLCJqdGkiOiJlNzY5ZTBkYS00MGVlLTRiMTgtODFmYy1lMDE4NDI2NzEyMjQifQ.qD7tgfyNebZGyRdJ935_GM4E5heSr163AY5LT3A-CKPcBd0UkxIxRTYjSikwCFAfHbv60f7b8jOc_RsgFHdTm9gCkCbtjzDB-yp8y7hLO-jl4Y0mAmMCWYYb_bsXxKqly8tlTS6OxirOrAFlapW0P05ANjLLFfDDAwZ9xFsD-nAzj5Iu-srLSdQDwyqo_hhd7CwuAn11fFUnd_lGkuxew0R7Aq3kG0PfDdLXZYYMS2qRnf3a4ZLrOIYw-Ox3SbX0Bc8XXFGzOcwGqbCyKMSpsIhsSdFcM6hU1xXzIl5pnb1aRmyP6QQv0H71jC2L3pS57gykr9Pt7P9uh7att2hNdA ";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmEuZ29tZXMiLCJncm91cHMiOlsiQ2xpZW50ZSJdLCJleHAiOjE3NDQ3MTY4MDMsImlhdCI6MTc0NDYzMDQwMywianRpIjoiN2Y5OGY2NDAtOWU1Ni00NTVkLThkZjMtMTFkNzQ5MmY0NzhmIn0.n1PlYd47Q_D3CUtElWmISkfYlgmWsS1itCeIrszvaits1cRtWRJfwoNudlB6sJNMZZ7jRaWziBT83mNEDKgQ3w8q_5Yxv8nkc9xjk3IxPLoVWX0CCS2IRJQOroxFm5FNTgx830pb4U4hPDp4e4mw_HQToKkO8kNEV5o4D07A-C-yFOCvXRfTWYVv24tQPwSAt7raCJfgovOByGviyOOxOhT19BeLK4zE8FQkthXSM81Y5fBXlUlY1mw5QQjPtvYIs6vqeAR8EtJ5IXfRoJlxH9WkK2V2e5VY7CRw4gA8FDW0-1MkUu6rqxWnbG-z-1NRHfythxEZW-R9HESp8fZpVg";
   
    @Test
     public void createTest(){

        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT99", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("Wi-fi", "24mp", true, true, "IPS", "12000", true, 3, produto);

         given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(camera)
         .when()
             .post("/camera")
         .then() 
             .statusCode(201)
             .body("resolucao", equalTo("24mp"));
     }  

     @Test
     public void updateTest(){        
        
        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT6", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("5G", "24mp", true, true, "IPS", "12000", true, 3, produto);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(camera)
        .when()
            .pathParam("id",3)
            .put("/camera/{id}")
        .then()
            .statusCode(204); 

     }
     
     @Test
     public void findAllTest(){
        
        given()
            .header("Authorization", "Bearer " + tokenCliente)
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/camera")
        .then()
            .statusCode(200)
            .body("resolucao", hasItem(is("24mp")));
     }

    @Test
    public void findByIdTest(){
        
        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/camera/3")
            .then()
            .statusCode(200)
            .body("id", is(3)); 
    }

    @Test
    public void findByMarcaTest(){

        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
        .header("Authorization", "Bearer " + tokenCliente)
        .when()
            .get("/camera/search/marca/Canon")
        .then()
            .statusCode(200)
            .body("marca.marca", everyItem(is("Canon")));
     }

    @Test
    public void deleteTest(){
     
        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
        .when()
        .pathParam("id", 1)
        .delete("/camera/{id}")
        .then()
        .statusCode(204);
}

}
