package cn.tzq0301.collection.util;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TZQ
 */
public final class MapUtils {
    public static <K, V> Map<K, V> newHashMap(List<K> keys, List<V> values) {
        final int size = keys.size();
        if (size != values.size()) {
            throw new RuntimeException("The size of keys is not consistent with values");
        }

        Map<K, V> map = new HashMap<>(size);

        for (int i = 0; i < size; ++i) {
            if (map.containsKey(keys.get(i))) {
                throw new RuntimeException("Duplicate keys in the List `keys`");
            }
            map.put(keys.get(i), values.get(i));
        }

        return map;
    }

    public static <K, V> Map<K, V> newImmutableHashMap(List<K> keys, List<V> values) {
        return ImmutableMap.copyOf(newHashMap(keys, values));
    }

    private MapUtils() {}
}
