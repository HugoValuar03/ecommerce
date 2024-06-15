package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.PessoaUpdateEmailDTO;
import br.unitins.topicos1.dto.PessoaUpdateNomeDTO;
import br.unitins.topicos1.dto.PessoaUpdateSenhaDTO;
import br.unitins.topicos1.dto.PessoaUpdateUsernameDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PedidoResourceTest {
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

        MarcaDTO marca = new MarcaDTO("Sony");

        ProdutoDTO produto = new ProdutoDTO("Canon T6", 3400.00, "Plástico", "10x5x8", marca, 1L);

        ItemPedidoDTO itemPedido = new ItemPedidoDTO(produto, 2, 1L);

        PedidoDTO pedido = new PedidoDTO(1L,Collections.singletonList(itemPedido), produto);
    
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(pedido)
        .when()
            .post("/pedidos")
        .then()
            .statusCode(201)
            .body("marca", equalTo("Sony"));
    }

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/pedidos")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedidos/1")
            .then()
            .statusCode(200);
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IkxlYW5kcm8iLCJncm91cHMiOlsiRnVuY2lvbmFyaW8iXSwiZXhwIjoxNzE4NTE2Nzk3LCJpYXQiOjE3MTg0MzAzOTcsImp0aSI6ImFkN2Y2YTcxLTY5YmItNDVmNi05ZDI0LTk2OGM5ODQ3MmQ2MCJ9.0E3o7IbYvnAJsqXeBpalIIZG-hUoT9gLC1LLXOmftSvW4ZLqPNDAFWNrTxRSu-zVLyvGDb9QzL0WM7aWzh5wxtRArb6WAMIOah8dp-RZPMi4jTe-HgOW57fdeqiIqrpR_l3sofHUDZNHT_nCVelX_tkKyQo-Chf4buwrCysVqwP_KGO8cJrUkKCcfmkJVxFDjiIbiV8RbmNhQDEa_6xIsy4JWx-T5vN0W_cZgN0A9no6iskuexlJBz12HgpbNLYiLHW6yHe1yI2X1XCWN-EqR3G9mTIkzjtnTXMbfAVYwfQwEaZ9HIpmGYB-jSR52vH_isxbi_f4K9mybkSjjQ1YiA ";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 2)
             .delete("/pedidos/{id}")
         .then()
             .statusCode(204);
     }

}
