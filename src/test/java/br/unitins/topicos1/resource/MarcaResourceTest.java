package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MarcaResourceTest {
    
    //hasItem(): É usado para verificar se uma determinada coleção contém um item específico.
    //is(): é usado para verificar se o resultado de um teste é igual a um valor esperado. Ele pode ser usado para comparar valores simples ou objetos complexos.
    //everyItem(): é usado para verificar se todos os elementos de uma coleção atendem a determinados critérios. Ele é útil para verificar se todos os elementos de uma coleção satisfazem uma determinada condição.

    @Inject
    public MarcaService marcaService;

    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        MarcaDTO dto = new MarcaDTO("Panasonic");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/marca")
        .then()
            .statusCode(201)
            .body("marca", equalTo("Panasonic"));
    }

    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/marca")
            .then()
            .statusCode(200)
            .body("marca", hasItem("Canon"));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/marca/1")
            .then()
            .statusCode(200)
            .body("idMarca", equalTo(1));
    }

    @Test
    public void findByNomeTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/marca/search/marca/Canon")
            .then()
            .statusCode(200)
            .body("marca", everyItem(is("Canon")));  
    }

    @Test
    public void updateTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
        
        MarcaDTO dto = new MarcaDTO("Fujifilm");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/marca/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void deleteTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
        .when()
            .header("Authorization", "Bearer " + tokenAdm)
            .pathParam("id", 4)
            .delete("/marca/{id}")
        .then()
            .statusCode(204);
    }

}
