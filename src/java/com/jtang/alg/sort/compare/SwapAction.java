package com.jtang.alg.sort.compare;

public class SwapAction {

    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
    }
}
