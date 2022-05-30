package com.leetcode.zcy;

/**
 * 题目：
 *      规定1对应A，2对应B，依此类推，
 *      给定一个数字字符串111，可转换为AAA、KA、AK
 *
 *      求给指定字符串，求出可转换为字符串的可能？
 *
 * @Author milindeyu
 * @Date 2022/4/19 11:38 下午
 * @Version 1.0
 */
public class Demo16 {

    public int func(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        if (str[index] == '1') {
            int count = func(str, index + 1);
            if (index + 1 < str.length) {
                count += func(str, index + 2);
            }
            return count;
        }
        if (str[index] == '2') {
            int count = func(str, index + 1);
            if (index + 1 < str.length && (str[index + 1] >= '0' && str[index + 1] <= '6')) {
                count += func(str, index + 2);
            }
            return count;
        }
        return func(str, index + 1);
    }

    public static void main(String[] args) {
        Demo16 demo16 = new Demo16();
        System.out.println(demo16.func("118829392811".toCharArray(), 0));
    }
}
