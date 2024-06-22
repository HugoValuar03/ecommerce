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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        ItemPedidoDTO itemPedido = new ItemPedidoDTO(2L, 3);

        PedidoDTO pedido = new PedidoDTO(1L, List.of(itemPedido), 3);
    
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

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedido")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedido/1")
            .then()
            .statusCode(200);
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 1)
             .delete("/pedido/{id}")
         .then()
             .statusCode(204);
     }

     @Test
    public void findByClienteTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedido/search/cliente/2")
            .then()
            .statusCode(200);
    }

}
