package br.unitins.topicos1.resource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDQwNzMzOSwiaWF0IjoxNzQ0MzIwOTM5LCJqdGkiOiIwZmE5ODUwMi05N2RiLTQ3NWYtYmIxNy1mZDY5NGQ5NjAwMDkifQ.gRoNgAzh5MZ74LpDRR2ATvt83sSGQ-UXtLxscq5j0jSjQNQIWFx2jz0o6Kdu61PD30aVYk09kka0xIfnJR_fJRMedAM5vmHBKq_g9JoGfvDUoKrhc0bVTfbPQHhDVGsWAMLKGMOQrQxzGooaM5-qsCKb0wXWkya_PFMxdH-UDObmEWELXVKyLwhYn1Lg43ueJ-0rKA5broA1Zp_0pFQjy1rNA15Xpcm_V-XVdAzriRlTfNp0eaSnKc2vbSayOXdNBo02VZV7faWxFtsh9ot-tDrYXQD4YM63iHuRlX88tnPkp9ANpFVlrnUP_-eA8aY2pe-waJUmlfwjeYiKfgdwaw ";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzQ0NDA3MTkwLCJpYXQiOjE3NDQzMjA3OTAsImp0aSI6Ijk1M2Q1NjE0LWQ5MGQtNGMxOS04OTU0LTdhMGI0YzZjYmNkZSJ9.wZMpfHxDK4sIIeGiQ1Nye_DYpH3CaAO23sM1PujZDb8pwu-eVv1piPyQVR4lxdduoMzo3ORQ5pAxo9CxLVibWZIJUWNEzaM_RfIICdLcYQ3Fi5nSIs1KxpOxVtkHLacBtommvu-KfJ7ginOWcLTbtZ2V1bHzpvzYII4T6IwNoK73HhVfWhDHA8uxCFuuloJ2LiDeaf4dHYfMUrR38mS68Z0sSotX2tZhMMtmnNNIS1hHQNFJi7YGpStUNoo_pOT36H9SxYf8CD1d6S3TuSvavNiAlST43N4PrbaBPHdaajG_4_GO-B6LJI8Fs9mb_jdOy0G-r4FySDAbr0CEVGfojw ";
   
    @Test
     public void createTest(){

        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT99", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("Wi-fi", "24mp", true, true, "IPS", "12000", true, 3, produto);

         given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(camera)
         .when()
             .post("/camera")
         .then() 
             .statusCode(201)
             .body("resolucao", equalTo("24mp"));
     }  

     @Test
     public void updateTest(){        
        
        MarcaDTO marca = new MarcaDTO("Canon");

        ProdutoDTO produto = new ProdutoDTO("CanonT6", 4500.00, "metal", "10x10x8", marca, 2L);

        CameraDTO camera = new CameraDTO("5G", "24mp", true, true, "IPS", "12000", true, 3, produto);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
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
        
        given()
            .header("Authorization", "Bearer " + tokenCliente)
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/camera")
        .then()
            .statusCode(200)
            .body("resolucao", hasItem(is("24mp")));
     }

    @Test
    public void findByIdTest(){
        
        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/camera/3")
            .then()
            .statusCode(200)
            .body("id", is(3)); 
    }

    @Test
    public void findByMarcaTest(){

        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
        .header("Authorization", "Bearer " + tokenCliente)
        .when()
            .get("/camera/search/marca/Canon")
        .then()
            .statusCode(200)
            .body("marca.marca", everyItem(is("Canon")));
     }

    @Test
    public void deleteTest(){
     
        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
        .when()
        .pathParam("id", 1)
        .delete("/camera/{id}")
        .then()
        .statusCode(204);
}

}
