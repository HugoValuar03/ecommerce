package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FuncionarioResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDcxNjcyMCwiaWF0IjoxNzQ0NjMwMzIwLCJqdGkiOiJlNzY5ZTBkYS00MGVlLTRiMTgtODFmYy1lMDE4NDI2NzEyMjQifQ.qD7tgfyNebZGyRdJ935_GM4E5heSr163AY5LT3A-CKPcBd0UkxIxRTYjSikwCFAfHbv60f7b8jOc_RsgFHdTm9gCkCbtjzDB-yp8y7hLO-jl4Y0mAmMCWYYb_bsXxKqly8tlTS6OxirOrAFlapW0P05ANjLLFfDDAwZ9xFsD-nAzj5Iu-srLSdQDwyqo_hhd7CwuAn11fFUnd_lGkuxew0R7Aq3kG0PfDdLXZYYMS2qRnf3a4ZLrOIYw-Ox3SbX0Bc8XXFGzOcwGqbCyKMSpsIhsSdFcM6hU1xXzIl5pnb1aRmyP6QQv0H71jC2L3pS57gykr9Pt7P9uh7att2hNdA ";

    @Test
    public void createTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Joelson", "joelson@gmail.com", "984.487.142-84", 1, LocalDate.parse("1970-02-13"), telefone, "Atendente", "joelson.pereira");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionario")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("Joelson"));

           
    }

    @Test
    public void updateTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Cleiton", "cleiton@gmail.com", "984.487.123-84", 1, LocalDate.parse("1970-02-13"), telefone, "Atendente", "cleiton.oliveira");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/funcionario/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){

        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
                .get("/funcionario")
            .then()
                .statusCode(200)
                .body("funcionario.nome", everyItem(is("Rafael")));
    }

    @Test
    public void findByIdTest(){

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/funcionario/1")
            .then()
            .statusCode(200)
            .body("idFuncionario", is(1));
    }

    @Test
    public void findByCargoTest(){

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/funcionario/search/cargo/Vendedor")
            .then()
            .statusCode(200)
            .body("cargo", everyItem(is("Vendedor")));  
    
    }

    @Test
     public void deleteTest(){

         given()
         .header("Authorization", "Bearer " + tokenFuncionario)
         .when()
         .pathParam("id", 2)
             .delete("/funcionario/{id}")
         .then()
             .statusCode(204);
     
    }
}
