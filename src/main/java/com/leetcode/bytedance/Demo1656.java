package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题
 *
 * @Author milindeyu
 * @Date 2022/8/16 9:58 下午
 * @Version 1.0
 */
public class Demo1656 {

    class OrderedStream {
        String[] streams;
        int ptr;

        public OrderedStream(int n) {
            this.streams = new String[n + 1];
            this.ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            streams[idKey] = value;
            List<String> res = new ArrayList<>();
            while (ptr < streams.length && streams[ptr] != null) {
                res.add(streams[ptr++]);
            }
            return res;
        }
    }
}
