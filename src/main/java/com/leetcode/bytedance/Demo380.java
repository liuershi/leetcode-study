package com.leetcode.bytedance;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangwei151
 * @date 2022/9/25 22:53
 */
public class Demo380 {

    /**
     * 思路一：使用set模拟，但是在获取随机元素时时间复杂度还是为O(n)
     * 思路二：使用map维护元素以及其对应在真正容器list中的下标，在移除元素时将list中最后一个元素放在被移除元素的位置，实现
     * 维护list
     */
    class RandomizedSet {
        // 用于判断元素是否存在，维护元素和其在container中的下标
        Map<Integer, Integer> indies;
        // 实际存储的容器，为了在随机获取元素时实现O(1)的时间复杂度
        List<Integer> container;
        ThreadLocalRandom random;

        public RandomizedSet() {
            indies = new HashMap<>();
            container = new ArrayList<>();
            random = ThreadLocalRandom.current();
        }

        public boolean insert(int val) {
            if (indies.containsKey(val)) return false;
            int index = container.size();
            container.add(val);
            indies.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!indies.containsKey(val)) return false;
            // 拿到当前要移除元素在container中的下标
            Integer index = indies.get(val);
            // 拿到当前容器中最后一个元素的值
            int last = container.get(container.size() - 1);
            // 将当前要移除元素下标位置的值设置为容器中最后一个元素
            container.set(index, last);
            indies.put(last, index);
            // 移除待删除的元素
            container.remove(container.size() - 1);
            // 注意，此时为移除最后一个元素
            indies.remove(val);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(container.size());
            return container.get(index);
        }
    }
}
