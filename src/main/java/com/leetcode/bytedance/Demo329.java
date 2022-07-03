package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/16 11:47 下午
 * @Version 1.0
 */
public class Demo329 {

    int rsp = 0;
    int row;
    int col;
    Map<Integer, Set<Node>> depthElements = new HashMap<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 时间和空间复杂度巨高
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && matrix[i][j] > matrix[i - 1][j]) continue;
                if (j > 0 && matrix[i][j] > matrix[i][j - 1]) continue;
                depthElements.clear();
                int[][] cache = new int[row][col];
                dfs(matrix, i, j, new LinkedList<Integer>(), cache, 0);
            }
        }
        return rsp;
    }

    private void dfs(int[][] matrix, int row, int col, LinkedList<Integer> path, int[][] cache, int depth) {
        depthElements.putIfAbsent(depth, new HashSet<>());
        if (row < 0 || row == this.row || col < 0 || col == this.col || cache[row][col] == -1 || depthElements.get(depth).contains(new Node(row, col))) return;
        if (!path.isEmpty() && path.peekLast() >= matrix[row][col]) return;
        depthElements.get(depth).add(new Node(row, col));
        path.addLast(matrix[row][col]);
        cache[row][col] = -1;
        rsp = Math.max(rsp, path.size());
        ++depth;
        dfs(matrix, row - 1, col, path, cache, depth);
        dfs(matrix, row + 1, col, path, cache, depth);
        dfs(matrix, row, col - 1, path, cache, depth);
        dfs(matrix, row, col + 1, path, cache, depth);
        cache[row][col] = 0;
        path.removeLast();
    }

    // ===================================================================
    // ===================================================================

    /**
     * 备忘录
     */
    int[][] cache;
    int[][] matrix;

    /**
     * 基于动态规划来实现
     * @param matrix
     * @return
     */
    public int longestIncreasingPathTwo(int[][] matrix) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        cache = new int[row][col];
        this.matrix = matrix;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 当前点计算过
                if (cache[i][j] != 0) continue;
                int current = matrix[i][j];
                cache[i][j] = obtainDirectionMax(i, j, current);
            }
        }

        // 取缓存中最大值
        int rsp = 0;
        for (int[] cacheLine : cache) {
            for (int c : cacheLine) {
                rsp = Math.max(rsp, c);
            }
        }
        return rsp;
    }

    private int dfs(int[][] matrix, int row, int col, int prev) {
        // 越界，或者上轮节点值大于当前节点值时
        int current;
        if (row < 0 || row == this.row || col < 0 || col == this.col || prev >= (current = matrix[row][col])) return 0;
        // 存在缓存时直接取
        if (cache[row][col] != 0) return cache[row][col];
        // 取水平放行和垂直方向上值的最大值，再加上当前节点自己
        cache[row][col] = obtainDirectionMax(row, col, current);
        return cache[row][col];
    }

    public int obtainDirectionMax(int row, int col, int current) {
        int top = dfs(matrix, row - 1, col, current);
        int bottom = dfs(matrix, row + 1, col, current);
        int left = dfs(matrix, row, col - 1, current);
        int right = dfs(matrix, row, col + 1, current);
        return Math.max(Math.max(left, right), Math.max(top, bottom)) + 1;
    }

    public static void main(String[] args) {
        Demo329 demo329 = new Demo329();
        int[][] matrix = {{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        System.out.println(demo329.longestIncreasingPathTwo(matrix));
    }
}
