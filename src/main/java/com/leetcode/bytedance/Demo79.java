package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/26 11:33 下午
 * @Version 1.0
 */
public class Demo79 {

    int height;
    int width;
    int sLen;

    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        sLen = word.length();
        if (height * width < sLen) return false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (process(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, String word, int i, int j, int position) {
        if (i >= height || i < 0 || j >= width || j < 0 || board[i][j] != word.charAt(position)) return false;
        position++;
        if (position == sLen) {
            return true;
        }
        board[i][j] += 128;
        boolean rsp = process(board, word, i + 1, j, position)
                || process(board, word, i - 1, j, position)
                || process(board, word, i, j + 1, position)
                || process(board, word, i, j - 1, position);
        board[i][j] -= 128;
        return rsp;
    }

    public static void main(String[] args) {
        Demo79 demo79 = new Demo79();
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(demo79.exist(chars, "ABCB"));
    }
}
