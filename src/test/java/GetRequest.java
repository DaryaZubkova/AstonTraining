import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class GetRequest {
    @Test
    public void testGetRequest() {
        RestAssured
                .given()
                .log().all()
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com/get"))
                .body("headers.'x-request-start'", notNullValue())
                .body("headers.'x-amzn-trace-id'", notNullValue())
                .body("headers.'user-agent'", notNullValue());
    }
}