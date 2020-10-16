package com.jtang.alg.practices;


/**
 * 简单回溯算法实现0-1背包问题，分析过程可以借助决策树进行：
 *                                      f(0,0)
 *                          --------0------|-------1--------
 *                         |                               |
 *                     f(1,0)                           f(1,2)
 *            -----0------|---1----             -----0-----|---1---
 *            |                   |             |                 |
 *          f(2,0)             f(2,2)         f(2,2)           f(2,4)
 *      ---0--|--1-        ---0--|--1-       --0--|--1-       --0--|--1---
 *      |         |        |        |       |        |       |          |
 *  f(3, 0)   f(3,4)    f(3,2)  f(3,6)   f(3,2)   f(3,6)   f(3,4)     f(3,8)
 *
 */
public class KnapsackSimpleSolution {

    private int maxWeight = Integer.MIN_VALUE; //存储背包中物品总重量的最大

    private int capacity;
    private int count;
    // cw表示当前已经装进去的物品的重量和；
    // i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；
    // n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10)

    //Optional: 避免重复运算，缓存相同组合的结果
    private boolean [][] cache;

    public KnapsackSimpleSolution(int capacity, int count) {
        this.capacity = capacity;
        this.count = count;
        this.cache = new boolean[count][capacity + 1];
    }

    public void packageAll(int[] items) {
        doPack(0, 0, items);
    }

    public int showMax() {
        System.out.println("");
        System.out.println("My max weight: " + this.maxWeight);
        return this.maxWeight;
    }

    /**
     * @param itemIndex     current object itemIndex
     * @param currentWeight current total weight
     * @param items         weight of each itemIndex
     */
    private void doPack(int itemIndex, int currentWeight, int[] items) {
        System.out.println("Process itemIndex: " + itemIndex);
        if (currentWeight == capacity || itemIndex == (count - 1)) {
            // currentWeight==w表示装满了;itemIndex==n表示已经考察完所有的物品
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
            System.out.println("complete one group, max value: " + maxWeight + ", current value: " + currentWeight);
            return;
        }
        if(cache[itemIndex][currentWeight]) return;
        cache[itemIndex][currentWeight] = true;
        doPack(itemIndex + 1, currentWeight, items);
        if (currentWeight + items[itemIndex] <= capacity) {// 已经超过可以背包承受的重量的时候，就不要再装了
//            System.out.println("add item index: " + itemIndex + ", current weight: " + currentWeight + ", adding weight: " + items[itemIndex]);
            doPack(itemIndex + 1, currentWeight + items[itemIndex], items);
        }
    }

    public static void main(String[] args) {
        int[] weights = {2, 2, 4, 6, 3, 8, 9, 10};
        KnapsackSimpleSolution test = new KnapsackSimpleSolution(9, 4);
        test.packageAll(weights);

        int max = test.showMax();
    }
}
