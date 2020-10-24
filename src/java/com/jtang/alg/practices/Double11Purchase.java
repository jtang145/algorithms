package com.jtang.alg.practices;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 问题：双11满减活动，如何组合想要购买的商品才能达到价值最大化
 */
public class Double11Purchase {

    // items商品价格，count商品个数, discountThreshold表示满减条件，比如200
    public static List<Integer> doSingleBatchPlan(int[] items, int discountThreshold) {
        int count = items.length;
        int outOfValueThrehold = 3;
        int outOfValue = outOfValueThrehold * discountThreshold;
        boolean[][] states = new boolean[count][outOfValue + 1];//超过3倍就没有薅羊毛的价值了
        states[0][0] = true;  // 第一行的数据要特殊处理
        if (items[0] <= outOfValue) {
            states[0][items[0]] = true;
        }
        for (int i = 1; i < count; ++i) { // 动态规划
            for (int j = 0; j <= outOfValue; ++j) {// 不购买第i个商品
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= outOfValue - items[i]; ++j) {//购买第i个商品
                if (states[i - 1][j] == true) states[i][j + items[i]] = true;
            }
        }

        int j;
        for (j = discountThreshold; j < outOfValue + 1; ++j) {
            if (states[count - 1][j] == true) break; // 输出结果大于等于w的最小值
        }
        if (j == outOfValue + 1) {
            System.out.println("Out of value: " + j);
            return null;
        }
        System.out.println(", total value: " + j);
        List<Integer> purchase = new ArrayList<Integer>();
        for (int i = count - 1; i >= 1; --i) { // i表示二维数组中的行，j表示列
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
//                System.out.print(items[i] + " "); // 购买这个商品
                purchase.add(items[i]);
                j = j - items[i];
            } // else 没有购买这个商品，j不变。
        }
        if (j != 0) {
//            System.out.println(items[0]);
            purchase.add(items[0]);
        }
        System.out.println(purchase.toString());
        return purchase;
    }

    public static void main(String[] args) {
        int[] prices = {19, 29, 59, 99, 16, 10, 15, 9, 66};
        System.out.println("Total shopping list: " + Arrays.stream(prices).boxed().collect(Collectors.toList()).toString());
        Double11Purchase.doMultiPlan(prices, 200, 2);
    }

    private static void doMultiPlan(int[] prices, int discountThreshold, int batches) {
        List<Integer> batch = null;
        int[] prices_list = prices;
        for (int i = 0; i < batches; i++) {
            System.out.print("Purchase plan " + i + ": ");
            if (batch != null) {
                List<Integer> _temp = Arrays.stream(prices_list).boxed().collect(Collectors.toList());
//                System.out.println("before remains: " + _temp.toString());
//                System.out.println("batch: " + batch.toString());
                _temp.removeAll(batch);
//                System.out.println("remains: " + _temp.toString());
                prices_list = _temp.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
            }
            if(isTotalPurchase(prices_list, discountThreshold)){
                batch = Arrays.stream(prices_list).boxed().collect(Collectors.toList());
                System.out.println(", total value: " + Arrays.stream(prices_list).sum());
                System.out.println(batch.toString());
            }else {
                batch = Double11Purchase.doSingleBatchPlan(prices_list, discountThreshold);
            }
        }
    }

    private static boolean isTotalPurchase(int[] prices_list, int discountThreshold) {
        return Arrays.stream(prices_list).sum() <= discountThreshold;
    }
}
