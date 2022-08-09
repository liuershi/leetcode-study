package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/23 7:52 下午
 * @Version 1.0
 */
public class Demo401 {

    /**
     * 回溯方式
     */
    int[] hours = {1, 2, 4, 8};
    int[] minus = {1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> rsp = new ArrayList<>();
        Set<String> hoursList = new HashSet<>();
        Set<String> minusList = new HashSet<>();
        // hour
        for (int i = 0; i <= turnedOn; i++) {
            hoursList.clear();
            selectHour(i, new LinkedList<>(), hoursList);
            // minus
            minusList.clear();
            selectMinus(turnedOn - i, new LinkedList<>(), minusList);

            // union
            for (String hour : hoursList) {
                for (String minus : minusList) {
                    String time = hour + ":" + (minus.length() == 1 ? "0" + minus : minus);
                    rsp.add(time);
                }
            }
        }
        return rsp;
    }

    private void selectMinus(int selectNum, LinkedList<Integer> path, Set<String> minusList) {
        if (path.size() == selectNum) {
            minusList.add(String.valueOf(path.stream().mapToInt(Integer::intValue).sum()));
            return;
        }
        for (int i = 0; i < minus.length; i++) {
            if (path.contains(minus[i])) continue;
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum + minus[i] >= 60) continue;
            path.addLast(minus[i]);
            selectMinus(selectNum, path, minusList);
            path.removeLast();
        }
    }

    private void selectHour(int selectNum, LinkedList<Integer> path, Set<String> hoursList) {
        if (path.size() == selectNum) {
            hoursList.add(String.valueOf(path.stream().mapToInt(Integer::intValue).sum()));
            return;
        }
        for (int i = 0; i < hours.length; i++) {
            if (path.contains(hours[i])) continue;
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum + hours[i] >= 12) continue;
            path.addLast(hours[i]);
            selectHour(selectNum, path, hoursList);
            path.removeLast();
        }
    }


    // ========================================================================
    // ========================================================================
    // 基于二进制位的方式
    public List<String> readBinaryWatchTwo(int turnedOn) {
        List<String> rsp = new ArrayList<>();
        // 小时只存在0～11
        for (int i = 0; i < 12; i++) {
            // 分钟必须小于60
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn)
                    rsp.add(i + ":" + ((j < 10) ? "0" : "") + j);
            }
        }
        return rsp;
    }
}
