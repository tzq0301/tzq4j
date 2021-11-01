package tzq0301.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TZQ
 * @Description 统一返回体
 */
@Data
public final class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 4957427457961203103L;

    private final int code;
    private final T data;
    private final String message;

    public CommonResult(T data, int code, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> CommonResult<T> success() {
        return success(null);
    }

    public static <T> CommonResult<T> success(T data) {
        return success(data, ResponseCode.SUCCESS.getMessage());
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(data, ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> CommonResult<T> error() {
        return error(null);
    }

    public static <T> CommonResult<T> error(T data) {
        return error(data, ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
    }

    public static <T> CommonResult<T> error(T data, String message) {
        return error(data, ResponseCode.ERROR.getCode(), message);
    }

    public static <T> CommonResult<T> error(T data, int code, String message) {
        return new CommonResult<>(data, code, message);
    }

    public static <T> CommonResult<T> error(T data, ResponseCode code, String message) {
        return error(data, code.getCode(), message);
    }
}
