import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteRequest {
    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured
                .given()
                .log().all()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo(requestBody))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'content-type'", containsString("text/plain"))
                .body("headers.'user-agent'", notNullValue());
    }
}