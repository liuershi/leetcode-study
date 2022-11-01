package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2022/10/29 12:50 上午
 * @Version 1.0
 */
public class Demo460 {

    class LFUCache {

        class Node implements Comparable<Node> {
            int key;
            int val;
            int cnt; // 记录节点被操作的次数
            int time; // 记录节点最近一次操作的时间戳

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public Node(int key, int val, int cnt, int time) {
                this.key = key;
                this.val = val;
                this.cnt = cnt;
                this.time = time;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj instanceof Node) {
                    Node node = (Node) obj;
                    return node.cnt == this.cnt && node.time == this.time;
                }
                return false;
            }

            @Override
            public int compareTo(Node o) {
                // 以频率作为第一要素，其次考虑时间戳为第二要素
                return this.cnt == o.cnt ? this.time - o.time : this.cnt - o.cnt;
            }

            @Override
            public int hashCode() {
                return cnt * 1000000007 + time;
            }
        }


        int capacity;
        int time;
        TreeSet<Node> set;
        Map<Integer, Node> map;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 0;
            this.set = new TreeSet<>();
            this.map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (capacity == 0 || !map.containsKey(key))
                return -1;

            Node node = map.get(key);
            // 注意：由于Set和Map添加节点时都是值拷贝，所以添加的Node在它们的容器内不是同一个对象
            // 先移除旧的对象
            set.remove(node);
            // 计数与时间都更新
            node.cnt++;
            node.time = ++time;
            set.add(node);
            map.put(key, node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;

            Node node = map.get(key);
            if (node == null) {
                node = new Node(key, value, 1, ++time);
                if (map.size() == capacity) {
                    // 移除最近最少使用的节点
                    map.remove(set.first().key);
                    set.remove(set.first());
                }
                map.put(key, node);
                set.add(node);
                return;
            }
            set.remove(node);
            node.cnt++;
            node.time = ++time;
            node.val = value;
            set.add(node);
            map.put(key, node);
        }
    }
}
