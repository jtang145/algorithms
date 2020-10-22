package com.jtang.alg.practices;

/**
 * 用一个二维数组 states[n][w+1]，来记录每层可以达到的不同状态。
 * 不过这里数组存储的值不再是 boolean 类型的了，而是当前状态对应的最大总价值。
 * 我们把每一层中 (i, cw) 重复的状态（节点）合并，只记录 cv 值最大的那个状态，
 * 然后基于这些状态来推导下一层的状态。
 *
 */
public class AdvanceKnapsack {

    public static int knapsack(int[] weights, int[] values, int count, int capacity) {
        int[][] states = new int[count][capacity + 1];
        for (int i = 0; i < count; ++i) { // 初始化states
            for (int j = 0; j < capacity + 1; ++j) {
                states[i][j] = -1;
            }
        }
        //处理0号：放入，不放入
        states[0][0] = 0;
        if (weights[0] <= capacity) {
            states[0][weights[0]] = values[0];
        }
        for (int i = 1; i < count; ++i) { //动态规划，状态转移
            for (int j = 0; j <= capacity; ++j) { // 不选择第i个物品时，等于上一层大小
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= capacity - weights[i]; ++j) { // 选择第i个物品，
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + values[i];
                    if (v > states[i][j + weights[i]]) { //保留最大值
                        states[i][j + weights[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= capacity; ++j) {
            if (states[count - 1][j] > maxvalue) maxvalue = states[count - 1][j];
        }
        return maxvalue;
    }

    public static void main(String[] args){
        int[] weights = {2, 2, 4, 6, 3};  // 物品的重量
        int[] value = {3, 4, 8, 9, 6}; // 物品的价值

        AdvanceKnapsack ak = new AdvanceKnapsack();
        int maxvalue = ak.knapsack(weights, value, 5, 9);
        System.out.println("Max value is: " + maxvalue);
    }
}
