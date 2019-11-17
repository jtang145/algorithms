package com.jtang.alg.sort;

public class QuickSort_Start extends SwapAction {


    public static void quickSort(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        int base = arr[low];
        int i = low;
        int j = high;
        while (i < j){
            while (arr[j] >= base && i < j){
                j --;
            }

            while (arr[i] <= base && i <j ){
                i ++;
            }
            if(i < j){
                swap(arr, i, j);
            }

        }
    }
}
