package com.jtang.alg.practices;

/**
 * Knapsack with values
 */
public class AdvanceKnapsackSimple {

    private int maxValue = Integer.MIN_VALUE; // 结果放到maxV中
    private int[] weights = {2, 2, 4, 6, 3};  // 物品的重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int count = 5; // 物品个数
    private int capacity = 9; // 背包承受的最大重量

    private void dopack(int index, int currentWeight, int currentValue) { // 调用f(0, 0, 0)
        if (currentWeight == capacity || index == count) { // currentWeight==w表示装满了，index==n表示物品都考察完了
            if (currentValue > maxValue) maxValue = currentValue;
            return;
        }
        dopack(index + 1, currentWeight, currentValue); // 选择不装第i个物品
        if (currentWeight + weights[index] <= capacity) {
            dopack(index + 1, currentWeight + weights[index], currentValue + value[index]); // 选择装第i个物品
        }
    }

    public void knapsack(){
        dopack(0, 0, 0);

        System.out.println("Max value is: " + this.maxValue);
    }

    public static void main(String[] args){
        AdvanceKnapsackSimple ak = new AdvanceKnapsackSimple();
        ak.knapsack();
    }
}
