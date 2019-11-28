package com.jtang.alg.search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] data = {2, 1, 4, 6, 12, 7};
        int target = 12;
        int searchIndex = search(data, target);
        if (searchIndex != -1) {
            System.out.println("found at: " + searchIndex);
        }else {
            System.out.println("not found");
        }
    }
    /*
     *@param  data   待查找的数组
     *@param  target 待查找的值
     *@return int    目标值在数组中的索引，如果没找到返回-1
     */
    public static int search(int[] data, int target) {

        int length = data.length;

        //从头遍历数组中的各个值，如果找到目标值就返回其索引
        for (int i = 0; i < length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        //代码能走到这一步就说明上面的循环遍历结束了也没找到目标值
        //即目标值不存在于数组中
        return -1;

    }
}
