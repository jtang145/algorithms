package com.jtang.alg.practices;

/**
 * Simple 0-1 knapsack problem, dynamic programming.
 */
public class Knapsack {

    //    weights:物品重量，count:物品个数，weightCapacity:背包可承载重量
    public int dopack(int[] weights, int count, int weightCapacity) {
        boolean[][] states = new boolean[count][weightCapacity + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weights[0] <= weightCapacity) {
            states[0][weights[0]] = true;
        }
        for (int i = 1; i < count; ++i) { // 动态规划状态转移
            for (int j = 0; j <= weightCapacity; ++j) {// 不放第i个物品
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= weightCapacity - weights[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true) states[i][j + weights[i]] = true;
            }
        }
        for (int i = weightCapacity; i >= 0; --i) { // 输出结果
            if (states[count - 1][i] == true) {
                System.out.print("Selected pack index: ");
                for(int p=0; p<=i; p++){
                    if(states[count -1][p]){
                        System.out.print(p + ", ");
                    }
                }
                return i;
            }

        }
        return 0;
    }


    public static void main(String[] args) {
        int[] weights = {2, 2, 4, 6, 3};
        Knapsack tester = new Knapsack();
        int max = tester.dopack(weights, 5, 9);
        System.out.println("Max value is: " + max);
    }


}
