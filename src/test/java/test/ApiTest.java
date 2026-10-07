package test;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.enums.AppCurrency;
import test.enums.StatusCode;
import test.validators.RateSteps;
import test.validators.RateValidator;

public class ApiTest {
    private final RateSteps steps = new RateSteps();
    private final RateValidator validator = new RateValidator();


    @DataProvider(name = "currencies")
    public Object[][] currencies() {
        return new Object[][]{
                {AppCurrency.USD},
                {AppCurrency.EURO},
                {AppCurrency.RUB}
        };
    }

    @Test(dataProvider = "currencies")
    public void checkRates(AppCurrency currency) {
        Response response = steps.getRate(currency);
        validator.validateSchema(response, StatusCode.OK);
        validator.validateHeaders(response);
        validator.validateHasKeys(response);
    }
}
