package com.jtang.alg.practices;

import java.util.LinkedList;

public class JosephusRing {
    private int capacity;
    private LinkedList<Integer> content;
    //TODO:

    public JosephusRing(int capacity) {
        this.capacity = capacity;
        this.content = new LinkedList<Integer>();
        init();
    }

    private void init() {
        for (int i = 1; i <= capacity; i++) {
            content.add(i);
        }
    }


    public void printRing(){
    }
}
