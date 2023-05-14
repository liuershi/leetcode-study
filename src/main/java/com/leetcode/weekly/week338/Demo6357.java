package com.leetcode.weekly.week338;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/3/26 11:04 上午
 * @Version 1.0
 */
public class Demo6357 {

    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        Arrays.sort(nums);
        TreeMap<Integer, long[]> map = new TreeMap<>();
        long sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            map.put(nums[i], new long[]{sum, i + 1});
        }
        for(int i = 0 ; i < queries.length ; i++){
            long count = 0L;
            if(queries[i] <= nums[0] || queries[i] >= nums[nums.length - 1]){
                count = Math.abs(sum - (long) queries[i] * nums.length);
            }else{
                long[] val = map.floorEntry(queries[i]).getValue();
                count = Math.abs(val[0] - queries[i] * val[1]) + Math.abs(sum - val[0] - queries[i] * (nums.length - val[1]));
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        Demo6357 demo6357 = new Demo6357();
        int[] nums = {3,1,6,8};
        int[] queries = {1, 5};
        System.out.println(demo6357.minOperations(nums, queries));
    }
}
