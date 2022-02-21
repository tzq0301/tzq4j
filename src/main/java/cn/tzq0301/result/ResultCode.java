package cn.tzq0301.result;

/**
 * 统一返回体 {@link cn.tzq0301.result.CommonResult} 中预定义的返回码
 *
 * @author tzq0301
 * @version 1.0
 */
public enum ResultCode {
    SUCCESS(0, "Success"),
    ERROR(1, "Error"),
    ILLEGAL_ARGUMENT(2, "Illegal argument");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
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
