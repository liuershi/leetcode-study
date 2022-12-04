package com.leetcode.bytedance;

import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/12/4 3:34 下午
 * @Version 1.0
 */
public class Demo1774 {

    boolean found = false;
    int res;
    int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        this.res = baseCosts[0];
        int n = toppingCosts.length * 2;
        int[] doubleToppingCosts = new int[n];
        System.arraycopy(toppingCosts, 0, doubleToppingCosts, 0, toppingCosts.length);
        System.arraycopy(toppingCosts, 0, doubleToppingCosts, toppingCosts.length, toppingCosts.length);
        for (int baseCost : baseCosts) {
            if (baseCost == target) {
                return target;
            } else if (baseCost < target) {
                tranceBack(0, baseCost, doubleToppingCosts);
            } else {
                change(baseCost);
            }
        }
        return res;
    }

    private void tranceBack(int idx, int cost, int[] doubleToppingCosts) {
        if (found || cost >= target) {
            change(cost);
            if (res == target) {
                found = true;
            }
            return;
        }
        change(cost);

        for (int i = idx; i < doubleToppingCosts.length; i++) {
            cost += doubleToppingCosts[i];
            tranceBack(i + 1, cost, doubleToppingCosts);
            cost -= doubleToppingCosts[i];
        }
    }

    private void change(int cost) {
        int absCur = Math.abs(cost - target), absRes = Math.abs(res - target);
        if (absCur < absRes || (absCur == absRes && cost < res))
            res = cost;
    }

    public static void main(String[] args) {
        Demo1774 demo1774 = new Demo1774();
        int[] bastCosts = {4,10,8,8};
        int[] toppingCosts = {10,6,10,9,9,6,5};
        int target = 7;
        System.out.println(demo1774.closestCost(bastCosts, toppingCosts, target));
    }
}
