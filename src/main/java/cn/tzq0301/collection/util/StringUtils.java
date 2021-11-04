package cn.tzq0301.collection.util;

import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author TZQ
 */
public final class StringUtils {
    public static String generateSequentialAlphas(char start, char end) {
        if ((CharUtils.isUpperCase(start) && CharUtils.isLowerCase(end))
                || (CharUtils.isUpperCase(end) && CharUtils.isLowerCase(start))) {
            throw new IllegalArgumentException("The `start` and the `end` isn't in the same case");
        }

        return generateSequentialAlphas(start, end - start + 1);
    }

    public static String generateSequentialAlphas(char start, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The argument `length` cannot be 0!");
        }

        if (!CharUtils.validChar(start + length)) {
            throw new IllegalArgumentException("The argument `length` may be over the limit!");
        }

        return Stream.iterate(start, (Character ch) -> (char) (ch + 1))
                .limit(length)
                .collect(Collector.of(
                        StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }

    private StringUtils() {
    }
}
