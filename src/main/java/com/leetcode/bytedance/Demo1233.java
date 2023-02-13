package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/2/8 7:11 下午
 * @Version 1.0
 */
public class Demo1233 {

    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        // 思想：将文件夹放在set中，遍历过程中如果每次分割 / 时都不在set中则认为这个文件夹没有上级
        Set<String> set = new HashSet<>(folder.length);
        set.addAll(Arrays.asList(folder));
        for (String fold : folder) {
            boolean exist = false;
            for (int i = fold.length() - 1; i >= 0; i--) {
                if (fold.charAt(i) == '/' && set.contains(fold.substring(0, i))) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                res.add(fold);
            }
        }
        return res;
    }
}
