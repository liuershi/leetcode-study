package com.leetcode.weekly.week324;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/12/18 10:59 上午
 * @Version 1.0
 */
public class Demo6267 {

    public boolean isPossible(int n, List<List<Integer>> edges) {
        // 记录每个点和其关联的点位
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (List<Integer> edge : edges) {
            map.put(edge.get(0), map.getOrDefault(edge.get(0), new HashSet<>()));
            map.get(edge.get(0)).add(edge.get(1));

            map.put(edge.get(1), map.getOrDefault(edge.get(1), new HashSet<>()));
            map.get(edge.get(1)).add(edge.get(0));
        }

        // 需要添加额外边的点的数目
        int needEdgeCount = 0;
        List<Integer> needEdgeList = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if ((entry.getValue().size() & 1) == 1) {
                needEdgeCount++;
                needEdgeList.add(entry.getKey());
            }
        }

        // 大于4个点、需要额外边为偶数时直接返回
        if (needEdgeCount > 4 || (needEdgeCount & 1) == 1) return false;
        if (needEdgeCount == 0) return true;

        for (Integer needEdge : needEdgeList) {
            Set<Integer> points = map.get(needEdge);
            if (points.size() == n - 1 && ((points.size() & 1) == 1))
                return false;
        }
        if (needEdgeCount == 4) {

        }
        return true;
    }

}
