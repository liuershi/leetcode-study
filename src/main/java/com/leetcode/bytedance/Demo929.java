package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangwei151
 * @date 2022/6/4 10:44
 */
public class Demo929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] strings = email.split("@");
            String local = strings[0];
            int sumIdx = local.indexOf("+");
            if (sumIdx != -1)
                local = local.substring(0, sumIdx);
            local = local.replaceAll("\\.", "");
            set.add(local + "@" + strings[1]);
        }
        return set.size();
    }
}
