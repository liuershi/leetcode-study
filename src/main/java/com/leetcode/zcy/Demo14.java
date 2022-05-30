package com.leetcode.zcy;

/**
 * @Author milindeyu
 * @Date 2022/4/19 9:37 下午
 * @Version 1.0
 */
public class Demo14 {

    public int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(firstFunc(arr, 0, arr.length - 1), secFunc(arr, 0, arr.length - 1));
    }

    /**
     * 先手函数
     * @param arr
     * @return
     */
    public int firstFunc(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        return Math.max(arr[l] + secFunc(arr, l + 1, r), secFunc(arr, l, r - 1) + arr[r]);
    }

    /**
     * 后手函数
     * 注意：由于是后手函数，肯定会比先手拿的小，所以取小的即可
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public int secFunc(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(firstFunc(arr, l + 1, r), firstFunc(arr, l, r - 1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 2};
        Demo14 demo14 = new Demo14();
        System.out.println(demo14.win(arr));
    }
}
