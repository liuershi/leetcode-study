package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/7/24 9:50 下午
 * @Version 1.0
 */
public class Demo412 {
    public List<String> fizzBuzz(int n) {
        List<String> rsp = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) rsp.add("FizzBuzz");
            else if (i % 3 == 0) rsp.add("Fizz");
            else if (i % 5 == 0) rsp.add("Buzz");
            else rsp.add(String.valueOf(i));
        }
        return rsp;
    }
}
