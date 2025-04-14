package br.unitins.topicos1.resource;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ClienteResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDcxNjcyMCwiaWF0IjoxNzQ0NjMwMzIwLCJqdGkiOiJlNzY5ZTBkYS00MGVlLTRiMTgtODFmYy1lMDE4NDI2NzEyMjQifQ.qD7tgfyNebZGyRdJ935_GM4E5heSr163AY5LT3A-CKPcBd0UkxIxRTYjSikwCFAfHbv60f7b8jOc_RsgFHdTm9gCkCbtjzDB-yp8y7hLO-jl4Y0mAmMCWYYb_bsXxKqly8tlTS6OxirOrAFlapW0P05ANjLLFfDDAwZ9xFsD-nAzj5Iu-srLSdQDwyqo_hhd7CwuAn11fFUnd_lGkuxew0R7Aq3kG0PfDdLXZYYMS2qRnf3a4ZLrOIYw-Ox3SbX0Bc8XXFGzOcwGqbCyKMSpsIhsSdFcM6hU1xXzIl5pnb1aRmyP6QQv0H71jC2L3pS57gykr9Pt7P9uh7att2hNdA ";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmEuZ29tZXMiLCJncm91cHMiOlsiQ2xpZW50ZSJdLCJleHAiOjE3NDQ3MTY4MDMsImlhdCI6MTc0NDYzMDQwMywianRpIjoiN2Y5OGY2NDAtOWU1Ni00NTVkLThkZjMtMTFkNzQ5MmY0NzhmIn0.n1PlYd47Q_D3CUtElWmISkfYlgmWsS1itCeIrszvaits1cRtWRJfwoNudlB6sJNMZZ7jRaWziBT83mNEDKgQ3w8q_5Yxv8nkc9xjk3IxPLoVWX0CCS2IRJQOroxFm5FNTgx830pb4U4hPDp4e4mw_HQToKkO8kNEV5o4D07A-C-yFOCvXRfTWYVv24tQPwSAt7raCJfgovOByGviyOOxOhT19BeLK4zE8FQkthXSM81Y5fBXlUlY1mw5QQjPtvYIs6vqeAR8EtJ5IXfRoJlxH9WkK2V2e5VY7CRw4gA8FDW0-1MkUu6rqxWnbG-z-1NRHfythxEZW-R9HESp8fZpVg";
    
    @Test
    public void createTest(){

        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");

        ClienteDTO cliente = new ClienteDTO("Rogério", "rogerio@gmail.com", "080.231.545-42", 1, LocalDate.parse("1992-03-10"), telefone, "rogerio.soares");

        given()
            .header("Authorization", "Bearer " + tokenCliente)
            .contentType(MediaType.APPLICATION_JSON)
            .body(cliente)
        .when()
            .post("/cliente")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("Rogério"));
    }

    @Test
    public void updateTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        ClienteDTO dto = new ClienteDTO("Rogério", "rogerio@gmail.com", "080.231.545-41", 1, LocalDate.parse("1992-03-10"), telefone, tokenFuncionario);

        given()
            .header("Authorization", "Bearer " + tokenCliente)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/cliente/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        given()
            .header("Authorization", "Bearer " + tokenFuncionario)  
            .when()
                .get("/cliente")
            .then()
                .statusCode(200)
                .body("cliente.nome", everyItem(is("Ana")));
    }

    @Test
    public void findByCpf(){
        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/cliente/search/cpf/123.456.729-12")
            .then()
            .statusCode(200)
            .body("cpf.cpf", everyItem(is("123.456.729-12"))); 
    }

    @Test
    public void findByIdTest(){
        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/cliente/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
     public void deleteTest(){
         given()
         .header("Authorization", "Bearer " + tokenCliente)
         .when()
         .pathParam("id", 1)
             .delete("/cliente/{id}")
         .then()
             .statusCode(204);
     }
}
