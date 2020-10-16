package com.jtang.alg.practices;

public class KnapsackLessSpace {


    public static int dopack(int[] weights, int count, int weightCapacity) {
        /**
         * Use one-dimension array to replace two-dimension array
         */
        boolean[] states = new boolean[weightCapacity + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weights[0] <= weightCapacity) {
            states[weights[0]] = true;
        }
        for (int i = 1; i < count; ++i) { // 动态规划
            for (int j = weightCapacity - weights[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j] == true) states[j + weights[i]] = true;
            }
        }
        for (int i = weightCapacity; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weights = {2, 2, 4, 6, 3};
        KnapsackLessSpace tester = new KnapsackLessSpace();
        int max = tester.dopack(weights, 4, 9);
        System.out.println("Max value is: " + max);
    }

}
