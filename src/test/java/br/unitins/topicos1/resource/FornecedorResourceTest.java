package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FornecedorResourceTest {
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        TelefoneDTO telefone = new TelefoneDTO("63", "125487");

        FornecedorDTO dto = new FornecedorDTO(
        "Americanas", 
        "Rua das flores", 
        "americanas@gmail.com", 
        telefone, 
        "123456789456123");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/fornecedores")
        .then()
            .statusCode(201)
            .body("nome", is("Americanas"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");
        FornecedorDTO dto = new FornecedorDTO(
            "Gigante", 
            "Rua das flores", 
            "gigante@gmail.com", 
            telefone, 
            "123456789456123"
        );

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/fornecedores/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Kabum", "Gigante"));
    }
    
    @Test
    public void findById(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores/search/nome/Americanas")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Americanas")));    
    } 

    @Test
    public void findByCnpj(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores/search/cnpj/72227573000163")
            .then()
            .statusCode(200)
            .body("cnpj", everyItem(is("72227573000163"))); 
    }

    @Test
    public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTY5NDM2MTUsImlhdCI6MTcxNjg1NzIxNSwianRpIjoiMzY0ZTg1MWYtYmVhYy00NGY3LWEyNmUtNWQ2OWE4YzMwYzEzIn0.lHY_2II0Pz4M24iLL5iiBfoj_3OVG4vaBgZaODA8s8qxu0tMuJ9opTKtX7t5d21W0YgYx658EpwNTKXqE8AZJKVMzsu2qO7bM4iTKdoGt-DeQcNyYI-Emh4cI83IZYxJIDHRfXgarfTXYZgLai1ZxPHnEuvJxeczuPtTxpmd3PHDzWJV-gxqUB9xZqYN_0y4cNF3qaxqJcsDjNwxyFVJz6gomNkXmovi6GihtN5L5kFOmhPnbNOQXM73mGHOGPyNbVmxAcP43x6dTgoQJ5W_fqIgo6hCSR4I8LVHnZ4j-N0ovSls9IWJhob0ft6fOVemDt2jo3MdfVJ7M4T7JRTJaQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 1)
            .delete("/fornecedores/{id}")
            .then()
            .statusCode(204);
    }
}
