import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PostFormData {
    @Test
    public void testPostFormData() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");

        RestAssured
                .given()
                .log().all()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formParams)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'content-type'", containsString("application/x-www-form-urlencoded"));
    }
}