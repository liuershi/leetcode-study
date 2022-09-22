package com.leetcode.bytedance;

/**
 * https://leetcode.cn/problems/solve-the-equation/
 * 每日一题
 *
 * @Author milindeyu
 * @Date 2022/8/10 12:24 上午
 * @Version 1.0
 */
public class Demo640 {

    public String solveEquation(String equation) {
        String[] expression = equation.split("=");
        int[] left = helper(expression[0]);
        int[] right = helper(expression[1]);
        if (left[0] == right[0]) {
            return left[1] != right[1] ? "No solution" : "Infinite solutions";
        } else {
            int xSize = left[0] - right[0];
            int xVal = right[1] - left[1];
            if (xVal % xSize != 0) return "No solution";
            else return "x=" + xVal / xSize;
        }
    }

    private int[] helper(String express) {
        int xSize = 0, xVal = 0;
        for (String content : express.split("\\+")) {
            boolean startWithNegative = content.charAt(0) == '-';
            if (startWithNegative) {
                content = content.substring(1);
            }

            String[] split = content.split("-");
            for (int i = 0; i < split.length; i++) {
                String item = split[i];
                if (i == 0 && !startWithNegative) {
                    if (item.contains("x")) {
                        item = item.replace("x", "");
                        if ("".equals(item)) xSize++;
                        else xSize += Integer.parseInt(item);
                    } else {
                        xVal += Integer.parseInt(item);
                    }
                } else {
                    if (item.contains("x")) {
                        item = item.replace("x", "");
                        if ("".equals(item)) xSize--;
                        else xSize -= Integer.parseInt(item);
                    } else {
                        xVal -= Integer.parseInt(item);
                    }
                }
            }
        }
        return new int[]{xSize, xVal};
    }

    public static void main(String[] args) {
        Demo640 demo640 = new Demo640();
        System.out.println(demo640.solveEquation("1-x+x-x+x+2x=-99-x+x-x+x"));
        System.out.println(demo640.solveEquation("x=x"));
        System.out.println(demo640.solveEquation("-x=-1"));
    }
}
