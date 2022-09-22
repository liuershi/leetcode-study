package com.leetcode.weekly.google.week307;

/**
 * @Author milindeyu
 * @Date 2022/8/21 10:37 上午
 * @Version 1.0
 */
public class Demo6152 {

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            if (initialEnergy > energy[i] && initialExperience > experience[i]) {
                initialEnergy -= energy[i];
                initialExperience += experience[i];
                continue;
            }

            if (initialEnergy <= energy[i]) {
                int val = energy[i] - initialEnergy + 1;
                res += val;
                initialEnergy = 1;
            } else {
                initialEnergy -= energy[i];
            }
            if (initialExperience <= experience[i]) {
                int val = experience[i] - initialExperience + 1;
                res += val;
                initialExperience += val;
            }
            initialExperience += experience[i];
        }
        return res;
    }
}
