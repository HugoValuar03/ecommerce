package br.unitins.topicos1.resource;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FornecedorResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTc0NDQwNzMzOSwiaWF0IjoxNzQ0MzIwOTM5LCJqdGkiOiIwZmE5ODUwMi05N2RiLTQ3NWYtYmIxNy1mZDY5NGQ5NjAwMDkifQ.gRoNgAzh5MZ74LpDRR2ATvt83sSGQ-UXtLxscq5j0jSjQNQIWFx2jz0o6Kdu61PD30aVYk09kka0xIfnJR_fJRMedAM5vmHBKq_g9JoGfvDUoKrhc0bVTfbPQHhDVGsWAMLKGMOQrQxzGooaM5-qsCKb0wXWkya_PFMxdH-UDObmEWELXVKyLwhYn1Lg43ueJ-0rKA5broA1Zp_0pFQjy1rNA15Xpcm_V-XVdAzriRlTfNp0eaSnKc2vbSayOXdNBo02VZV7faWxFtsh9ot-tDrYXQD4YM63iHuRlX88tnPkp9ANpFVlrnUP_-eA8aY2pe-waJUmlfwjeYiKfgdwaw ";
    
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
