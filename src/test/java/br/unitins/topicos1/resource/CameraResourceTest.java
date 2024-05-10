package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTest {
   
     @Test
     public void createTest(){

         CameraDTO dto = new CameraDTO("Canon EAS", "24mp", true, true, "LCD", "300-24000", true, 5, "Canon T6i", 5000.00, "Plastico", "10x20x30cm", 1L);

         given()
             .contentType(MediaType.APPLICATION_JSON)
             .body(dto)
         .when()
             .post("/cameras")
         .then()
             .statusCode(201)
             .body("resolucao", is("24mp"));
     }

     @Test
     public void updateTest(){

        CameraDTO dto = new CameraDTO("Canon EOS", "24mp", true, true, "LCD", "ISO 300-4500", false, 4, "Canon EF EOS", 4500.00, "metal", "10x15x13cm", 1L);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
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
                .body("resolucao", hasItem(is("24mp")));
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
            .body("marca.marca", everyItem(is("Canon")));
     }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/cameras/{id}")
        .then()
        .statusCode(204);
}

}
