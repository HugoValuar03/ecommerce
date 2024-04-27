package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
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
    
    @Test
    public void createTest(){
        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Leandrin",  "leandrin@gmail.com", "98765432134", 1, LocalDate.parse("1992-03-10"), telefone, "Vendedor");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionarios")
        .then()
            .statusCode(201)
            .body("pessoa.nome", is("Leandrin"));
    }

    @Test
    public void updateTest(){
        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Leandro",  "leandrin@gmail.com", "98765432134", 1, LocalDate.parse("1992-03-10"), telefone, "Vendedor");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/funcionarios/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        given()
            .when()
                .get("/funcionarios")
            .then()
                .statusCode(200)
                .body("funcionario.nome", everyItem(is("Rafael")));
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/funcionarios/1")
            .then()
            .statusCode(200)
            .body("idFuncionario", is(1));
    }

    @Test
    public void findByCargoTest(){
        given()
            .when()
            .get("/funcionarios/search/cargo/Vendedor")
            .then()
            .statusCode(200)
            .body("cargo", everyItem(is("Vendedor")));  
    }

    @Test
     public void deleteTest(){
         given()
         .when()
         .pathParam("id", 1)
             .delete("/funcionarios/{id}")
         .then()
             .statusCode(204);
     }

}