package com.jtang.alg.sort;

import java.util.Arrays;

public class SelectSort extends SwapAction{

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            /**
             * 每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，
             * 避免每次遇到较小元素都要进行交换。
             *
             * 遍历未排序区域，从前往后排序，每次选择最小的放到前面
             */
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }

}
