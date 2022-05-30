package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/4/7 10:17 下午
 * @Version 1.0
 */
public class Demo796 {

    public boolean rotateString(String s, String goal) {
//        return method(s, goal);
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    private boolean method(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == goal.charAt(0)
                && (s.substring(i) + s.substring(0, i)).equals(goal)
            ) return true;
        }
        return false;
    }
}
