package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FuncionarioResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDQwNzMzOSwiaWF0IjoxNzQ0MzIwOTM5LCJqdGkiOiIwZmE5ODUwMi05N2RiLTQ3NWYtYmIxNy1mZDY5NGQ5NjAwMDkifQ.gRoNgAzh5MZ74LpDRR2ATvt83sSGQ-UXtLxscq5j0jSjQNQIWFx2jz0o6Kdu61PD30aVYk09kka0xIfnJR_fJRMedAM5vmHBKq_g9JoGfvDUoKrhc0bVTfbPQHhDVGsWAMLKGMOQrQxzGooaM5-qsCKb0wXWkya_PFMxdH-UDObmEWELXVKyLwhYn1Lg43ueJ-0rKA5broA1Zp_0pFQjy1rNA15Xpcm_V-XVdAzriRlTfNp0eaSnKc2vbSayOXdNBo02VZV7faWxFtsh9ot-tDrYXQD4YM63iHuRlX88tnPkp9ANpFVlrnUP_-eA8aY2pe-waJUmlfwjeYiKfgdwaw ";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzQ0NDA3MTkwLCJpYXQiOjE3NDQzMjA3OTAsImp0aSI6Ijk1M2Q1NjE0LWQ5MGQtNGMxOS04OTU0LTdhMGI0YzZjYmNkZSJ9.wZMpfHxDK4sIIeGiQ1Nye_DYpH3CaAO23sM1PujZDb8pwu-eVv1piPyQVR4lxdduoMzo3ORQ5pAxo9CxLVibWZIJUWNEzaM_RfIICdLcYQ3Fi5nSIs1KxpOxVtkHLacBtommvu-KfJ7ginOWcLTbtZ2V1bHzpvzYII4T6IwNoK73HhVfWhDHA8uxCFuuloJ2LiDeaf4dHYfMUrR38mS68Z0sSotX2tZhMMtmnNNIS1hHQNFJi7YGpStUNoo_pOT36H9SxYf8CD1d6S3TuSvavNiAlST43N4PrbaBPHdaajG_4_GO-B6LJI8Fs9mb_jdOy0G-r4FySDAbr0CEVGfojw ";
    
    @Test
    public void createTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Joelson", "joelson@gmail.com", "984.487.142-84", 1, LocalDate.parse("1970-02-13"), telefone, "Atendente", "joelson.pereira");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionario")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("Joelson"));

           
    }

    @Test
    public void updateTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Cleiton", "cleiton@gmail.com", "984.487.123-84", 1, LocalDate.parse("1970-02-13"), telefone, "Atendente", "cleiton.oliveira");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/funcionario/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){

        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
                .get("/funcionario")
            .then()
                .statusCode(200)
                .body("funcionario.nome", everyItem(is("Rafael")));
    }

    @Test
    public void findByIdTest(){

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/funcionario/1")
            .then()
            .statusCode(200)
            .body("idFuncionario", is(1));
    }

    @Test
    public void findByCargoTest(){

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/funcionario/search/cargo/Vendedor")
            .then()
            .statusCode(200)
            .body("cargo", everyItem(is("Vendedor")));  
    
    }

    @Test
     public void deleteTest(){

         given()
         .header("Authorization", "Bearer " + tokenFuncionario)
         .when()
         .pathParam("id", 2)
             .delete("/funcionario/{id}")
         .then()
             .statusCode(204);
     
    }
}
