package com.leetcode.bytedance;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author milindeyu
 * @Date 2023/9/27 9:37 下午
 * @Version 1.0
 */
public class Demo1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants)
                .filter(restaurant -> veganFriendly == 0 || restaurant[2] == 1)
                .filter(restaurant -> restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                .sorted((restaurant1, restaurant2) -> {
                    if (restaurant1[1] == restaurant2[1]) {
                        return restaurant2[0] - restaurant1[0];
                    }
                    return restaurant2[1] - restaurant1[1];
                })
                .map(restaurant -> restaurant[0])
                .collect(Collectors.toList());
    }
}
