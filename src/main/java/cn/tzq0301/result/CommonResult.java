package cn.tzq0301.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TZQ
 * @Description 在Spring MVC的Controller层（或其他框架的、与前端接口交互的模块）中作为统一返回的对象
 *
 * <p>CommonResult由data（数据）、code（状态码）与message（信息）组成</p>
 * <ul>
 *     <li>data（数据）：任意类型的数据（CommonResult基于范型实现）</li>
 *     <li>code（状态码）：一个int（整型）类型的值，可以自己指定，也可以使用{@link cn.tzq0301.result.ResponseCode}中预提供的值</li>
 *     <li>message（信息）：用于传递成功/失败的信息</li>
 * </ul>
 *
 * <p>CommonResult重载了多个方法，为创建CommonResult提供了便利</p>
 *
 */
@Data
public final class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 4957427457961203103L;

    private final T data;
    private final int code;
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

    public static <T> CommonResult<T> success(T data, ResponseCode code) {
        return new CommonResult<>(data, code.getCode(), code.getMessage());
    }

    public static <T> CommonResult<T> success(T data, int code, String message) {
        return new CommonResult<>(data, code, message);
    }

    public static <T> CommonResult<T> success(T data, ResponseCode code, String message) {
        return success(data, code.getCode(), message);
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
