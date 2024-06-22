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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

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
            .post("/fornecedor")
        .then()
            .statusCode(201)
            .body("nome", is("Americanas"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

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
            .put("/fornecedor/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedor")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Kabum", "Gigante"));
    }
    
    @Test
    public void findById(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedor/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedor/search/nome/Americanas")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Americanas")));    
    } 

    @Test
    public void findByCnpj(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/fornecedor/search/cnpj/72227573000163")
            .then()
            .statusCode(200)
            .body("cnpj", everyItem(is("72227573000163"))); 
    }

    @Test
    public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 1)
            .delete("/fornecedor/{id}")
            .then()
            .statusCode(204);
    }
}
