package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/10/16 1:42 下午
 * @Version 1.0
 */
public class Demo886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 方式三：并查集
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            lists[dislike[0]].add(dislike[1]);
            lists[dislike[1]].add(dislike[0]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < lists[i].size(); j++) {
                union(lists[i].get(0), lists[i].get(j), memo);
                if (isConnected(i, lists[i].get(j), memo)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isConnected(int i, Integer j, int[] memo) {
        return find(memo, i) == find(memo, j);
    }

    public void union(int x, int y, int[] memo) {
        x = find(memo, x);
        y = find(memo, y);
        if (x == y) return;

        if (memo[x] < memo[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        memo[x] += memo[y];
        memo[y] = x;
    }

    public int find(int[] memo, int x) {
        return memo[x] < 0 ? x : (memo[x] = find(memo, memo[x]));
    }

    private boolean widthFirstSearch(int n, int[][] dislikes) {
        // 方式二：广度优先遍历
        int[] color = new int[n + 1];
        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            lists[dislike[0]].add(dislike[1]);
            lists[dislike[1]].add(dislike[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.offer(i);
                color[i] = 1;
                while (!stack.isEmpty()) {
                    Integer cur = stack.poll();
                    for (Integer next : lists[cur]) {
                        if (color[next] != 0 && color[cur] == color[next])
                            return false;
                        if (color[next] == 0) {
                            color[next] = 3 ^ color[cur];
                            stack.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean deepFirstSearch(int n, int[][] dislikes) {
        // 方式一：深度优先遍历
        // 使用「染色法」来解决问题
        int[] color = new int[n + 1];
        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            lists[dislike[0]].add(dislike[1]);
            lists[dislike[1]].add(dislike[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, lists)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curnode, int newcolor, int[] color, List<Integer>[] lists) {
        color[curnode] = newcolor;
        for (Integer next : lists[curnode]) {
            if (color[next] != 0 && color[curnode] == color[next])
                return false;
            // 此时异或3表示的是：
            // 0：表示未使用，1：使用分组1；2：使用分组2
            // 1异或3等于2，2异或3等于1
            if (color[next] == 0 && !dfs(next, newcolor ^ 3, color, lists))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Demo886 demo886 = new Demo886();
        int[][] nums = {{1,2},{3,4},{5,6},{6,7},{8,9},{7,8}};
        demo886.possibleBipartition(10, nums);
    }
}
