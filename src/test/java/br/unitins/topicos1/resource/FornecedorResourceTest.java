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

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTk3NTcyNSwiaWF0IjoxNzE5ODg5MzI1LCJqdGkiOiI5NDBlNmI4OC1iYWViLTRiM2MtYWMzOC1iOTI4NGUyOTRjYzkifQ.Abl5SP3p_8eHU2VmhR6LPBCujJufoJw6jqJEoxX0KyZqxmR74ewLGUHxb-x98REHOuqTNZbUobI4Edbrzf3mGGYFnOgZ335hKTwb0UP10E9pzLd1o8rhXxfUMCmjxc2bdX56ibezo2FgsARyQ_ywIdFlNmFQbEpVQE1i1xnGkshFhBMUSAwfCQPEBM3t8k-rjpUlqjLioiIiH7evONqI0fev7ikQzYb8Cx0BOVtpsp6vuKw-QDjTQtLEXwx3xFOfwtDSXK2f5_Lzn7mdeVysP3RoGv3dA8QZId5gi7pNbYHy2gu3-nqw7CNhgnASAXeItQxlGNusA5aRTF_gDKpsMw";
    
    @Test
    public void createTest(){
        

        TelefoneDTO telefone = new TelefoneDTO("63", "125487");

        FornecedorDTO dto = new FornecedorDTO(
        "Americanas", 
        "Rua das flores", 
        "americanas@gmail.com", 
        telefone, 
        "123456789456123");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/fornecedor")
        .then()
            .statusCode(201)
            .body("nome", is("Americanas"));
    }

    @Test
    public void updateTest(){
        

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");
        FornecedorDTO dto = new FornecedorDTO(
            "Gigante", 
            "Rua das flores", 
            "gigante@gmail.com", 
            telefone, 
            "123456789456123"
        );

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/fornecedor/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void findAllTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/fornecedor")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Kabum", "Gigante"));
    }
    
    @Test
    public void findById(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/fornecedor/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/fornecedor/search/nome/Americanas")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Americanas")));    
    } 

    @Test
    public void findByCnpj(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/fornecedor/search/cnpj/72227573000163")
            .then()
            .statusCode(200)
            .body("cnpj", everyItem(is("72227573000163"))); 
    }

    @Test
    public void deleteTest(){
        
        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .pathParam("id", 1)
            .delete("/fornecedor/{id}")
            .then()
            .statusCode(204);
    }
}
