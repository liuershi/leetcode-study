package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/11/9 10:12 下午
 * @Version 1.0
 */
public class Demo677 {

    class MapSum {

        Map<String, Integer> container;

        public MapSum() {
            this.container = new HashMap<>(64);
        }

        public void insert(String key, int val) {
            container.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry : container.entrySet()) {
                if (entry.getKey().startsWith(prefix))
                    sum += entry.getValue();
            }
            return sum;
        }
    }
}
