package br.unitins.topicos1.resource;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PessoaResourceTest {
    
    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/pessoas")
            .then()
                .statusCode(200)
                .body("nome", hasItem(is("Felipe")));
    }

    @Test
    public void findByNomeTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/pessoas/search/nome/Rafael")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Rafael")));  
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/pessoas/2")
            .then()
            .statusCode(200)
            .body("id", is(2));
    }

    @Test
    public void updateTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        TelefoneDTO telefone = new TelefoneDTO("55", "987731477");

        PessoaDTO dto = new PessoaDTO("Leonardo", "leonardo@gmail.com", "01923124123", 1, LocalDate.parse("2005-05-12"), telefone);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/pessoas/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        TelefoneDTO telefone = new TelefoneDTO("41", "987231277");

        PessoaDTO dto = new PessoaDTO("Paula", "paula@gmail.com",  "01832865798", 2, LocalDate.parse("2002-01-10"), telefone);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/pessoas")
        .then()
            .statusCode(201)
            .body("nome", is("Paula"));
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 5)
             .delete("/pessoas/{id}")
         .then()
             .statusCode(204);
     }

}
