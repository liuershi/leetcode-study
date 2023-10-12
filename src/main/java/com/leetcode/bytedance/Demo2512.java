package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/10/11 10:22 下午
 * @Version 1.0
 */
public class Demo2512 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> ans = new ArrayList<>(k);
        Set<String> positives = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negatives = new HashSet<>(Arrays.asList(negative_feedback));
        // int[] ==> {studentId, value}
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if (b[1] == a[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        for (int i = 0; i < report.length; i++) {
            int val = 0;
            for (String word : report[i].split(" ")) {
                if (positives.contains(word)) {
                    val += 3;
                }
                if (negatives.contains(word)) {
                    val--;
                }
            }
            queue.add(new int[]{student_id[i], val});
        }

        while (k-- > 0) {
            ans.add(queue.poll()[0]);
        }

        return ans;
    }
}
