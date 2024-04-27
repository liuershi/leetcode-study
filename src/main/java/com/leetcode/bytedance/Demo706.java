package com.leetcode.bytedance;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author fishball
 * @Date 2024/4/15 9:41 下午
 * @Version 1.0
 */
public class Demo706 {

    class MyHashMap {

        LinkedList<Node>[] hash;
        int base = 777;

        class Node {
            int key, val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            @Override
            public boolean equals(Object obj) {
                return obj instanceof Integer && key == (Integer) obj;
            }
        }

        public MyHashMap() {
            hash = new LinkedList[base];
            for (int i = 0; i < base; i++) {
                hash[i] = new LinkedList<>();
            }
        }

        public void put(int key, int value) {
            int idx = key % base;
            LinkedList<Node> nodes = this.hash[idx];
            Iterator<Node> iterator = nodes.iterator();
            boolean find = false;
            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (node.key == key) {
                    node.val = value;
                    find = true;
                    break;
                }
            }
            if (!find) {
                nodes.add(new Node(key, value));
            }
        }

        public int get(int key) {
            LinkedList<Node> nodes = hash[key % base];
            for (Node node : nodes) {
                if (node.key == key) {
                    return node.val;
                }
            }
            return -1;
        }

        public void remove(int key) {
            LinkedList<Node> nodes = hash[key % base];
            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (node.key == key) {
                    iterator.remove();;
                    break;
                }
            }
        }
    }



}
