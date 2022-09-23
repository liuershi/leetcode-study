package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangwei151
 * @date 2022/9/23 23:10
 */
public class Demo707 {

    class MyLinkedList {

        List<Integer> container;

        public MyLinkedList() {
            this.container = new ArrayList<>();
        }

        public int get(int index) {
            if (index < 0 || index >= container.size()) return -1;
            return container.get(index);
        }

        public void addAtHead(int val) {
            container.add(0, val);
        }

        public void addAtTail(int val) {
            container.add(container.size(), val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) addAtHead(val);
            else if (index == container.size()) addAtTail(val);
            else if (index > container.size()) return;
            else container.add(index, val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= container.size()) return;
            container.remove(index);
        }
    }
}
