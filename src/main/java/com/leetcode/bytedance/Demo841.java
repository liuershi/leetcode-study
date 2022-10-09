package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/10/9 11:02 下午
 * @Version 1.0
 */
public class Demo841 {

    Set<Integer> visitorRooms = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        process(rooms, 0);
        return visitorRooms.size() == rooms.size();
    }

    public void process(List<List<Integer>> rooms, int idx) {
        if (visitorRooms.contains(idx)) return;
        visitorRooms.add(idx);
        for (Integer val : rooms.get(idx)) {
            process(rooms, val);
        }
    }
}
