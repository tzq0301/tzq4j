package tzq0301.collection.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanTreeTest {
    static Map<Character, Integer> map;
    static HuffmanTree huffman;

    @BeforeAll
    static void beforeAll() {
        map = new HashMap<>();
        map.put('A', 2);
        map.put('B', 3);
        map.put('C', 5);
        map.put('D', 7);
        map.put('E', 11);
        map.put('F', 13);
        map.put('G', 17);
        map.put('H', 19);
        map.put('I', 23);
        map.put('J', 31);
        map.put('K', 37);
        map.put('L', 41);

        huffman = new HuffmanTree(map);
    }

    @Test
    void totalBitsUsed() {
        assertEquals(676, huffman.totalBitsUsed());
    }
}