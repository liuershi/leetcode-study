package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2023/2/9 10:42 下午
 * @Version 1.0
 */
public class Demo1797 {

    static class AuthenticationManager {

        int timeToLive;
        Map<String, Integer> container;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.container = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            container.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (container.getOrDefault(tokenId, 0) > currentTime) {
                container.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (Map.Entry<String, Integer> entry : container.entrySet()) {
                if (entry.getValue() > currentTime) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        AuthenticationManager manager = new AuthenticationManager(3);
        System.out.println(manager.countUnexpiredTokens(1));
        manager.generate("mqjfa", 2);
        manager.generate("xg", 5);
        manager.generate("dvm", 8);
        manager.renew("euxli", 9);
        System.out.println(manager.countUnexpiredTokens(11));
        manager.generate("oin", 13);
        System.out.println(manager.countUnexpiredTokens(18));
        manager.generate("qst", 19);
        manager.renew("qy", 20);
        System.out.println(manager.countUnexpiredTokens(21));
    }
}
