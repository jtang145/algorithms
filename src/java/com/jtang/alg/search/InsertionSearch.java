package com.jtang.alg.search;

public class InsertionSearch {
    public static void main(String[] args) {
//        int[] data = {4, 5, 6, 12, 15, 19, 23, 26, 30, 33, 37, 42, 53, 60};
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15, 20, 25};
        int target = 2;
        int index = insertionSearch(data, 0, data.length - 1, target);
        if (index > -1) {
            System.out.println("found ：" + index);
        } else {
            System.out.println("not found");
        }
    }

    /**
     * 插值查找实现
     *
     * @param data   已排序数组(这里假设是从小到大排序)
     * @param from   起始位置
     * @param to     终止位置
     * @param target 要查找的值
     * @return 要查找的值在数组中的位置，如果没找到则返回-1
     */
    private static int insertionSearch(int[] data, int from, int to, int target) {
//        差值查找的核心，自适应性的关键点确定方式，使得起点更接近关键点。
        int midIndex = from + (target - data[from]) / (data[to] - data[from]) * (to - from);
        System.out.println(String.format("Checking mid index %s", midIndex));

        if (data[midIndex] == target) {
            return midIndex;
        }

        if (data[midIndex] < target) {//中间的值比目标值小，则在左半边继续查找
            return insertionSearch(data, midIndex + 1, to, target);
        } else if (data[midIndex] > target) {//中间的值比目标值大，则在右半边继续查找
            return insertionSearch(data, from, midIndex - 1, target);
        }

        return -1;
    }
}
