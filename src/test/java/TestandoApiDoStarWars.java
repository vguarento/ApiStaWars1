import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestandoApiDoStarWars {

    @Test
    public void teste1(){

    given()
        .log().all()
        .contentType(ContentType.JSON)

    .when()
        .get("https://swapi.dev/api/people/1/")

    .then()
        .log().all()
        .statusCode(200)
        .body("name", Matchers.is("Luke Skywalker"))
        .body("height", Matchers.is("172"))
        .body("mass", Matchers.is("77"));
    }

    @Test
    public void teste2(){

        given()
                .log().all()
                .contentType(ContentType.JSON)

        .when()
                .get("https://swapi.dev/api/people/100/")

        .then()
                .log().all()
                .statusCode(404)
                .body("detail", Matchers.is("Not found"));

    }

}
