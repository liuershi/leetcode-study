package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/3/3 6:49 下午
 * @Version 1.0
 */
public class Demo1487 {

    public String[] getFolderNames(String[] names) {
        int len = names.length;
        String[] files = new String[len];
        Map<String, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(names[i])) {
                int k = map.get(names[i]);
                while (map.containsKey(builderKey(names[i], k))){
                    k++;
                }
                map.put(names[i], k + 1);
                map.put(builderKey(names[i], k), 1);
                files[i] = builderKey(names[i], k);
            } else {
                map.put(names[i], 1);
                files[i] = names[i];
            }
        }
        return files;
    }

    private String builderKey(String name, int k) {
        return name + "(" + k + ")";
    }
}
