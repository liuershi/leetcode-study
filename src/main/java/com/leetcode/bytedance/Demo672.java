package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/9/18 11:26 下午
 * @Version 1.0
 */
public class Demo672 {
    public int flipLights(int n, int presses) {
        if(presses==0) return 1;
        if(n<=2) return n==1? 2 : presses==1? 3 : 4;
        return presses<=2? (presses==1? 4 : 7) : 8;
    }
}
