package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/7 10:17 下午
 * @Version 1.0
 */
public class Demo777 {

    public boolean canTransform(String start, String end) {
        int len = start.length(), i = 0, j = 0;
        while (i < len || j < len) {
            while (i < len && start.charAt(i) == 'X') i++;
            while (j < len && end.charAt(j) == 'X') j++;
            if (i == len || j == len) return i == j;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}
