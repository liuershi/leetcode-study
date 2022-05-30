package com.leetcode.zcy;

/**
 *
 * kmp算法
 *
 * @Author milindeyu
 * @Date 2022/4/23 8:21 下午
 * @Version 1.0
 */
public class Demo17 {

    /**
     * 返回目标字符串在指定字符串中第一次出现的位置
     * @param haystack 指定字符串
     * @param needle 目标字符串
     * @return
     */
    public int indexOf(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        char[] sc = haystack.toCharArray();
        char[] tc = needle.toCharArray();

        int[] next = getNextArray(tc);
        int sdx = 0;
        int tdx = 0;
        while (sdx < sc.length && tdx < tc.length) {
            if (sc[sdx] == tc[tdx]) {
                sdx++;
                tdx++;
            } else if (next[tdx] == -1) {
                sdx++;
            } else {
                tdx = next[tdx];
            }
        }
        return tdx == tc.length ? sdx - tdx : -1;
    }

    /**
     * 返回目标字符串的next数组，kmp算法的难点(注意，该next数组为目标字符串的而不是指定字符串的，切记！！！)
     * 例：aabcscaabs ==> [-1, 0, 1, 0, 0, 0, 0, 1, 2, 3]
     * @param chars 指定字符串的字符数组
     * @return
     */
    private int[] getNextArray(char[] chars) {
        if (chars.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[chars.length];
        // 人为手动设置前两个下标
        next[0] = -1;
        next[1] = 0;

        int idx = 2;
        int cn = 0;

        while (idx < chars.length) {
            if (chars[idx - 1] == chars[cn]) {
                next[idx++] = ++cn;
            } else if (cn > 0) { // 当前idx前的字符和cn位置的字符不相同且cn前还有相同前缀
                cn = next[cn];
            } else {
                next[idx++] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        Demo17 demo17 = new Demo17();
        System.out.println(demo17.indexOf("mississippi", "issip"));
    }
}
