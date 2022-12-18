package com.leetcode.weekly.week323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/12/11 11:24 上午
 * @Version 1.0
 */
public class Demo6259 {

    static class Allocator {

        int[] memory;
        // 空闲的内存范围
        List<int[]> container;

        public Allocator(int n) {
            memory = new int[n];
            container = new ArrayList<>();
            container.add(new int[]{0, n});
        }

        public int allocate(int size, int mID) {

            for (int i = 0; i < container.size(); i++) {
                if (container.get(i)[1] >= size) {
                    int[] oldMem = container.remove(i);
                    Arrays.fill(memory, oldMem[0], oldMem[0] + size, mID);
                    if (size != oldMem[1]) {
                        int[] newMem = new int[]{oldMem[0] + size, oldMem[1] - size};
                        container.add(i, newMem);
                    }
                    return oldMem[0];
                }
            }

            return -1;
        }

        public int free(int mID) {
            int count = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == mID) {
                    memory[i] = 0;
                    count++;
                }
            }
            // 重新检测空闲列表
            container.clear();
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == 0) {
                    int j = i + 1;
                    while (j < memory.length && memory[j] == 0)
                        j++;
                    container.add(new int[]{i, j - i});
                    i = j - 1;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {

        Allocator allocator = new Allocator(5);
        System.out.println(allocator.free(4));
        System.out.println(allocator.allocate(9, 5));
        System.out.println(allocator.allocate(5, 8));
    }
}
