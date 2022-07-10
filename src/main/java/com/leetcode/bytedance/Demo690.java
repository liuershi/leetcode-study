package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/9 4:53 下午
 * @Version 1.0
 */
public class Demo690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int sum = 0;
        LinkedList<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Employee employee = queue.poll();
                sum += employee.importance;
                for (Integer subordinate : employee.subordinates) {
                    queue.addLast(map.get(subordinate));
                }
            }
        }
        return sum;
    }
}
