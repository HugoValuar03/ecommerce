package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.model.Marca;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTeste {
    
    @Test
    public void createTest(){
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon", 10, 15, "LA", "Canon Lens", 4500.00, "Plástico", "10x20x15", "Canon Lens2", marca);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/admin/lente")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon"));
    }

    @Test
    public void findAllTest(){
        given()
            .when()
                .get("/admin/lente")
            .then()
                .statusCode(200)
                .body("nomeProduto", hasItem(is("Canon Lens")));
    }

}
