package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PedidoResourceTest {
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

        ItemPedidoDTO itemPedido = new ItemPedidoDTO(2, 1L);

        PedidoDTO pedido = new PedidoDTO(1L, List.of(itemPedido), 2);
    
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(pedido)
        .when()
            .post("/pedido")
        .then()
            .statusCode(201)
            .body("marca", equalTo("Sony"));
    }

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/pedido")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedido/1")
            .then()
            .statusCode(200);
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTkwMTk0MDYsImlhdCI6MTcxODkzMzAwNiwianRpIjoiNWE3MmVkZGYtOWZiNi00MTYyLTg2ODItMWUzZDBkOWRkOGI4In0.sDh1HjjVXcofQ6DkpvJDub3c796GTqIFPzPg_7tzvYiKNAnL6ghqjd62naifPYsbGrohtVkKZVfpK36vpspYD3AXgSzYMh_xqfzMmKFsgrdBCNECDdRpHLwdvfo_ORTAk5621B5zDNDZC02tWOTGDIx_GhIbBEtYR-XNrV3IMxfwZ8imMm3qqnRe1ipkzYUdL7mur9tQl9R2RziVYYFZS7XgzvLVxx8WhqZDMlCAifFRubz6aqzfHyD1uQ6jNOx7b_ZYU_-hQ2fDQ3R_DYJ8FGKn15lTZTkKVc-FQTDgQ2_H4px1NAqiSQQ_ZjZlkEYOCI8JdYgHZTWQQs26d5-yrQ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 2)
             .delete("/pedido/{id}")
         .then()
             .statusCode(204);
     }

}
