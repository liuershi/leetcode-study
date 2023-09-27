package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/8/21 7:27 下午
 * @Version 1.0
 */
public class Demo2337 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while(i < n && j < n) {
            while(i < n && start.charAt(i) == '_') {
                i++;
            }
            while(j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if (c == 'L' && i < j) {
                    return false;
                }
                if (c == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
        }

        while(i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i++;
        }
        while(j < n) {
            if (target.charAt(j) != '_') {
                return false;
            }
            j++;
        }

        return true;
    }


    public static void main(String[] args) {
        Demo2337 demo2337 = new Demo2337();
        System.out.println(demo2337.canChange("_L__R__R_", "L______RR"));
    }
}
