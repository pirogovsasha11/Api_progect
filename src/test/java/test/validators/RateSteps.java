package test.validators;

import io.restassured.response.Response;
import test.enums.AppCurrency;

import static io.restassured.RestAssured.given;

public class RateSteps {
    private static final String BASE_URL = "https://catalog.onliner.by/sdapi/kurs/api/bestrate";
    private static final String TYPE = "nbrb";

    public Response getRate(AppCurrency currency) {
        return given()
                .log().all()
                .queryParam("currency", currency.getCode())
                .queryParam("type", TYPE)
                .when()
                .get(BASE_URL)
                .then().log().all()
                .extract().response();
    }
}
