package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ClienteResourceTest {
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");

        ClienteDTO cliente = new ClienteDTO("Rogério", "rogerio@gmail.com", "080.231.545-41", 1, LocalDate.parse("1992-03-10"), telefone, "rogerio.soares");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        ClienteDTO dto = new ClienteDTO("Rogério", "rogerio@gmail.com", "080.231.545-41", 1, LocalDate.parse("1992-03-10"), telefone, tokenAdm);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/cliente/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
        given()
            .header("Authorization", "Bearer " + tokenAdm)  
            .when()
                .get("/cliente")
            .then()
                .statusCode(200)
                .body("cliente.nome", everyItem(is("Ana")));
    }

    @Test
    public void findByCpf(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/cliente/search/cpf/123.456.729-12")
            .then()
            .statusCode(200)
            .body("cpf.cpf", everyItem(is("123.456.729-12"))); 
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/cliente/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 1)
             .delete("/cliente/{id}")
         .then()
             .statusCode(204);
     }
}
