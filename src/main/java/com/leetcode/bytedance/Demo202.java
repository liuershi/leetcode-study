package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/8/5 11:27 下午
 * @Version 1.0
 */
public class Demo202 {

    public boolean isHappy(int n) {
//        return method1(n);

        // 方式二：不管是否为快乐数，生成的数字始终都会成环，只是快乐数成环的数字为1
        // 使用快慢指针的方式
        int slow = n, fast = process(n);
        while (slow != fast) {
            slow = process(slow);
            fast = process(process(fast));
        }
        return slow == 1;
    }

    public int process(int n) {
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += Math.pow(c - '0', 2);
        }
        return sum;
    }

    /**
     * 使用set存储处理结果来判断
     * @param n
     * @return
     */
    private boolean method1(int n) {
        // 注意点：要避免死循环，用set来保存已处理的数
        Set<Integer> executed = new HashSet<>();
        while (!executed.contains(n)) {
            executed.add(n);
            int sum = 0;
            for (char c : String.valueOf(n).toCharArray()) {
                sum += Math.pow((c - '0'), 2);
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }
}
