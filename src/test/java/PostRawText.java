import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class PostRawText {
    @Test
    public void testPostRawText() {
        String requestBody = "{\"test\": \"value\"}";

        RestAssured
                .given()
                .log().all()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo(requestBody))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.'content-type'", containsString("text/plain"));
    }
}