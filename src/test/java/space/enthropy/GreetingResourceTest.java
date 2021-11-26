package space.enthropy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("q/graphql-ui/?operationName=allUniverses&query=query%20allUniverses%20%7B%0A%20%20%20%20allUniverses%20%7B%0A%20%20%20%20title%0A%20%20%20%20created%0A%20%20%20%20blackHoleEntry%0A%20%20%20%20interstellarIdentifier%0A%20%20%20%20timeline%0A%20%20%20%20%7D%0A%7D")
          .then()
             .statusCode(200);
    }
}