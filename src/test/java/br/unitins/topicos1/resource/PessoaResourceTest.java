package br.unitins.topicos1.resource;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PessoaResourceTest {
    
    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/pessoas")
            .then()
                .statusCode(200)
                .body("nome", hasItem(is("Felipe")));
    }

    @Test
    public void findByNomeTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/pessoas/search/nome/Rafael")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Rafael")));  
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/pessoas/2")
            .then()
            .statusCode(200)
            .body("id", is(2));
    }

    @Test
    public void updateTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        TelefoneDTO telefone = new TelefoneDTO("55", "987731477");

        PessoaDTO dto = new PessoaDTO("Leonardo", "leonardo@gmail.com", "01923124123", 1, LocalDate.parse("2005-05-12"), telefone);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/pessoas/{id}")
        .then()
            .statusCode(204);
  
    }

    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        TelefoneDTO telefone = new TelefoneDTO("41", "987231277");

        PessoaDTO dto = new PessoaDTO("Paula", "paula@gmail.com",  "01832865798", 2, LocalDate.parse("2002-01-10"), telefone);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/pessoas")
        .then()
            .statusCode(201)
            .body("nome", is("Paula"));
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 5)
             .delete("/pessoas/{id}")
         .then()
             .statusCode(204);
     }

}
