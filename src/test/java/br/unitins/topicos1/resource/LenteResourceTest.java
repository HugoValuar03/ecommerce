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
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon DSLR", 10, 13, "FE", "Lente 45mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon", 10, 13, "FE", "Lente 50mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/lente")
            .then()
                .statusCode(200)
                .body("montagem", hasItem("EF"));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lente/4")
            .then()
            .statusCode(200)
            .body("id", is(4));
    }

    @Test
    public void findByLenteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lente/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 3)
             .delete("/lente/{id}")
         .then()
             .statusCode(204);
     }
}
