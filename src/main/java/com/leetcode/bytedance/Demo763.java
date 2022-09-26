package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/9/26 10:37 下午
 * @Version 1.0
 */
public class Demo763 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length();) {
            Character character = s.charAt(i);
            int last = s.lastIndexOf(character);
            if (last == i) {
                res.add(1);
                i++;
                continue;
            }
            int max = last;
            for (int j = i + 1; j < max; j++) {
                int lastJ = s.lastIndexOf(s.charAt(j));
                if (lastJ > max) {
                    max = lastJ;
                }
            }
            res.add(max - i + 1);
            i += max - i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
