package com.jtang.datastruct;

/**
 * 可用于前缀匹配字符串，多模式匹配
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * 插入字符冲
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode parent = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (parent.getChildren(index) == null) {
                TrieNode newNode = new TrieNode(text[i]);
                parent.setChildrenValue(index, newNode);
            }
            parent = parent.getChildren(index);
        }
        parent.setEndingChar();
    }

    public boolean find(char[] pattern) {
        TrieNode parent = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (parent.getChildren(index) == null) {
                return false;
            }
            parent = parent.getChildren(index);
        }//不能完全匹配
        if (!parent.isEndingChar()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Test case
     *
     * @param args
     */
    public static void main(String[] args) {
        Trie testTrie = new Trie();
        testTrie.insert("hello".toCharArray());
        testTrie.insert("her".toCharArray());
        testTrie.insert("apple".toCharArray());
        testTrie.insert("able".toCharArray());
        testTrie.insert("history".toCharArray());
        testTrie.insert("he".toCharArray());

        if (testTrie.find("he".toCharArray())) {
            System.out.println("found");
        } else {
            System.out.println("can't find");
        }
    }
}
