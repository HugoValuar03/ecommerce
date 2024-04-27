package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.everyItem;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.model.Marca;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTest {
   
     @Test
     public void createTest(){
         Marca marca = new Marca(1L, "Canon");

         CameraDTO dto = new CameraDTO(marca, "Wi-fi", "24mp", true, true, "LCD", "ISO 100-12800", true, 2, 4500.00, "metal emborrachado", "116.33 x 85.6 x 68.83mm", "EOS R150");

         given()
             .contentType(MediaType.APPLICATION_JSON)
             .body(dto)
         .when()
             .post("/cameras")
         .then()
             .statusCode(201)
             .body("tela", is("LCD"));
     }

     @Test
     public void updateTest(){
        Marca marca = new Marca(1L, "Canon");

        CameraDTO dto = new CameraDTO(marca,"Wif-fi", "25mp", true, true, "IPS-LCD", "ISO 100-12800", true, 2, 4550.00, "metal emborrachado", "116.33 x 85.6 x 68.83mm", "EOS R150");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/cameras/{id}")
        .then()
            .statusCode(204); 

     }
     
     @Test
     public void findAllTest(){
        given()
            .when()
                .get("/cameras")
            .then()
                .statusCode(200)
                .body("resolucao", hasItem("25mp"));
     }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/cameras/2")
            .then()
            .statusCode(200)
            .body("id", is(2));
    }

    @Test
    public void findByMarcaTest(){
        given()
        .when()
            .get("/cameras/search/marca/Canon")
        .then()
            .statusCode(200)
            .body("nome", everyItem(is("Canon")));  
     }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/cameras/{id}")
        .then()
        .statusCode(204);
}

}
