package cn.tzq0301.collection.util;

/**
 * @author TZQ
 */
public final class CharUtils {
    public static boolean validChar(int ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isUpperCase(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    private CharUtils() {}
}
