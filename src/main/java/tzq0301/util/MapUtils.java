package tzq0301.util;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author TZQ
 */
public final class MapUtils {
    public static <K, V> void printMap(Map<K, V> map) {
        printMap(map, "");
    }

    public static <K, V> void printMap(Map<K, V> map, String nameOfMap) {
        if (Strings.isNullOrEmpty(nameOfMap)) {
            nameOfMap = "Map";
        }
        StringBuilder info = new StringBuilder().append("\n").append(nameOfMap).append(": \n");
        map.forEach((k, v) -> info.append("\t").append(k).append(" -> ").append(v).append("\n"));
        info.append("\n");

        System.out.println(info);
    }
}
