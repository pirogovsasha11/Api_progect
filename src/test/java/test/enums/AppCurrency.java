package test.enums;

public enum AppCurrency {
    RUB("RUB"),
    USD("USD"),
    EURO("EUR");
    private final String code;

    AppCurrency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
