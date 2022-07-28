package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 最大数
 *
 * @Author milindeyu
 * @Date 2022/7/28 10:24 下午
 * @Version 1.0
 */
public class Demo179 {

   public String largestNumber(int[] nums) {
       String[] formatterNums = new String[nums.length];
       for (int i = 0; i < nums.length; i++) {
           formatterNums[i] = String.valueOf(nums[i]);
       }

       Arrays.sort(formatterNums, (a, b) -> (b + a).compareTo(a + b));
       if ("0".equals(formatterNums[0])) return "0";
       StringBuilder sb = new StringBuilder();
       for (String num : formatterNums) {
           sb.append(num);
       }
       return sb.toString();
   }
}
