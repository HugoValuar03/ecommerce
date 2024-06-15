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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 1)
            .delete("/fornecedores/{id}")
            .then()
            .statusCode(204);
    }
}
