package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/10/20 12:20 上午
 * @Version 1.0
 */
public class Demo2525 {

    public String categorizeBox(int length, int width, int height, int mass) {
        int conditionOne = (int) 1e4;
        int conditionTwo = (int) 1e9;
        String oneVal = null, twoVal = null;
        if (length >= conditionOne || width >= conditionOne || height >= conditionOne || ((long) length * width * height) >= conditionTwo) {
            oneVal = "Bulky";
        }
        if (mass >= 100) {
            twoVal = "Heavy";
        }
        if ("Bulky".equals(oneVal) && "Heavy".equals(twoVal)) {
            return "Both";
        } else if (!"Bulky".equals(oneVal) && !"Heavy".equals(twoVal)) {
            return "Neither";
        } else if ("Bulky".equals(oneVal)) {
            return "Bulky";
        } else {
            return "Heavy";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo2525().categorizeBox(2909, 3968, 3272, 727));
    }
}
