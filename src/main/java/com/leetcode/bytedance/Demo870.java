package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/9/13 9:00 下午
 * @Version 1.0
 */
public class Demo870 {

    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(new int[]{chars[i] - '0', i});
        }
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        for (int i = 0; i < chars.length; i++) {
            int val = list.get(i)[0];
            if ((chars[i] - '0') < val) {
                int j = i;
                while (j < chars.length && val == list.get(j)[0]) j++;
                j--;
                char temp = chars[i];
                chars[i] = (char) (list.get(j)[0] + '0');
                chars[list.get(j)[1]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }
}
