package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/4/9 1:08 下午
 * @Version 1.0
 */
public class Demo780 {
    private boolean result;
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        process(sx, sy, tx, ty);
        return result;
    }

    private void process(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty || result) return;
        if (sx == tx && sy == ty) result = true;
        process(sx + sy, sy, tx, ty);
        process(sx, sx + sy, tx, ty);
    }

    public static void main(String[] args) {
        Demo780 demo780 = new Demo780();
        System.out.println(demo780.reachingPoints(35, 13, 455955547, 420098884));
    }
}
