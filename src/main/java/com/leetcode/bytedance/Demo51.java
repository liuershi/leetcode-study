package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * n皇后问题，使用回溯算法实现，同demo46类似{@link Demo46}
 *
 * @Author milindeyu
 * @Date 2022/3/20 9:55 下午
 * @Version 1.0
 */
public class Demo51 {

    List<List<String>> rep = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(n, track);
        return rep;
    }

    private void backTrack(int n, LinkedList<Integer> track) {
        if (track.size() == n) {
            rep.add(solveChar(new ArrayList<>(track)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (track.contains(i))
                continue;
            if (!track.isEmpty() && (Math.abs(i - track.getLast()) < 2 || isLine(track, i)))
                continue;
            track.add(i);
            backTrack(n, track);
            track.removeLast();
        }
    }

    private boolean isLine(LinkedList<Integer> track, int i) {
        int size = track.size();
        for (int j = 0; j < size; j++) {
            if ((j + track.get(j)) == (size + i) || (j + i) == (track.get(j) + size)) {
                return true;
            }
        }
        return false;
    }

    private List<String> solveChar(List<Integer> track) {
        List<String> item = new ArrayList<>();
        for (Integer integer : track) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < track.size(); i++) {
                sb.append(integer == i ? "Q" : '.');
            }
            item.add(sb.toString());
        }
        return item;
    }

    public static void main(String[] args) {
        Demo51 demo51 = new Demo51();
        List<List<String>> lists = demo51.solveNQueens(8);
        System.out.println(lists);
        System.out.println(lists.size());
    }
}
