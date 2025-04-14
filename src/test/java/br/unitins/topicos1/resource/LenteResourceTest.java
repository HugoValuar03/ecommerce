package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LenteDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDcxNjcyMCwiaWF0IjoxNzQ0NjMwMzIwLCJqdGkiOiJlNzY5ZTBkYS00MGVlLTRiMTgtODFmYy1lMDE4NDI2NzEyMjQifQ.qD7tgfyNebZGyRdJ935_GM4E5heSr163AY5LT3A-CKPcBd0UkxIxRTYjSikwCFAfHbv60f7b8jOc_RsgFHdTm9gCkCbtjzDB-yp8y7hLO-jl4Y0mAmMCWYYb_bsXxKqly8tlTS6OxirOrAFlapW0P05ANjLLFfDDAwZ9xFsD-nAzj5Iu-srLSdQDwyqo_hhd7CwuAn11fFUnd_lGkuxew0R7Aq3kG0PfDdLXZYYMS2qRnf3a4ZLrOIYw-Ox3SbX0Bc8XXFGzOcwGqbCyKMSpsIhsSdFcM6hU1xXzIl5pnb1aRmyP6QQv0H71jC2L3pS57gykr9Pt7P9uh7att2hNdA ";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmEuZ29tZXMiLCJncm91cHMiOlsiQ2xpZW50ZSJdLCJleHAiOjE3NDQ3MTY4MDMsImlhdCI6MTc0NDYzMDQwMywianRpIjoiN2Y5OGY2NDAtOWU1Ni00NTVkLThkZjMtMTFkNzQ5MmY0NzhmIn0.n1PlYd47Q_D3CUtElWmISkfYlgmWsS1itCeIrszvaits1cRtWRJfwoNudlB6sJNMZZ7jRaWziBT83mNEDKgQ3w8q_5Yxv8nkc9xjk3IxPLoVWX0CCS2IRJQOroxFm5FNTgx830pb4U4hPDp4e4mw_HQToKkO8kNEV5o4D07A-C-yFOCvXRfTWYVv24tQPwSAt7raCJfgovOByGviyOOxOhT19BeLK4zE8FQkthXSM81Y5fBXlUlY1mw5QQjPtvYIs6vqeAR8EtJ5IXfRoJlxH9WkK2V2e5VY7CRw4gA8FDW0-1MkUu6rqxWnbG-z-1NRHfythxEZW-R9HESp8fZpVg";
    
    @Test
    public void createTest(){
        
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon DSLR", 10, 13, "FE", "Lente 45mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/lente")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon DSLR"));
    }

    @Test
    public void updateTest(){
        
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon", 10, 13, "FE", "Lente 50mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/lente/{id}")
        .then()
            .statusCode(204); 
    }


    @Test
    public void findAllTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .header("Authorization", "Bearer " + tokenCliente)
            .when()
                .get("/lente")
            .then()
                .statusCode(200)
                .body("montagem", hasItem("EF"));
    }

    @Test
    public void findByIdTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/lente/4")
            .then()
            .statusCode(200)
            .body("id", is(4));
    }

    @Test
    public void findByMontagemTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/lente/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        

         given()
         .header("Authorization", "Bearer " + tokenFuncionario)
         .when()
         .pathParam("id", 3)
             .delete("/lente/{id}")
         .then()
             .statusCode(204);
     }
}
