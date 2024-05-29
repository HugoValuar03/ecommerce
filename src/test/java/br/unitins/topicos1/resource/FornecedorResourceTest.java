package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FornecedorResourceTest {
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        TelefoneDTO telefone = new TelefoneDTO("63", "125487");

        FornecedorDTO dto = new FornecedorDTO(
        "Americanas", 
        "Rua das flores", 
        "americanas@gmail.com", 
        telefone, 
        "123456789456123");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/fornecedores")
        .then()
            .statusCode(201)
            .body("nome", is("Americanas"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");
        FornecedorDTO dto = new FornecedorDTO(
            "Gigante", 
            "Rua das flores", 
            "gigante@gmail.com", 
            telefone, 
            "123456789456123"
        );

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/fornecedores/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Kabum", "Gigante"));
    }
    
    @Test
    public void findById(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores/search/nome/Americanas")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Americanas")));    
    } 

    @Test
    public void findByCnpj(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedores/search/cnpj/72227573000163")
            .then()
            .statusCode(200)
            .body("cnpj", everyItem(is("72227573000163"))); 
    }

    @Test
    public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE3MDMzMTgxLCJpYXQiOjE3MTY5NDY3ODEsImp0aSI6IjIwOWIwYWI0LWEzZjAtNDhiMy05ODJhLTAyYmE3MzU0YTVlZCJ9.H5hoRRlBELtHX6LYvDwCNAZNmCn5Idb_cwgCCF6ZxRpPGyTA7RM9mE2abJY6LcISW4no2inmJGadCb21mhE7m35hYwJxAzUEJ1m7f52fKPt3BL2buZTDHWgFy81gl-zG8Hi-OSjB-AsHz1AL7lkOYsWQgmvyq2WARE7TgobS3agHnwEjZa5iPFGereb6ZX1togonIHzikFNaUS0RtaAv17N65cO6clZ2o3o_HuvNXGHgykshqmoQUGuDzfOMrSwewqhaqud7O674sVjxQ-2nmflJ0YQK7O9XHPRteD76pIE7fgyHNqSVX4PplYSY5HTG3VFanpxIfqGocqONLR41Vw ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 1)
            .delete("/fornecedores/{id}")
            .then()
            .statusCode(204);
    }
}
