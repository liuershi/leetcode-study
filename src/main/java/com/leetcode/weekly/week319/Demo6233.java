package com.leetcode.weekly.week319;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author milindeyu
 * @Date 2022/11/13 10:31 上午
 * @Version 1.0
 */
public class Demo6233 {

    public double[] convertTemperature(double celsius) {
        double[] rsp = new double[2];
        java.math.BigDecimal current = new java.math.BigDecimal(String.valueOf(celsius));
        rsp[0] = current.add(new java.math.BigDecimal("273.15")).setScale(5, java.math.RoundingMode.HALF_UP).doubleValue();
        rsp[1] = current.multiply(new java.math.BigDecimal("1.80")).add(new java.math.BigDecimal("32.00")).setScale(5, java.math.RoundingMode.HALF_UP).doubleValue();
        return rsp;
    }
}
