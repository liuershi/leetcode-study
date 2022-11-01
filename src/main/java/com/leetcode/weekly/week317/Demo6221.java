package com.leetcode.weekly.week317;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/10/30 10:40 上午
 * @Version 1.0
 */
public class Demo6221 {

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> rsp = new ArrayList<>();

        Map<String, long[]> mapViews = new HashMap<>();
        int len = creators.length;
        long max = 0;
        for (int i = 0; i < len; i++) {
            long[] arr = mapViews.get(creators[i]);
            if (mapViews.get(creators[i]) == null) {
                arr = new long[]{0, -1};
            }
            arr[0] += views[i];
            max = Math.max(max, arr[0]);
            if (arr[1] == -1 || views[i] > views[(int) arr[1]]) {
                arr[1] = i;
            }
            // 需要比较id的字典序
            if (views[i] == views[(int) arr[1]] && ids[i].compareTo(ids[(int) arr[1]]) > 0) {
                arr[1] = i;
            }
            mapViews.put(creators[i], arr);
        }

        for (Map.Entry<String, long[]> entry : mapViews.entrySet()) {
            long[] arr = entry.getValue();
            if (max == arr[0]) {
                List<String> item = new ArrayList<>();
                item.add(entry.getKey());
                item.add(ids[(int) arr[1]]);
                rsp.add(item);
            }
        }
        return rsp;
    }
}
