package com.jtang.alg.practices;

public class SimpleKnapsackProblem {

    private int maxWeight = Integer.MIN_VALUE; //存储背包中物品总重量的最大

    private int capacity;
    private int count;
    // cw表示当前已经装进去的物品的重量和；
    // i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；
    // n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10)

    public SimpleKnapsackProblem(int capacity, int count) {
        this.capacity = capacity;
        this.count = count;
    }

    public void packageAll(int[] items) {
        doPack(0, items[0], items);
    }

    public void showMax() {
        System.out.println("My max weight: " + this.maxWeight);
    }

    /**
     * @param item          current object item
     * @param currentWeight current total weight
     * @param items         weight of each item
     */
    private void doPack(int item, int currentWeight, int[] items) {
        System.out.println("Process item: " + item);
        if (currentWeight == capacity || item == count) { // currentWeight==w表示装满了;item==n表示已经考察完所有的物品
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
            System.out.println("return with item: " + item);
            return;
        }
        doPack(item + 1, currentWeight, items);
        if (currentWeight + items[item] <= capacity) {// 已经超过可以背包承受的重量的时候，就不要再装了
            System.out.println("add item index: " + item + ", current weight: " + currentWeight + ", adding weight: " + items[item]);
            doPack(item + 1, currentWeight + items[item], items);
        }
    }

    public static void main(String[] args) {
        int[] weights = {3, 20, 3, 20, 15, 16, 17, 8, 9, 10};
        SimpleKnapsackProblem test = new SimpleKnapsackProblem(100, weights.length);
        test.packageAll(weights);

        test.showMax();
    }
}
