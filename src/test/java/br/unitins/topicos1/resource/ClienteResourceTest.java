package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ClienteResourceTest {
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");

        ClienteDTO dto = new ClienteDTO("João", "joao@gmail.com",  "018.248.657-98", 1, LocalDate.parse("2003-03-10"), telefone, "João", "321");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/clientes")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("João"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        ClienteDTO dto = new ClienteDTO("Rafael", "rafael@gmail.com", "08015749532", 1, LocalDate.parse("2003-03-10"), telefone,"Rafael", "123");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/clientes/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";
        given()
            .header("Authorization", "Bearer " + tokenAdm)  
            .when()
                .get("/clientes")
            .then()
                .statusCode(200)
                .body("cliente.nome", everyItem(is("Ana")));
    }

    @Test
    public void findByCpf(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/clientes/search/cpf/123.456.729-12")
            .then()
            .statusCode(200)
            .body("cpf.cpf", everyItem(is("123.456.729-12"))); 
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/clientes/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";
         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 1)
             .delete("/clientes/{id}")
         .then()
             .statusCode(204);
     }
}
