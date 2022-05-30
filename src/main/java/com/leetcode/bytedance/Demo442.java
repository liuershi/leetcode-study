package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/5/8 4:00 下午
 * @Version 1.0
 */
public class Demo442 {

    public List<Integer> findDuplicates(int[] nums) {
//        return method1(nums);

        List<Integer> rsp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0)
                nums[num - 1] *= -1;
            else
                rsp.add(num);
        }
        return rsp;
    }

    private List<Integer> method1(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, false);
            else
                map.put(num, true);
        }

        return map.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Demo442 demo442 = new Demo442();
        int[] nums = {4,3,2,7,8,2,3,7};
        List<Integer> duplicates = demo442.findDuplicates(nums);
        System.out.println(duplicates);
    }
}
