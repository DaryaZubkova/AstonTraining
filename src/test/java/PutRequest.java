import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class PutRequest {
    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured
                .given()
                .log().all()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo(requestBody))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'content-type'", containsString("text/plain"))
                .body("headers.'user-agent'", notNullValue());
    }
}