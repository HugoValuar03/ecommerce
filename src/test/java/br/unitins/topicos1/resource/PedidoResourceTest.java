package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PedidoResourceTest {
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        MarcaDTO marca = new MarcaDTO("Sony");

        ProdutoDTO produto = new ProdutoDTO("Canon T6", 3400.00, "Plástico", "10x5x8", marca, 1L);

        ItemPedidoDTO itemPedido = new ItemPedidoDTO(produto, 2, 1L);

        PedidoDTO pedido = new PedidoDTO(1L,Collections.singletonList(itemPedido), produto);
    
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(pedido)
        .when()
            .post("/pedidos")
        .then()
            .statusCode(201)
            .body("marca", equalTo("Sony"));
    }

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/pedidos")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedidos/1")
            .then()
            .statusCode(200);
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 2)
             .delete("/pedidos/{id}")
         .then()
             .statusCode(204);
     }

}
