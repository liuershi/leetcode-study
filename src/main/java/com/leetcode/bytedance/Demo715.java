package com.leetcode.bytedance;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2022/6/20 9:41 下午
 * @Version 1.0
 */
public class Demo715 {

    class RangeModule {

        TreeMap<Integer, Integer> treeMap;

        public RangeModule() {
            treeMap = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = treeMap.higherEntry(left);
            if (entry != treeMap.firstEntry()) { // 此时说明当前区间前面还存在区间
                Map.Entry<Integer, Integer> start = entry != null ? treeMap.lowerEntry(entry.getKey()) : treeMap.lastEntry();
                if (start != null && start.getValue() >= right) {
                    // 此时说明当前查询到的区域是包含给定的left-right区域的，不需要操作直接返回
                    return;
                }
                if (start != null && start.getValue() >= left) {
                    // 此时说明查询到的区间[l,r]与给定区间[left,right]存在关系：l <= left <= r < right
                    left = start.getKey(); // 此时应该扩大区间，将left设置为指定查询到的区间左边
                    // 此时移除查询到的区间，待会儿会新增更大的区间来填充
                    treeMap.remove(left);
                }
            }
            // 需要判断，新增的right边界是否包含其他区间，如果有的话，要将其他区间全部移除
            while (entry != null && entry.getKey() <= right) {
                // 取当前查询到的区间右边界和指定右边界最大值
                right = Math.max(right, entry.getValue());
                // 移除旧的区间
                treeMap.remove(entry.getKey());
                // 取大于当前区间left的第一个区间
                entry = treeMap.higherEntry(entry.getKey());
            }
            treeMap.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> higherEntry = treeMap.higherEntry(left);
            // 若大于left的区间为当前第一个区间，则说明后面的区间都大于给定区间，所以直接返回
            if (higherEntry == treeMap.firstEntry()) return false;
            // 若大于left区间的第一个区间不为null，则取小于left区间的第一个区间，否则取最后一个区间
            higherEntry = higherEntry != null ? treeMap.lowerEntry(higherEntry.getKey()) : treeMap.lastEntry();
            // 若存在一个小于left的最近区间，且该区间的有边界大于当前给定的right，说明这个最近的区间是包含给定left-right区间的
            return higherEntry != null && higherEntry.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = treeMap.higherEntry(left);
            if (entry != treeMap.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? treeMap.lowerEntry(entry.getKey()) : treeMap.lastEntry();
                // 此时说明被移除的区间在查询出来的区间内部
                if (start != null && start.getValue() >= right) {
                    // 左边界对齐时，移除当前区间
                    if (start.getKey() == left) {
                        treeMap.remove(start.getKey());
                    } else {
                        // 未对齐时，必然保留较小左边界和大左边界
                        treeMap.put(start.getKey(), left);
                    }
                    if (right != start.getValue()) {
                        // 右边界未对齐，必然保留较小右边界到大右边界区间
                        treeMap.put(right, start.getValue());
                    }
                    return;
                } else if (start != null && start.getValue() > left) {
                    // 此时说明指定区间有一部分在查询区间中，所以此时查询到的区间的左边界和指定区域左边界要保留
                    treeMap.put(start.getKey(), left);
                }
            }
            while (entry != null && entry.getKey() < right) {
                if (entry.getValue() <= right) {
                    treeMap.remove(entry.getKey());
                    entry = treeMap.higherEntry(entry.getKey());
                } else {
                    treeMap.put(right, entry.getValue());
                    treeMap.remove(entry.getKey());
                    break;
                }
            }
        }
    }

}
