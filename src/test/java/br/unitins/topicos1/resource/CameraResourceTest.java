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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

         CameraDTO dto = new CameraDTO("Canon EAS", "24mp", true, true, "LCD", "300-24000", true, 5, "Canon T6i", 5000.00, "Plastico", "10x20x30cm", 1L);

         given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";
        
        CameraDTO dto = new CameraDTO("Canon EOS", "24mp", true, true, "LCD", "ISO 300-4500", false, 4, "Canon EF EOS", 4500.00, "metal", "10x15x13cm", 1L);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/cameras")
            .then()
                .statusCode(200)
                .body("resolucao", hasItem(is("24mp")));
     }

    @Test
    public void buscarPeloIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/cameras/2")
            .then()
            .statusCode(200)
            .body("id", is(2));
    }

    @Test
    public void findByMarcaTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
        .when()
            .get("/cameras/search/marca/Canon")
        .then()
            .statusCode(200)
            .body("marca.marca", everyItem(is("Canon")));
     }

    @Test
    public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
        .when()
        .pathParam("id", 3)
        .delete("/cameras/{id}")
        .then()
        .statusCode(204);
}

}
