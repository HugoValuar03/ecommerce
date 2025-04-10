package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FuncionarioResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTk3NTcyNSwiaWF0IjoxNzE5ODg5MzI1LCJqdGkiOiI5NDBlNmI4OC1iYWViLTRiM2MtYWMzOC1iOTI4NGUyOTRjYzkifQ.Abl5SP3p_8eHU2VmhR6LPBCujJufoJw6jqJEoxX0KyZqxmR74ewLGUHxb-x98REHOuqTNZbUobI4Edbrzf3mGGYFnOgZ335hKTwb0UP10E9pzLd1o8rhXxfUMCmjxc2bdX56ibezo2FgsARyQ_ywIdFlNmFQbEpVQE1i1xnGkshFhBMUSAwfCQPEBM3t8k-rjpUlqjLioiIiH7evONqI0fev7ikQzYb8Cx0BOVtpsp6vuKw-QDjTQtLEXwx3xFOfwtDSXK2f5_Lzn7mdeVysP3RoGv3dA8QZId5gi7pNbYHy2gu3-nqw7CNhgnASAXeItQxlGNusA5aRTF_gDKpsMw";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzE5OTc1ODE5LCJpYXQiOjE3MTk4ODk0MTksImp0aSI6IjQ3Y2VhM2I1LWRlMTYtNDAxMi04YjlkLTU2MDIxYWZhNWMzZSJ9.d_6yl6YzPpupUQoJ8wghR--NepBpZ9mbBQKx3i-JxGM0qbfiNqSf-1so8oqI26c53m4p1-CQ-Msu7dfNvEepcnsF4BGdcLNWuumtkdO31ZX4hZbtMrClXmLrgABVbazpLn_q0O05jxTdf34QSvQYDLC6zphtekguY7Zv04Lg1W8SHgGLMCY4G23UC905GazmApwluklmEKXz84ARRxWklGi-WkwRGej9ru4eF3G_wEcT-40-mUg9mPlRCmrA4J-uN4gfF35yur7970fAkGrqHqty7NQ9ssLia4RlxpmsqQC9K1E07y1P90YDLXAjaxw7xYKLOtFxWHkpGycZEijudg";
    
    @Test
    public void createTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Joelson", "joelson@gmail.com", "984.487.142-84", 1, LocalDate.parse("1970-02-13"), telefone, "Atendente", "joelson.pereira");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionario")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("Joelson"));

           
    }

    @Test
    public void updateTest(){

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Cleiton", "cleiton@gmail.com", "984.487.123-84", 1, LocalDate.parse("1970-02-13"), telefone, "Atendente", "cleiton.oliveira");

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/funcionario/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){

        given()
        .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
                .get("/funcionario")
            .then()
                .statusCode(200)
                .body("funcionario.nome", everyItem(is("Rafael")));
    }

    @Test
    public void findByIdTest(){

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/funcionario/1")
            .then()
            .statusCode(200)
            .body("idFuncionario", is(1));
    }

    @Test
    public void findByCargoTest(){

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/funcionario/search/cargo/Vendedor")
            .then()
            .statusCode(200)
            .body("cargo", everyItem(is("Vendedor")));  
    
    }

    @Test
     public void deleteTest(){

         given()
         .header("Authorization", "Bearer " + tokenFuncionario)
         .when()
         .pathParam("id", 2)
             .delete("/funcionario/{id}")
         .then()
             .statusCode(204);
     
    }
}
