package com.leetcode.weekly.week322;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/12/4 11:04 上午
 * @Version 1.0
 */
public class Demo6255 {


    int res = Integer.MAX_VALUE;
    Set<Integer> visit = new HashSet<>();
    public int minScore(int n, int[][] roads) {

        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        Map<Integer, Integer> min = new HashMap<>(n);
        for (int[] road : roads) {
            if (map.containsKey(road[0])) {
                map.get(road[0]).add(road[1]);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(road[1]);
                map.put(road[0], s);
            }
            if (map.containsKey(road[1])) {
                map.get(road[1]).add(road[0]);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(road[0]);
                map.put(road[1], s);
            }
            min.put(road[0], Math.min(min.getOrDefault(road[0], Integer.MAX_VALUE), road[2]));
            min.put(road[1], Math.min(min.getOrDefault(road[1], Integer.MAX_VALUE), road[2]));
        }
        process(map.get(1), map, min);

        return res;
    }

    private void process(Set<Integer> set, Map<Integer, Set<Integer>> map, Map<Integer, Integer> min) {
        if (set.isEmpty())
            return;
        for (Integer val : set) {
            if (visit.contains(val)) continue;
            res = Math.min(res, min.get(val));
            visit.add(val);
            process(map.get(val), map, min);
        }
    }

    public static void main(String[] args) {
        Demo6255 demo6255 = new Demo6255();
        int[][] nums = {{7,11,418},{13,23,287},{16,25,7891},{15,7,9695},{4,3,9569},{17,7,1809},{14,3,4720},{14,4,6118},{9,2,4290},{32,17,5645},{14,16,426},{36,7,6721},{13,30,9444},{3,25,4635},{33,5,1669},{22,18,8910},{5,28,7865},{13,10,9466},{7,9,2457},{11,8,4711},{17,11,6308},{7,34,3789},{8,33,9659},{16,3,4187},{16,20,3595},{23,10,6251},{26,22,6180},{4,16,5577},{26,7,5398},{6,36,8671},{10,19,3028},{23,30,1330},{19,13,8315},{25,20,4740},{25,4,5818},{30,10,8030},{30,19,7527},{28,6,6804},{21,27,1746},{18,9,5189},{7,27,6560},{20,14,2450},{27,32,3951},{2,21,3927},{1,15,9283},{3,20,5428},{15,26,5871},{19,23,4533},{14,25,6992},{4,20,5831}};
        System.out.println(demo6255.minScore(36, nums));
    }
}
