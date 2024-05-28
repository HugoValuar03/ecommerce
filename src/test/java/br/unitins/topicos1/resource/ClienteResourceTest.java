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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");

        ClienteDTO dto = new ClienteDTO("João", "joao@gmail.com",  "018.248.657-98", 1, LocalDate.parse("2003-03-10"), telefone, "João", "321");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/clientes")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("João"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        ClienteDTO dto = new ClienteDTO("Rafael", "rafael@gmail.com", "08015749532", 1, LocalDate.parse("2003-03-10"), telefone,"Rafael", "123");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/clientes/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";
        given()
            .header("Authorization", "Bearer " + tokenAdm)  
            .when()
                .get("/clientes")
            .then()
                .statusCode(200)
                .body("cliente.nome", everyItem(is("Ana")));
    }

    @Test
    public void findByCpf(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/clientes/search/cpf/123.456.729-12")
            .then()
            .statusCode(200)
            .body("cpf.cpf", everyItem(is("123.456.729-12"))); 
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/clientes/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";
         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 1)
             .delete("/clientes/{id}")
         .then()
             .statusCode(204);
     }
}
