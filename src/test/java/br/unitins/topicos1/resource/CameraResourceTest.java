package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT6", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("Wi-fi", "24mp", true, true, "IPS", "12000", true, 3, produto);

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
        
        
        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT6", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("5G", "24mp", true, true, "IPS", "12000", true, 3, produto);

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
        .when()
        .pathParam("id", 1)
        .delete("/camera/{id}")
        .then()
        .statusCode(204);
}

}
