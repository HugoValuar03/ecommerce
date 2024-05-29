package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MarcaResourceTest {
    
    //hasItem(): É usado para verificar se uma determinada coleção contém um item específico.
    //is(): é usado para verificar se o resultado de um teste é igual a um valor esperado. Ele pode ser usado para comparar valores simples ou objetos complexos.
    //everyItem(): é usado para verificar se todos os elementos de uma coleção atendem a determinados critérios. Ele é útil para verificar se todos os elementos de uma coleção satisfazem uma determinada condição.

    @Inject
    public MarcaService marcaService;

    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        MarcaDTO dto = new MarcaDTO("Panasonic");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/marcas")
        .then()
            .statusCode(201)
            .body("marca", equalTo("Panasonic"));
    }

    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/marcas")
            .then()
            .statusCode(200)
            .body("marca", hasItem("Canon"));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/marcas/1")
            .then()
            .statusCode(200)
            .body("idMarca", equalTo(1));
    }

    @Test
    public void findByNomeTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/marcas/search/marca/Canon")
            .then()
            .statusCode(200)
            .body("marca", everyItem(is("Canon")));  
    }

    @Test
    public void updateTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";
        
        MarcaDTO dto = new MarcaDTO("Fujifilm");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/marcas/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void deleteTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
        .when()
            .header("Authorization", "Bearer " + tokenAdm)
            .pathParam("id", 4)
            .delete("/marcas/{id}")
        .then()
            .statusCode(204);
    }

}
