package com.jtang.alg.sort.compare;

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

    /**
     *  采用分治思想，通过不断划分大小区间来实现排序。
     *  对于数组区间，通过以下步骤确定一个“基点”位置：
     *  1，分配2个指针，随机选择头部”基点“数作为指针1，再把尾部作为指针2，
     *  2. 从另一边开始比较，大数不变化，小数与首部元素交换，
     *  3. 再从头部开始，小数不变化，大数与尾部元素交换，
     *  4. 不断重复2,3步，直到指针1>=指针2，把“基点”数，赋值给指针1，
     *  划分为新的2个子区间，重复在子区间执行排序
     * @param arr
     * @param low
     * @param high
     */
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
