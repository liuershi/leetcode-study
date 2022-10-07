package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/10/7 9:33 下午
 * @Version 1.0
 */
public class Demo811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> domainCount = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] domainInfos = cpdomain.split(" ");
            List<String> domains = processDomain(domainInfos[1]);
            for (String domain : domains) {
                domainCount.put(domain, domainCount.getOrDefault(domain, 0) + Integer.parseInt(domainInfos[0]));
            }
        }
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    private List<String> processDomain(String domain) {
        List<String> domains = new ArrayList<>();
        domains.add(domain);
        int first = domain.indexOf(".");
        int last = domain.lastIndexOf(".");
        if (first != last) {
            domains.add(domain.substring(first + 1));
        }
        domains.add(domain.substring(last + 1));
        return domains;
    }
}
