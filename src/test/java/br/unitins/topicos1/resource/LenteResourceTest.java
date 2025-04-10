package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LenteDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDQwNzMzOSwiaWF0IjoxNzQ0MzIwOTM5LCJqdGkiOiIwZmE5ODUwMi05N2RiLTQ3NWYtYmIxNy1mZDY5NGQ5NjAwMDkifQ.gRoNgAzh5MZ74LpDRR2ATvt83sSGQ-UXtLxscq5j0jSjQNQIWFx2jz0o6Kdu61PD30aVYk09kka0xIfnJR_fJRMedAM5vmHBKq_g9JoGfvDUoKrhc0bVTfbPQHhDVGsWAMLKGMOQrQxzGooaM5-qsCKb0wXWkya_PFMxdH-UDObmEWELXVKyLwhYn1Lg43ueJ-0rKA5broA1Zp_0pFQjy1rNA15Xpcm_V-XVdAzriRlTfNp0eaSnKc2vbSayOXdNBo02VZV7faWxFtsh9ot-tDrYXQD4YM63iHuRlX88tnPkp9ANpFVlrnUP_-eA8aY2pe-waJUmlfwjeYiKfgdwaw ";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzQ0NDA3MTkwLCJpYXQiOjE3NDQzMjA3OTAsImp0aSI6Ijk1M2Q1NjE0LWQ5MGQtNGMxOS04OTU0LTdhMGI0YzZjYmNkZSJ9.wZMpfHxDK4sIIeGiQ1Nye_DYpH3CaAO23sM1PujZDb8pwu-eVv1piPyQVR4lxdduoMzo3ORQ5pAxo9CxLVibWZIJUWNEzaM_RfIICdLcYQ3Fi5nSIs1KxpOxVtkHLacBtommvu-KfJ7ginOWcLTbtZ2V1bHzpvzYII4T6IwNoK73HhVfWhDHA8uxCFuuloJ2LiDeaf4dHYfMUrR38mS68Z0sSotX2tZhMMtmnNNIS1hHQNFJi7YGpStUNoo_pOT36H9SxYf8CD1d6S3TuSvavNiAlST43N4PrbaBPHdaajG_4_GO-B6LJI8Fs9mb_jdOy0G-r4FySDAbr0CEVGfojw ";
    
    @Test
    public void createTest(){
        
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon DSLR", 10, 13, "FE", "Lente 45mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/lente")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon DSLR"));
    }

    @Test
    public void updateTest(){
        
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon", 10, 13, "FE", "Lente 50mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/lente/{id}")
        .then()
            .statusCode(204); 
    }


    @Test
    public void findAllTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .header("Authorization", "Bearer " + tokenCliente)
            .when()
                .get("/lente")
            .then()
                .statusCode(200)
                .body("montagem", hasItem("EF"));
    }

    @Test
    public void findByIdTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/lente/4")
            .then()
            .statusCode(200)
            .body("id", is(4));
    }

    @Test
    public void findByMontagemTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/lente/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        

         given()
         .header("Authorization", "Bearer " + tokenFuncionario)
         .when()
         .pathParam("id", 3)
             .delete("/lente/{id}")
         .then()
             .statusCode(204);
     }
}
