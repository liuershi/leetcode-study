package com.leetcode.zcy;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/4/25 11:57 下午
 * @Version 1.0
 */
public class Demo19 {

    /**
     * 根据指定数据的滑动窗口返回其窗口内最大值并组成数组，只能向右滑动
     * @param array 数组
     * @param length 滑动窗口大小
     * @return
     */
    public List<Integer> process(int[] array, int length) {
        if (array.length < length)
            throw new IllegalStateException();
        return maxNum(array, length);
    }


    public List<Integer> maxNum(int[] array, int length) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            put(linkedList, length, i, array);
            if (i >= length - 1)
                list.add(array[linkedList.peekFirst()]);
        }
        return list;
    }

    private void put(LinkedList<Integer> linkedList, int length, int i, int[] array) {
        if (!linkedList.isEmpty() && linkedList.peekFirst() + length == i) {
            linkedList.removeFirst();
        }
        while (!linkedList.isEmpty() && array[linkedList.peekFirst()] < array[i]) {
            linkedList.removeFirst();
        }
        linkedList.addLast(i);
    }

    public static void main(String[] args) {
        Demo19 demo19 = new Demo19();
        int[] nums = {4,3,5,4,3,3,6,7};
        System.out.println(demo19.process(nums, 3));
    }
}
