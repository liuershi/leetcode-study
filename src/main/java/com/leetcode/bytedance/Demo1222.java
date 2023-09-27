package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/9/14 8:24 下午
 * @Version 1.0
 */
public class Demo1222 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1 ,0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        Map<Integer, Set<Integer>> container = new HashMap<>();
        for (int[] queen : queens) {
            container.computeIfAbsent(queen[0], key -> new HashSet<>()).add(queen[1]);
        }
        for (int[] direction : directions) {
            List<Integer> item = check(direction, container, king);
            if (item != null) {
                ans.add(item);
            }
        }

        return ans;
    }

    private List<Integer> check(int[] direction, Map<Integer, Set<Integer>> container, int[] king) {
        int x = king[0], y = king[1];
        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (container.containsKey(x) && container.get(x).contains(y)) {
                List<Integer> coordinates = new ArrayList<>(2);
                coordinates.add(x);
                coordinates.add(y);
                return coordinates;
            }
            x += direction[0];
            y += direction[1];
        }
        return null;
    }
}
