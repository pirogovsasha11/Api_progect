package test.validators;

import io.restassured.response.Response;
import test.enums.StatusCode;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class RateValidator {

    public void validateSchema(Response response, StatusCode statusCode) {
        response.then()
                .statusCode(statusCode.getStatusCode())
                .body(matchesJsonSchemaInClasspath("schemas/rate_schema.json"));
    }

    public void validateHeaders(Response response) {
        response.then()
                .header("Content-Type", containsString("application/json"));
    }

    public void validateHasKeys(Response response) {
        response.then()
                .body("$", hasKey("banks"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"))
                .body("$", hasKey("delta"))
                .body("$", hasKey("amount"));
    }
}
