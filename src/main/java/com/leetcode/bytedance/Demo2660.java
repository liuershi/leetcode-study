package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/12/27 10:55 下午
 * @Version 1.0
 */
public class Demo2660 {

    public int isWinner(int[] player1, int[] player2) {
        int countOne = 0, countTwo = 0;
        int sumOne = 0, sumTwo = 0;
        for (int i = 0; i < player1.length; i++) {
            sumOne += (countOne > 0 ? 2 : 1) * player1[i];
            sumTwo += (countTwo > 0 ? 2 : 1) * player2[i];
            if (i >= 2 && player1[i - 2] == 10) {
                countOne--;
            }
            if (i >= 2 && player2[i - 2] == 10) {
                countTwo--;
            }
            if (player1[i] == 10) {
                countOne++;
            }
            if (player2[i] == 10) {
                countTwo++;
            }
        }

        return sumOne == sumTwo ? 0 : (sumOne > sumTwo ? 1 : 2);
    }

    public static void main(String[] args) {
        Demo2660 demo2660 = new Demo2660();
        int[] nums = {9,7,10,7};
        int[] nums1 = {10,2,4,10};
        demo2660.isWinner(nums, nums1);
    }
}
