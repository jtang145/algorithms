package com.jtang.alg.sort.compare;

import java.util.Arrays;

public class SimpleInsertionSort extends SwapAction {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序: 将数组逐渐变成2个部分，将无序部分，比较后插入到有序数组中去，最后变成一个有序数组。
     *         本实现每次取已排序部分的下一个元素排序、插入。
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            /**
            遍历有序区域，从前向后排序，每次往后增加一个，"插入"到已排的部分
             */
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr,j,j-1);
                j--;
            }
        }
    }
}
