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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzE5MTE0NTU0LCJpYXQiOjE3MTkwMjgxNTQsImp0aSI6ImQ3MGYyZWM3LTkzNDAtNDdlNi04YmYzLTBlODVhMTY4ZjFiOSJ9.NprFF6ctg71PSjDS0J-u21jCKu8qFu2I5O6OQCDWhS9MBwjjQVDn1ievWG4CSqyEui4l2GswcEF-9NNGq8OMaX9IuBtkzIBkqw2oAZaP2BXD03UVnpXaDpXn7D_oeOXYs7B7lH6aDFpndInTmW-BkrkUdFkVH64fMLrCEM14UQzL1VoLo0GRN-0z6ts5Dt1HFjPZggZ1nFiLjkjT8QSzgKBL865B93XNKtG-RsxLfdI-WkbWIT6fecFxO726TKtiX3_J0pwD1ZmkJ4ucq4IoLYG-QoZgB0Uv6bPicKsOutb4M2fDsGIhFspb-AfDKwYxk2D2uOJliqlTLT8bfZWq3g";

        TelefoneDTO telefone = new TelefoneDTO("62", "987773277");

        ClienteDTO cliente = new ClienteDTO("Rogério", "rogerio@gmail.com", "080.231.545-41", 1, LocalDate.parse("1992-03-10"), telefone, "rogerio.soares");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(cliente)
        .when()
            .post("/cliente")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("Rogério"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzE5MTE0NTU0LCJpYXQiOjE3MTkwMjgxNTQsImp0aSI6ImQ3MGYyZWM3LTkzNDAtNDdlNi04YmYzLTBlODVhMTY4ZjFiOSJ9.NprFF6ctg71PSjDS0J-u21jCKu8qFu2I5O6OQCDWhS9MBwjjQVDn1ievWG4CSqyEui4l2GswcEF-9NNGq8OMaX9IuBtkzIBkqw2oAZaP2BXD03UVnpXaDpXn7D_oeOXYs7B7lH6aDFpndInTmW-BkrkUdFkVH64fMLrCEM14UQzL1VoLo0GRN-0z6ts5Dt1HFjPZggZ1nFiLjkjT8QSzgKBL865B93XNKtG-RsxLfdI-WkbWIT6fecFxO726TKtiX3_J0pwD1ZmkJ4ucq4IoLYG-QoZgB0Uv6bPicKsOutb4M2fDsGIhFspb-AfDKwYxk2D2uOJliqlTLT8bfZWq3g";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        ClienteDTO dto = new ClienteDTO("Rogério", "rogerio@gmail.com", "080.231.545-41", 1, LocalDate.parse("1992-03-10"), telefone, tokenAdm);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/cliente/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
        given()
            .header("Authorization", "Bearer " + tokenAdm)  
            .when()
                .get("/cliente")
            .then()
                .statusCode(200)
                .body("cliente.nome", everyItem(is("Ana")));
    }

    @Test
    public void findByCpf(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/cliente/search/cpf/123.456.729-12")
            .then()
            .statusCode(200)
            .body("cpf.cpf", everyItem(is("123.456.729-12"))); 
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTExMzkyNCwiaWF0IjoxNzE5MDI3NTI0LCJqdGkiOiI2MzQxN2EyNy1mMjJkLTRkZmUtYTFkMy00MTAwNzY5OTMzYTcifQ.fIg1172nGx1qRsbcee2ywd9g5z3sx5M3AOdaue2XDzNmQY_YOev6y1rNWj0xTrSQyLbVHJ_HjnhwHA1jtEcHo9j6A3JHjbgs5LuIowW7z8YMU34H9NB0CpyS8vVbwzq1Tejj2zUEQjwgsb7t3-5m5UbSjhyw4RNTxk1IRAOzhwngLPxeI83_QpvQYRPY_eBHqLvZ8oyeSuAz6IXO6kTGGLzJ8GJTzkPobuO2hxdse0qou8kmfDarhGA4igC20_OdMKCzdzzAEn8nDdnhtBNOtoFjcOZet7vb0aCrAeKZ1ljWi2tnkCYpfiQ5IWktJasWTCTBnG3hgXjRYRXZdLAV-g";
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/cliente/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzE5MTE0NTU0LCJpYXQiOjE3MTkwMjgxNTQsImp0aSI6ImQ3MGYyZWM3LTkzNDAtNDdlNi04YmYzLTBlODVhMTY4ZjFiOSJ9.NprFF6ctg71PSjDS0J-u21jCKu8qFu2I5O6OQCDWhS9MBwjjQVDn1ievWG4CSqyEui4l2GswcEF-9NNGq8OMaX9IuBtkzIBkqw2oAZaP2BXD03UVnpXaDpXn7D_oeOXYs7B7lH6aDFpndInTmW-BkrkUdFkVH64fMLrCEM14UQzL1VoLo0GRN-0z6ts5Dt1HFjPZggZ1nFiLjkjT8QSzgKBL865B93XNKtG-RsxLfdI-WkbWIT6fecFxO726TKtiX3_J0pwD1ZmkJ4ucq4IoLYG-QoZgB0Uv6bPicKsOutb4M2fDsGIhFspb-AfDKwYxk2D2uOJliqlTLT8bfZWq3g";
         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 1)
             .delete("/cliente/{id}")
         .then()
             .statusCode(204);
     }
}
