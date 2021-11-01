package tzq0301.util;

import org.junit.jupiter.api.Test;
import tzq0301.collection.util.MapUtils;

import java.util.HashMap;
import java.util.Map;

class MapUtilsTest {

    @Test
    void printMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        MapUtils.printMap(map);
    }

    @Test
    void testPrintMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        MapUtils.printMap(map, "HashMap");
    }
}