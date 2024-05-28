package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.model.Marca;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTest {
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon DSLR", 50, 55, "EF", "Lente f3,0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/lentes")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon DSLR"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon EOS", 50, 55, "EF", "Lente f3.0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/lentes/{id}")
        .then()
            .statusCode(204); 
    }


    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/lentes")
            .then()
                .statusCode(200)
                .body("material", hasItem("vidro"));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lentes/2")
            .then()
            .statusCode(200)
            .body("id", hasItem(is(2)));
    }

    @Test
    public void findByLenteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lentes/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 3)
             .delete("/lentes/{id}")
         .then()
             .statusCode(204);
     }
}
