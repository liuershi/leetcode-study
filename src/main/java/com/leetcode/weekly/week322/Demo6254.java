package com.leetcode.weekly.week322;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/12/4 10:38 上午
 * @Version 1.0
 */
public class Demo6254 {

    public static long dividePlayers(int[] skill) {
        int n = skill.length;
        int sum = 0;
        for (int val : skill) {
            sum += val;
        }
        int avg = sum / (n / 2);

        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : skill) {
            if (val >= avg) {
                return -1;
            }
            int remain = avg - val;
            if (map.containsKey(remain)) {
                res += (long) val * remain;
                map.put(remain, map.get(remain) - 1);
                if (map.get(remain) == 0) {
                    map.remove(remain);
                }
            } else {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }

        return map.size() != 0 ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,2,5,5};
        System.out.println(dividePlayers(nums));
    }
}
