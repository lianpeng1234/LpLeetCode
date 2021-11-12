package com.lp.leetcode.other;

import org.junit.Test;

/**
 * 买卖股票的最佳时机，在数组是降序的情况下，时间复杂度是 O(n^2)
 */
public class LeetCode121 {

    @Test
    public void test() {
        int[] prices = new int[]{2,1,2,1,0,1,2};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int buyTime = -1;
        for (int i = 0; i < prices.length; i++) {
            if (buyTime != -1 && prices[i] >= prices[buyTime]) {
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                    buyTime = i;
                }
            }
        }
        return max;
    }
}
