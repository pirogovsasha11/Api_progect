package test.enums;

public enum StatusCode {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204);
    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getStatusCode() {
        return code;
    }
}
