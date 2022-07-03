package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/6/25 5:47 下午
 * @Version 1.0
 */
public class Demo565 {

    public int arrayNesting(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) return len;
        int rsp = 0;
        // 当我们向对应于任何索引的集合添加元素 nums [j]nums[j] 时，
        // 我们将其位置标记为在 visited 数组中访问。
        // 这样做是为了在将来选择此索引作为起始索引时，我们不会进行冗余 count 计算，因为我们已经考虑了与此索引链接的元素
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
                visited[start] = true;
            } while (start != nums[i]);
            rsp = Math.max(rsp, count);
        }
        return rsp;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        Demo565 demo565 = new Demo565();
        System.out.println(demo565.arrayNesting(nums));
    }
}
