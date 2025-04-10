package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LenteDTO;
import br.unitins.topicos1.dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTest {

    String tokenFuncionario = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo0LCJzdWIiOiJyYWZhZWwuc29hcmVzIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxOTk3NTcyNSwiaWF0IjoxNzE5ODg5MzI1LCJqdGkiOiI5NDBlNmI4OC1iYWViLTRiM2MtYWMzOC1iOTI4NGUyOTRjYzkifQ.Abl5SP3p_8eHU2VmhR6LPBCujJufoJw6jqJEoxX0KyZqxmR74ewLGUHxb-x98REHOuqTNZbUobI4Edbrzf3mGGYFnOgZ335hKTwb0UP10E9pzLd1o8rhXxfUMCmjxc2bdX56ibezo2FgsARyQ_ywIdFlNmFQbEpVQE1i1xnGkshFhBMUSAwfCQPEBM3t8k-rjpUlqjLioiIiH7evONqI0fev7ikQzYb8Cx0BOVtpsp6vuKw-QDjTQtLEXwx3xFOfwtDSXK2f5_Lzn7mdeVysP3RoGv3dA8QZId5gi7pNbYHy2gu3-nqw7CNhgnASAXeItQxlGNusA5aRTF_gDKpsMw";

    String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJqb2FvLmdvbWVzIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzE5OTc1ODE5LCJpYXQiOjE3MTk4ODk0MTksImp0aSI6IjQ3Y2VhM2I1LWRlMTYtNDAxMi04YjlkLTU2MDIxYWZhNWMzZSJ9.d_6yl6YzPpupUQoJ8wghR--NepBpZ9mbBQKx3i-JxGM0qbfiNqSf-1so8oqI26c53m4p1-CQ-Msu7dfNvEepcnsF4BGdcLNWuumtkdO31ZX4hZbtMrClXmLrgABVbazpLn_q0O05jxTdf34QSvQYDLC6zphtekguY7Zv04Lg1W8SHgGLMCY4G23UC905GazmApwluklmEKXz84ARRxWklGi-WkwRGej9ru4eF3G_wEcT-40-mUg9mPlRCmrA4J-uN4gfF35yur7970fAkGrqHqty7NQ9ssLia4RlxpmsqQC9K1E07y1P90YDLXAjaxw7xYKLOtFxWHkpGycZEijudg";
    
    @Test
    public void createTest(){
        
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon DSLR", 10, 13, "FE", "Lente 45mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/lente")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon DSLR"));
    }

    @Test
    public void updateTest(){
        
        MarcaDTO marca = new MarcaDTO("Canon");

        LenteDTO dto = new LenteDTO("Canon", 10, 13, "FE", "Lente 50mm", 4500.00, "Metal", "10x12x8", marca);

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/lente/{id}")
        .then()
            .statusCode(204); 
    }


    @Test
    public void findAllTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .header("Authorization", "Bearer " + tokenCliente)
            .when()
                .get("/lente")
            .then()
                .statusCode(200)
                .body("montagem", hasItem("EF"));
    }

    @Test
    public void findByIdTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/lente/4")
            .then()
            .statusCode(200)
            .body("id", is(4));
    }

    @Test
    public void findByMontagemTest(){
        

        given()
            .header("Authorization", "Bearer " + tokenFuncionario)
            .when()
            .get("/lente/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        

         given()
         .header("Authorization", "Bearer " + tokenFuncionario)
         .when()
         .pathParam("id", 3)
             .delete("/lente/{id}")
         .then()
             .statusCode(204);
     }
}
