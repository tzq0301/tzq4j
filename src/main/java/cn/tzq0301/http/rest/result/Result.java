package cn.tzq0301.http.rest.result;

import io.micrometer.common.util.StringUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import static cn.tzq0301.http.rest.result.ResultCodeEnum.SUCCESS;
import static com.google.common.base.Preconditions.checkArgument;

public record Result<T>(@NonNull String code, @NonNull String message, @Nullable T data) {
    public Result {
        checkArgument(StringUtils.isNotBlank(code));
        checkArgument(StringUtils.isNotBlank(message));
    }

    public static Result<?> success() {
        return new Result<>(SUCCESS.getCode(), SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(@Nullable T data) {
        return new Result<>(SUCCESS.getCode(), SUCCESS.getMessage(), data);
    }

    public static Result<?> error(ResultCodeEnum resultCodeEnum) {
        return new Result<>(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), null);
    }

    public static Result<?> error(ResultCodeEnum resultCodeEnum, String message) {
        return new Result<>(resultCodeEnum.getCode(), message, null);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum, T data) {
        return new Result<>(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum, String message, T data) {
        return new Result<>(resultCodeEnum.getCode(), message, data);
    }
}
