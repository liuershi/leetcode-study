package com.leetcode.weekly.nio.twoweek72;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/8/27 11:00 下午
 * @Version 1.0
 */
public class Demo2178 {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if ((finalSum & 1) == 1) return res;

        long start = 2, sum = 0;
        while (sum + start <= finalSum) {
            res.add(start);
            sum += start;
            start += 2;
        }
        if (res.contains(finalSum - sum)) {
            res.remove(res.size() - 1);
            res.add(start - 2 + finalSum - sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Demo2178 demo2178 = new Demo2178();
        System.out.println(demo2178.maximumEvenSplit(12));
    }
}
