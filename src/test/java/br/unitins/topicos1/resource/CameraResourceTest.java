package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTest {
   
     @Test
     public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT6", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO(
            "5G", 
            "24mp",
            true,
            true,
            "IPS",
            "100-1200", 
            true, 
            3, 
            produto, 
            LocalDateTime.now());

         given()
            .header("Authorization", "Bearer " + tokenAdm)
             .contentType(MediaType.APPLICATION_JSON)
             .body(camera)
         .when()
             .post("/camera")
         .then()
             .statusCode(201)
             .body("tela", is("IPS"));
     }  

     @Test
     public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
        
        
        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT6", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("Wi-fi", "24mp", true, true, "IPS", "100-1200", true, 3, produto, LocalDateTime.now());

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/camera")
        .then()
            .statusCode(200)
            .body("resolucao", hasItem(is("24mp")));
     }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/camera/3")
            .then()
            .statusCode(200)
            .body("id", is(3)); 
    }

    @Test
    public void findByMarcaTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
        .when()
            .get("/camera/search/marca/Canon")
        .then()
            .statusCode(200)
            .body("marca.marca", everyItem(is("Canon")));
     }

    @Test
    public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
        .when()
        .pathParam("id", 1)
        .delete("/camera/{id}")
        .then()
        .statusCode(204);
}

}
