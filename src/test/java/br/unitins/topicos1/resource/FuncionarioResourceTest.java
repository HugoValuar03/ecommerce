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
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO ("Cleiton", "cleiton@gmail.com",  "987.654.321-34", 1, LocalDate.parse("1992-03-10"), telefone, "Vendedor", "Cleiton", "123");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/funcionarios")
        .then()
            .statusCode(201)
            .body("pessoa.nome", equalTo("Cleiton"));

           
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        TelefoneDTO telefone = new TelefoneDTO("63", "987777777");

        FuncionarioDTO dto = new FuncionarioDTO("Leandro",  "leandrin@gmail.com", "98765432134", 1, LocalDate.parse("1992-03-10"), telefone, "Vendedor", "Leandro", "123");

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 1)
            .put("/funcionarios/{id}")
        .then()
            .statusCode(204);
    }

    @Test
     public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
        .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/funcionarios")
            .then()
                .statusCode(200)
                .body("funcionario.nome", everyItem(is("Rafael")));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/funcionarios/1")
            .then()
            .statusCode(200)
            .body("idFuncionario", is(1));
    }

    @Test
    public void findByCargoTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/funcionarios/search/cargo/Vendedor")
            .then()
            .statusCode(200)
            .body("cargo", everyItem(is("Vendedor")));  
    
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 2)
             .delete("/funcionarios/{id}")
         .then()
             .statusCode(204);
     
    }
}
