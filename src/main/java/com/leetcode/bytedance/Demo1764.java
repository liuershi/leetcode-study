package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/17 12:42 上午
 * @Version 1.0
 */
public class Demo1764 {

    public boolean canChoose(int[][] groups, int[] nums) {
        boolean res = true;
        // 记录遍历到nums数组的下标位置
        int index = 0;

        out:for (int i = 0; i < groups.length; i++) {
            int startIndex = index;
            for (int j = 0; j < groups[i].length;) {
                if (groups[i][j] == nums[index++]) {
                    j++;
                } else {
                    // 重新处理group
                    j = 0;
                    index = ++startIndex;
                }

                if (index == nums.length && (i != groups.length - 1 || j != groups[i].length)) {
                    res = false;
                    break out;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo1764 demo1764 = new Demo1764();
        int[][] groups = {{9099312,-7882487,-1441304,6624042,-6043305}};
        int[] nums = {-1441304,9099312,-7882487,-1441304,6624042,-6043305,-1441304};
        System.out.println(demo1764.canChoose(groups, nums));
    }
}
