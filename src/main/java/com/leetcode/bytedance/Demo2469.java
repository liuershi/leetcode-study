package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/21 10:02 下午
 * @Version 1.0
 */
public class Demo2469 {

    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + 273.15d;
        res[1] = celsius * 1.8 + 32;
        return res;
    }
}
