package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/2/7 12:26 上午
 * @Version 1.0
 */
public class Demo1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.computeIfAbsent(keyName[i], k -> new ArrayList<>());
            String[] times = keyTime[i].split(":");
            int hour = (times[0].charAt(0) - '0') * 10 + (times[0].charAt(1) - '0');
            int minute = (times[1].charAt(0) - '0') * 10 + (times[1].charAt(1) - '0');
            int val = hour * 60 + minute;
            list.add(val);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int diff = list.get(i) - list.get(i - 2);
                if (diff <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Demo1604 demo1604 = new Demo1604();
        String[] keyNames = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
    }
}
