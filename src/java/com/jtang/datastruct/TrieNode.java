package com.jtang.datastruct;

public class TrieNode {
    private char data;
    private TrieNode[] children = new TrieNode[26];

    private boolean endingChar = false;

    public TrieNode(char data){
        this.data = data;
    }

    public TrieNode getChildren(int index) {
        if(index >= this.children.length){
            throw new IllegalArgumentException("index out of children list: " + index);
        }
        return children[index];
    }

    public void setChildrenValue(int index, TrieNode value){
        children[index] = value;
    }

    public void setEndingChar() {
        this.endingChar = true;
    }

    public boolean isEndingChar() {
        return endingChar;
    }
}
