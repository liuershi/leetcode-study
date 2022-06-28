package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/6/29 12:05 上午
 * @Version 1.0
 */
public class Demo535 {

    public class Codec {

        private long id;
        Map<Long, String> map = new HashMap<>();
        private final String prefixUrl = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(++id, longUrl);
            return prefixUrl + id;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String key = shortUrl.substring(prefixUrl.length());
            return map.get(Long.parseLong(key));
        }
    }

    public static void main(String[] args) {
        String s = Integer.toHexString(1113133131);
        System.out.println(s);
    }
}
