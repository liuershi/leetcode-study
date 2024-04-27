package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author fishball
 * @Date 2024/3/21 11:28 下午
 * @Version 1.0
 */
public class Demo2671 {

    class FrequencyTracker {
        // 记录各数字的次数
        Map<Integer, Integer> numberMap;
        // 各次数存在的数字集合
        Map<Integer, Set<Integer>> countMap;

        public FrequencyTracker() {
            this.numberMap = new HashMap<>();
            this.countMap = new HashMap<>();
        }

        public void add(int number) {
            Integer count = numberMap.getOrDefault(number, 0) + 1;
            numberMap.put(number, count);
            if (count > 1) {
                countMap.get(count - 1).remove(number);
            }
            countMap.putIfAbsent(count, new HashSet<>());
            countMap.get(count).add(number);
        }

        public void deleteOne(int number) {
            int count = numberMap.getOrDefault(number, -1);
            if (count == -1) {
                return;
            }
            if (count == 1) {
                numberMap.remove(number);
            } else {
                numberMap.put(number, count - 1);
                countMap.putIfAbsent(count - 1, new HashSet<>());
                countMap.get(count - 1).add(number);
            }
            countMap.get(count).remove(number);
        }

        public boolean hasFrequency(int frequency) {
            return countMap.containsKey(frequency) && countMap.get(frequency).size() > 0;
        }
    }
}
