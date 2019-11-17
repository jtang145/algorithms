package com.jtang.alg.sort;

import java.util.Arrays;

public class InsertionSort extends SwapAction {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr,j,j-1);
                j--;
            }
        }
    }
}
