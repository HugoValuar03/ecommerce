package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.model.Marca;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTeste {
    
    @Test
    public void createTest(){
        Marca marca = new Marca(2L, "Nikon");

        CameraDTO dto = new CameraDTO(marca, "Wifi, Wireless", "1080p", true, false, "1080p", "300-3800", true, 3, "Nikon D7500", 4500.99, "plastico", "10x20x15", "T6");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/estados")
        .then()
            .statusCode(201)
            .body("nomeModelo", is("T6"));
    }
}
