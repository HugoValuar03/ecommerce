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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";
        
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

        given()
        .when()
            .header("Authorization", "Bearer " + tokenAdm)
            .pathParam("id", 4)
            .delete("/marcas/{id}")
        .then()
            .statusCode(204);
    }

}
