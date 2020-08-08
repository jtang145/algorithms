package com.jtang.alg.sort.compare;

import java.util.Arrays;

/**
 * 堆排序demo
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {6, 7, 8, 9, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            /**
             * 从第一个非叶子结点从下至上，从右至左调整结构
             * 相当于局部调整
             */
            adjustHeap(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Reordering...");
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            /**
             * 基于已有的大顶堆，
             * 2.1, 将堆顶元素与末尾元素进行交换, 相当于每次选出最大值放在最后
             */
            swap(arr, 0, j);
            /**
             * 2.2，将剩下的元素重新生成大顶堆，也就是找到最大元素放到堆顶
             */
            adjustHeap(arr, 0, j);//重新对堆进行调整
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param currentIndex
     * @param length
     */
    public static void adjustHeap(int[] arr, int currentIndex, int length) {
        int temp = arr[currentIndex];//先取出当前元素i
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = currentIndex * 2 + 1; k < length; k = k * 2 + 1) {
            //左右比较：如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //上下比较： 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[currentIndex] = arr[k];
                currentIndex = k;
            } else {
                break;
            }
        }
        arr[currentIndex] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
