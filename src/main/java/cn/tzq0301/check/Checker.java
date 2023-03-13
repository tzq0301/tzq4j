package cn.tzq0301.check;

import lombok.SneakyThrows;

import java.util.Arrays;

public class Checker {
    public static void check(Condition... conditions) {
        Arrays.stream(conditions).forEach(Runnable::run);
    }

    public static Condition notNull(Object o) {
        return () -> ifThenThrow(o == null, new NullPointerException());
    }

    public static Condition shouldBeTrue(boolean expression) {
        return () -> ifThenThrow(!expression, new IllegalArgumentException());
    }

    public static Condition shouldBeTrue(boolean expression, String format, Object... args) {
        return () -> ifThenThrow(!expression, new IllegalArgumentException(String.format(format, args)));
    }

    @SneakyThrows
    private static void ifThenThrow(boolean expression, RuntimeException e) {
        if (expression) {
            throw e;
        }
    }
}
