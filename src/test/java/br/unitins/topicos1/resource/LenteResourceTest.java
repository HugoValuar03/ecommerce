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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon DSLR", 50, 55, "EF", "Lente f3,0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";
        Marca marca = new Marca(1L, "Canon");

        LentesDTO dto = new LentesDTO("Canon EOS", 50, 55, "EF", "Lente f3.0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/lentes")
            .then()
                .statusCode(200)
                .body("material", hasItem("vidro"));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lentes/2")
            .then()
            .statusCode(200)
            .body("id", hasItem(is(2)));
    }

    @Test
    public void findByLenteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lentes/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 3)
             .delete("/lentes/{id}")
         .then()
             .statusCode(204);
     }
}
