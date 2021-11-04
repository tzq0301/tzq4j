package cn.tzq0301.result;

public enum ResponseCode {
    SUCCESS(1, "Success"),
    ERROR(2, "Error"),
    ILLEGAL_ARGUMENT(3, "Illegal argument");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
