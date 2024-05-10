package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.model.Marca;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTest {
    
    @Test
    public void createTest(){
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon DSLR", 50, 55, "EF", "Lente f3,0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/lentes")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon DSLR"));
    }

    @Test
    public void updateTest(){
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon EOS", 50, 55, "EF", "Lente f3.0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/lentes/{id}")
        .then()
            .statusCode(204); 
    }


    @Test
    public void findAllTest(){
        given()
            .when()
                .get("/lentes")
            .then()
                .statusCode(200)
                .body("material", hasItem("vidro"));
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/lentes/2")
            .then()
            .statusCode(200)
            .body("id", hasItem(is(2)));
    }

    @Test
    public void findByLenteTest(){
        given()
            .when()
            .get("/lentes/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
         given()
         .when()
         .pathParam("id", 3)
             .delete("/lentes/{id}")
         .then()
             .statusCode(204);
     }
}
