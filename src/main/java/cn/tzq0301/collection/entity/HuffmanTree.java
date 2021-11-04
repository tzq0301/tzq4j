package cn.tzq0301.collection.entity;

import cn.tzq0301.collection.util.MapUtils;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

/**
 * @author TZQ
 */
public final class HuffmanTree {
    private final HuffmanNode root;
    private final Map<Character, Integer> characterCountMap;
    private final Map<Character, String> huffmanEncoding;

    public HuffmanTree(List<Character> keys, List<Integer> values) {
        this(MapUtils.newImmutableHashMap(keys, values));
    }

    public HuffmanTree(Map<Character, Integer> characterCountMap) {
        this.characterCountMap = characterCountMap;
        this.root = buildHuffmanTree(this.characterCountMap);
        this.huffmanEncoding = computeHuffmanEncoding();
    }

    private HuffmanNode buildHuffmanTree(Map<Character, Integer> characterCountMap) {
        synchronized (HuffmanTree.class) {
            if (root != null) {
                return root;
            }
        }

        if (characterCountMap.isEmpty()) {
            throw new RuntimeException("CharSet cannot be empty!");
        }

        // Min-Heap
        final PriorityQueue<HuffmanNode> heap = new PriorityQueue<>(
                Comparator.comparingInt(HuffmanNode::getFrequency));
        characterCountMap.forEach((letter, frequency) -> heap.offer(new HuffmanNode(letter, frequency)));

        HuffmanNode node1 = null, node2 = null;
        while (heap.size() > 1) {
            node1 = Objects.requireNonNull(heap.poll());
            node2 = Objects.requireNonNull(heap.poll());
            heap.offer(new HuffmanNode(node1.getFrequency() + node2.getFrequency(), node1, node2));
        }

        return heap.poll();
    }

    private Map<Character, String> computeHuffmanEncoding() {
        synchronized (HuffmanTree.class) {
            if (huffmanEncoding != null) {
                return huffmanEncoding;
            }
        }

        Map<Character, String> huffmanEncoding = new HashMap<>();
        computeHuffmanEncodingHelper(huffmanEncoding, this.root, "");
        return huffmanEncoding;
    }

    private void computeHuffmanEncodingHelper(Map<Character, String> huffmanEncoding, HuffmanNode node, String encode) {
        if (node.isLeaf()) {
            huffmanEncoding.put(node.getLetter(), encode);
            return;
        }

        computeHuffmanEncodingHelper(huffmanEncoding, node.getLeftChild(), encode + '0');
        computeHuffmanEncodingHelper(huffmanEncoding, node.getRightChild(), encode + '1');
    }

    public void printHuffmanEncoding() {
        System.out.println("Huffman:");
        this.huffmanEncoding.forEach((k, v) -> System.out.println("\t" + k + " -> " + v));
        System.out.println();
    }

    public int totalBitsUsed() {
        int totalBitsUsed = 0;
        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            Character letter = entry.getKey();
            Integer frequency = entry.getValue();
            totalBitsUsed += frequency * this.huffmanEncoding.get(letter).length();
        }
        return totalBitsUsed;
    }

    public double averageBitsUsed() {
        int totalBitsUsed = totalBitsUsed();
        return (double) totalBitsUsed / this.characterCountMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    private static class HuffmanNode {
        private final char letter;
        private final int frequency;
        private final boolean isLeaf;

        private final HuffmanNode leftChild;

        private final HuffmanNode rightChild;

        public HuffmanNode(int value, HuffmanNode leftChild, HuffmanNode rightChild) {
            this.letter = '\0';
            this.frequency = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.isLeaf = false;
        }

        public HuffmanNode(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
            this.leftChild = null;
            this.rightChild = null;
            this.isLeaf = true;
        }

        public int getFrequency() {
            return frequency;
        }

        public HuffmanNode getLeftChild() {
            return leftChild;
        }

        public HuffmanNode getRightChild() {
            return rightChild;
        }

        public char getLetter() {
            return letter;
        }

        public boolean isLeaf() {
            return isLeaf;
        }
    }

}
