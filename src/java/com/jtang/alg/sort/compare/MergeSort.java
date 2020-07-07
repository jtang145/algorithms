package com.jtang.alg.sort.compare;

import java.util.Arrays;

/**
 * 归并排序:
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] arr = {9, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        System.out.println("sorting left "+ left + ", right " + right);
        if (left < right) {
            int mid = (left + right) / 2;
            System.out.println("generated mid: " + mid);
            waitForLog();
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            waitForLog();
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            waitForLog();
            merge_0514(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge_0514(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        while (i <= mid){
            temp[t++] = arr[i++];
        }

        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }

    }

    private static void waitForLog() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println(String.format("merging left: %s, mid: %s, right: %s", left, mid, right));
        int left_start = left;//左序列指针
        int right_start = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        System.out.println(String.format("|<=== from %s to %s", left_start, right));
        while (left_start <= mid && right_start <= right) {
            if (arr[left_start] <= arr[right_start]) {
                temp[t++] = arr[left_start++];
                System.out.println(String.format("|<=== put %s to %s", left_start-1, t-1));
            } else {
                temp[t++] = arr[right_start++];
                System.out.println(String.format("|<=== put %s to %s", right_start-1, t-1));
            }
        }
        while (left_start <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[left_start++];
            System.out.println(String.format("|<=== put %s to %s", left_start-1, t-1));
        }
        while (right_start <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[right_start++];
            System.out.println(String.format("|<=== put %s to %s", right_start-1, t-1));
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
            System.out.println(String.format("|<=== moving %s to %s", t-1, left-1));
        }
    }
}
