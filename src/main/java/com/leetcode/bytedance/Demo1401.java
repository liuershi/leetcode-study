package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/25 12:40 上午
 * @Version 1.0
 */
public class Demo1401 {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (isRectangle(xCenter, yCenter, x1, y1, x2, y2)) {
            return true;
        }

        if (isRectangle(xCenter, yCenter, x1 - radius, y1, x1, y2)) {
            return true;
        }
        if (isRectangle(xCenter, yCenter, x1, y2, x2, y2 + radius)) {
            return true;
        }
        if (isRectangle(xCenter, yCenter, x2, y1, x2 + radius, y2)) {
            return true;
        }
        if (isRectangle(xCenter, yCenter, x1, y1 - radius, x2, y1)) {
            return true;
        }

        if (isCircle(xCenter, yCenter, x1, y1) <= radius * radius) {
            return true;
        }
        if (isCircle(xCenter, yCenter, x1, y2) <= radius * radius) {
            return true;
        }
        if (isCircle(xCenter, yCenter, x2, y2) <= radius * radius) {
            return true;
        }
        if (isCircle(xCenter, yCenter, x2, y1) <= radius * radius) {
            return true;
        }

        return false;
    }

    private boolean isRectangle(int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2;
    }

    private int isCircle(int xCenter, int yCenter, int x, int y) {
        return (xCenter - x) * (xCenter - x) + (yCenter - y) * (yCenter * y);
    }
}
