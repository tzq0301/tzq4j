package cn.tzq0301.collection.entity;

import cn.tzq0301.collection.util.StringUtils;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HuffmanTreeTest {
    static Map<Character, Integer> map;
    static HuffmanTree huffman;

    @BeforeAll
    static void beforeAll() {
        // map = new HashMap<>();
        // map.put('A', 2);
        // map.put('B', 3);
        // map.put('C', 5);
        // map.put('D', 7);
        // map.put('E', 11);
        // map.put('F', 13);
        // map.put('G', 17);
        // map.put('H', 19);
        // map.put('I', 23);
        // map.put('J', 31);
        // map.put('K', 37);
        // map.put('L', 41);
        //
        // huffman = new HuffmanTree(map);

        List<Character> keys = Lists.charactersOf(StringUtils.generateSequentialAlphas('A', 'L'));
        List<Integer> values = Lists.newArrayList(2, 3, 5, 7, 11, 13, 17, 19, 23, 31, 37, 41);
        huffman = new HuffmanTree(keys, values);

        // map = MapUtils.newImmutableHashMap(keys, values);
        // huffman = new HuffmanTree(map);
    }

    @Test
    void totalBitsUsed() {
        assertEquals(676, huffman.totalBitsUsed());
    }

    @Test
    void test() {

    }
}