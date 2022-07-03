package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/18 7:58 下午
 * @Version 1.0
 */
public class Demo365 {

   /* int jug1Capacity;
    int jug2Capacity;
    int targetCapacity;
    boolean rsp;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity) return true;
        this.jug1Capacity = jug1Capacity;
        this.jug2Capacity = jug2Capacity;
        this.targetCapacity = targetCapacity;
        int abs = Math.abs(jug1Capacity - jug2Capacity);
        dfs(abs, new LinkedList<>());
        return rsp;
    }

    private void dfs(int val, LinkedList<Integer> path) {
        if (rsp) return;
        if (val == 0 || val == targetCapacity || val == jug1Capacity || val == jug2Capacity || path.contains(val)) {
            rsp = val == targetCapacity || val + this.jug1Capacity == targetCapacity || val + this.jug2Capacity == targetCapacity;
            return;
        }
        path.addLast(val);
        dfs(Math.abs(val - jug1Capacity), path);
        dfs(Math.abs(val - jug2Capacity), path);
        path.removeLast();
    }*/




    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 特例判断
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        if (jug1Capacity == 0 || jug2Capacity == 0 || targetCapacity == 0) return targetCapacity == 0 || (jug1Capacity + jug2Capacity) == targetCapacity;

        State initState = new State(0, 0);
        Queue<State> queue = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);
        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curA = curState.getA();
            int curB = curState.getB();
            // 存在某个水杯活着两个水杯的水为目标值时直接返回
            if (curA == targetCapacity || curB == targetCapacity || curA + curB == targetCapacity) return true;

            // 获取当前状态的下个状态集合
            List<State> states = getNextStates(curA, curB, jug1Capacity, jug2Capacity);
            for (State state : states) {
                if (!visited.contains(state)) {
                    queue.offer(state);
                    visited.add(state);
                }
            }
        }
        return false;
    }


    /**
     * 获取当前状态的下个状态
     * @param curA 当前水杯A中的水
     * @param curB 当前水杯B中的水
     * @param a 水杯a最大容量
     * @param b 水杯b最大容量
     * @return
     */
    private List<State> getNextStates(int curA, int curB, int a, int b) {
        // 共八种状态
        List<State> states = new ArrayList<>(8);

        // 装满任意一个水壶
        // 1.向杯A中倒满水
        if (curA < a) {
            State nextState1 = new State(a, curB);
            // 杯A中水未满时才需要加水
            states.add(nextState1);
        }
        // 2.向杯B中倒满水
        if (curB < b) {
            State nextState2 = new State(curA, b);
            // 杯B中水未满时才需要加水
            states.add(nextState2);
        }

        // 清空任意一个水壶
        // 3.清空杯A中的水
        if (curA > 0) {
            State nextState3 = new State(0, curB);
            // 杯A中有水时才需要清空水
            states.add(nextState3);
        }
        // 4.清空杯B中的水
        if (curB > 0) {
            State nextState4 = new State(curA, 0);
            // 同理，B也是
            states.add(nextState4);
        }

        // 从一个水壶向另外一个水壶倒水，直到装满或者倒空
        // 5.从A向B中倒水，且A中有剩余水，B装满了
        if (curA - (b - curB) > 0) {
            State nextState5 = new State(curA - (b - curB), b);
            states.add(nextState5);
        }
        // 6.从B向A中倒水，且B中有剩余水，A装满了
        if (curB - (a - curA) > 0){
            State nextState6 = new State(a, curB - (a - curA));
            states.add(nextState6);
        }
        // 7.从A向B中倒水，且A无剩余水，B未装满
        if (curA + curB < b) {
            State nextState7 = new State(0, curA + curB);
            states.add(nextState7);
        }
        // 8.从B向A中倒水，且B无剩余水，A未装满
        if (curA + curB < a) {
            State nextState8 = new State(curA + curB, 0);
            states.add(nextState8);
        }
        return states;
    }

    /**
     * 定义状态类
     */
    static class State {
        // 分别表示两个水杯当前的水两
        int a;
        int b;

        public State(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return a == state.a && b == state.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }



    public static void main(String[] args) {


        boolean b = new Demo365().canMeasureWater(2, 6, 5);
        System.out.println(b);
    }
}
