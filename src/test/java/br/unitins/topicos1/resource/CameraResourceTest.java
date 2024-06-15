package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CameraResourceTest {
   
     @Test
     public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

        MarcaDTO marca = new MarcaDTO("Canon");

        CameraDTO dto = new CameraDTO("5g", "24MP", true, true, "IPS", "1200", true, 3, "Canon T6", 4500.00, "Plástico", "12x10x6", marca);

         given()
            .header("Authorization", "Bearer " + tokenAdm)
             .contentType(MediaType.APPLICATION_JSON)
             .body(dto)
         .when()
             .post("/cameras")
         .then()
             .statusCode(201)
             .body("resolucao", is("24MP"));
     }

     @Test
     public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";
        
        MarcaDTO marca = new MarcaDTO("Canon");

        CameraDTO dto = new CameraDTO("5G", "24MP", true, true, "LCD", "1400", true, 3, "Canon T6", 4500.00, "Plástico", "12x10x6", marca);

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/cameras")
            .then()
                .statusCode(200)
                .body("resolucao", hasItem(is("24MP")));
     }

    @Test
    public void buscarPeloIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
        .when()
        .pathParam("id", 3)
        .delete("/cameras/{id}")
        .then()
        .statusCode(204);
}

}
