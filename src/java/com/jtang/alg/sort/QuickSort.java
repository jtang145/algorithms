package com.jtang.alg.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {4, 5, 7, 8, 1, 9, 2, 3, 6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            /**
             * 达到比pivot小的值, 交换比枢轴小的记录到左端
             */
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            /**
             * 交换比枢轴大的记录到右端
             */
            arr[high] = arr[low];
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}
