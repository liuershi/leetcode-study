package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangwei151
 * @date 2022/10/19 18:15
 */
public class Demo1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        // 思路：模拟
        // 问题点：如何跳出模拟过程
        // 判断每次循环与栈顶三明治不同的学生人数是否大于等于当前剩余学生人数
        int n = students.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        int diffIdx = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] != sandwiches[i]) {
                diffIdx = i;
                for (int j = i; j < n; j++) {
                    stack.push(students[j]);
                }
                break;
            }
        }

        int remaining = n - diffIdx;
        int counting = 0;
        while (!stack.isEmpty() && counting < remaining) {
            int top = stack.pop();
            if (top == sandwiches[diffIdx]) {
                diffIdx++;
                remaining--;
                counting = 0;
            } else {
                stack.addLast(top);
                counting++;
            }
        }
        return stack.size();
    }
}
