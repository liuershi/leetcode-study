package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/1 12:11 上午
 * @Version 1.0
 */
public class Demo1694 {

    public static String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : number.toCharArray()) {
            if (c == '-' || c == ' ') continue;
            if (count == 3) {
                sb.append("-").append(c);
                count = 1;
                continue;
            }
            sb.append(c);
            count++;
        }
        if (sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        if (sb.charAt(sb.length() - 2) == '-') {
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(sb.length() - 2, "-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "123 4-567";
        System.out.println(reformatNumber(str));
    }
}
