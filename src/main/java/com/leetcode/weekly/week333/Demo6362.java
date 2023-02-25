package com.leetcode.weekly.week333;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/2/19 10:33 上午
 * @Version 1.0
 */
public class Demo6362 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> res = new ArrayList<>();
        int one = 0, two = 0;
        while (one < nums1.length || two < nums2.length) {
            if (one == nums1.length) {
                res.add(nums2[two++]);
            } else if (two == nums2.length) {
                res.add(nums1[one++]);
            } else {
                if (nums1[one][0] == nums2[two][0]) {
                    res.add(new int[]{nums1[one][0], nums1[one][1] + nums2[two][1]});
                    one++;
                    two++;
                } else if (nums1[one][0] > nums2[two][0]) {
                    res.add(nums2[two++]);
                } else {
                    res.add(nums1[one++]);
                }
            }
        }
        return res.toArray(new int[][]{});
    }
}
