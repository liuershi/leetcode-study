package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/12 12:00 下午
 * @Version 1.0
 */
public class Demo1138 {

    public String alphabetBoardPath(String target) {
        int[][] memo = new int[26][2];
        for (int i = 0; i < 26; i++) {
            memo[i] = new int[]{i / 5, i % 5};
        }
        StringBuilder content = new StringBuilder();
        target = "a" + target;
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) == target.charAt(i - 1)) {
                content.append("!");
            } else {
                int[] origin = memo[target.charAt(i - 1) - 'a'];
                int[] dest = memo[target.charAt(i) - 'a'];
                int level = dest[1] - origin[1];
                int vertical = dest[0] - origin[0];
                if (target.charAt(i) == 'z') {
                    levelMove(content, level);
                    verticalMove(content, vertical);
                } else  {
                    verticalMove(content, vertical);
                    levelMove(content, level);
                }
                content.append("!");
            }
        }
        return content.toString();
    }

    private void levelMove(StringBuilder content, int level) {
        if (level < 0) {
            for (int j = 0; j < Math.abs(level); j++) {
                content.append("L");
            }
        } else if (level > 0) {
            for (int j = 0; j < level; j++) {
                content.append("R");
            }
        }
    }

    private void verticalMove(StringBuilder content, int vertical) {
        if (vertical < 0) {
            for (int j = 0; j < Math.abs(vertical); j++) {
                content.append("U");
            }
        } else if (vertical > 0) {
            for (int j = 0; j < vertical; j++) {
                content.append("D");
            }
        }
    }
}
