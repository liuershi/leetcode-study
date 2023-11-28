package com.leetcode.bytedance;

import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2023/11/28 7:04 下午
 * @Version 1.0
 */
public class Demo1670 {

    class FrontMiddleBackQueue {

        LinkedList<Integer> list;

        public FrontMiddleBackQueue() {
            this.list = new LinkedList<>();
        }

        public void pushFront(int val) {
            list.addFirst(val);
        }

        public void pushMiddle(int val) {
            int size = list.size();
            int middle = size >> 1;
            list.add(middle, val);
        }

        public void pushBack(int val) {
            list.addLast(val);
        }

        public int popFront() {
            return list.isEmpty() ? -1 : list.removeFirst();
        }

        public int popMiddle() {
            int middle = list.size() >> 1;
            if (!list.isEmpty() && (list.size() & 1) == 0) {
                middle--;
            }
            return list.isEmpty() ? -1 : list.remove(middle);
        }

        public int popBack() {
            return list.isEmpty() ? -1 : list.removeLast();
        }
    }
}
