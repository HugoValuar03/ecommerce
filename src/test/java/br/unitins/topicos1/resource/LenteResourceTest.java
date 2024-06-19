package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.model.Marca;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class LenteResourceTest {
    
    @Test
    public void createTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";
        Marca marca = new Marca("Canon");

        LentesDTO dto = new LentesDTO("Canon DSLR", 50, 55, "EF", "Lente f3,0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/lentes")
        .then()
            .statusCode(201)
            .body("compatibilidade", is("Canon DSLR"));
    }

    @Test
    public void updateTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";
        Marca marca = new Marca("Canon");

        LentesDTO dto = new LentesDTO("Canon EOS", 50, 55, "EF", "Lente f3.0", 4500.00, "Metal", "10x15x12mm", marca);

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/lentes/{id}")
        .then()
            .statusCode(204); 
    }


    @Test
    public void findAllTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
                .get("/lentes")
            .then()
                .statusCode(200)
                .body("material", hasItem("vidro"));
    }

    @Test
    public void findByIdTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lentes/1")
            .then()
            .statusCode(200)
            .body("id", hasItem(is(1)));
    }

    @Test
    public void findByLenteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/lentes/search/montagem/EF")
            .then()
            .statusCode(200)
            .body("montagem", everyItem(is("EF")));  
    }

    @Test
     public void deleteTest(){
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6IlJhZmFlbCIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg4MjI2NDMsImlhdCI6MTcxODczNjI0MywianRpIjoiOWQ0Njk3MGEtZDQxNC00OWUyLTg4NDAtYzc1YjMxMGQ0NTNjIn0.YhAwe5x2YRXd3nINUxEUIQo6Kq_DSKQRY7dQPtn9h6j0cz1c3dkOR7_iciWiXdbHiM24nNZBGxnepFlAJ3B0f4XcIiCk9A7fQo1f7HlkrZpdIuAZaItgX8JytwKdatDucwyuHxcgz8VbV85KTzBXT5GwVl3YP-oP9bIe0nXzDA9Cfjf9Lsq0vAepZViQKDGRzS4tTPhl5UKdmBZYbqq0LCKUp-wWn6lyVjR_a2kVHMsGCR8l8MpXRY4khL6hIrxVEahMlvbuSK9dOEQe1UFlmSF59dM6ATTBEYdkDM9edFFv5kaOnYJIloNKGRZrhHT0iNU9NOCL2i6Jikfg40SNpg";

         given()
         .header("Authorization", "Bearer " + tokenAdm)
         .when()
         .pathParam("id", 3)
             .delete("/lentes/{id}")
         .then()
             .statusCode(204);
     }
}
