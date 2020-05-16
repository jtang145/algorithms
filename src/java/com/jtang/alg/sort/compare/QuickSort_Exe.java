package com.jtang.alg.sort.compare;

import java.util.Arrays;

public class QuickSort_Exe extends SwapAction {

    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {4, 5, 7, 8, 1, 9, 2, 3, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int base = arr[low];
        System.out.println(String.format("|=> base is %s, sorting from %s to %s", base, low, high));
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[j] >= base && i < j) {
                System.out.println(String.format("checked %s and move to %s", arr[j], arr[j - 1]));
                j--;
            }
            if (i < j) {
                System.out.println(String.format("switching %s to index %s of value %s", arr[j], i, arr[i]));
                arr[i] = arr[j];
            }

            while (arr[i] <= base && i < j) {
                System.out.println(String.format("checked %s and move to %s", arr[i], arr[i + 1]));
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = base;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}
