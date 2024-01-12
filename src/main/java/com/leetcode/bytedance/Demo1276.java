package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/12/25 12:28 上午
 * @Version 1.0
 */
public class Demo1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            ans.add(0);
            ans.add(0);
            return ans;
        }
        if (tomatoSlices == 0 || cheeseSlices == 0
                // 当番茄片比使用完的奶酪片还少时
                || tomatoSlices < 2 * cheeseSlices
                // 当番茄片为奇数时，也就是会有剩余时
                || (tomatoSlices & 1) == 1) {
            return ans;
        }

        int hugeBurger = 0;
        if (tomatoSlices > cheeseSlices * 2) {
            int remain = tomatoSlices - cheeseSlices * 2;
            if (remain < 4) {
                hugeBurger = 1;
            } else {
                hugeBurger = remain / 4;
            }
            tomatoSlices -= hugeBurger * 4;
            cheeseSlices -= hugeBurger;
        }

        if (tomatoSlices != cheeseSlices * 2) {
            return ans;
        }

        ans.add(hugeBurger);
        ans.add(cheeseSlices);

        return ans;
    }
}
