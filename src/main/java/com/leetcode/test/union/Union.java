package com.leetcode.test.union;

/**
 * 并查集基本实现
 *
 * @Author milindeyu
 * @Date 2022/12/14 7:24 下午
 * @Version 1.0
 */
public class Union {
    /**
     * 数组，表示并查集所有的元素
     */
    int[] id;
    /**
     * 并查集的元素个数
     */
    int size;

    public Union(int size) {
        this.id = new int[size];
        this.size = size;
        // 初始化时每个元素都指向自己
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    /**
     * 查询元素所属的集合
     * @param val 要查看的元素
     * @return 元素所在的集合
     */
    public int find(int val) {
        return id[val];
    }

    /**
     * 判断两个数组在所集合是否相同
     * @param firstItem 第一个元素
     * @param secondElem 第二个元素
     * @return <code>boolean</code> 如果是则返回true。
     */
    public boolean isConnected(int firstItem, int secondElem) {
        return id[firstItem] == id[secondElem];
    }

    /**
     * 合并两个元素所在的集合
     * @param firstElem 第一个元素
     * @param secondItem 第二个元素
     */
    public void union(int firstElem, int secondItem) {
        // 查询第一个元素所在的集合
        int firstUnion = find(firstElem);
        // 查询第二个元素所在的集合
        int secondUnion = find(secondItem);

        // 如果这两个不是同一个集合，那么合并。
        if (firstUnion != secondUnion) {
            // 遍历数组，使原来的firstUnion、secondUnion合并为secondUnion
            for (int i = 0; i < size; i++) {
                if (id[i] == firstUnion) {
                    id[i] = secondUnion;
                }
            }
        }
    }

    public void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.print(id[i] + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 10;
        Union union = new Union(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接5和6");
        union.union(5, 6);
        union.printArr();

        System.out.println("连接1和2");
        union.union(1, 2);
        union.printArr();

        System.out.println("连接2和3");
        union.union(2, 3);
        union.printArr();

        System.out.println("连接1和4");
        union.union(1, 4);
        union.printArr();

        System.out.println("连接1和5");
        union.union(1, 5);
        union.printArr();

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
