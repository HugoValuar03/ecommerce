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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 1)
            .delete("/fornecedores/{id}")
            .then()
            .statusCode(204);
    }
}
