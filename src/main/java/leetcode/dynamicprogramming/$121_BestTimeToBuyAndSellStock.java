package leetcode.dynamicprogramming;

public class $121_BestTimeToBuyAndSellStock {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     */

    /**
     * dp
     * <p>
     * initial:
     * sell = 0 (sell表示不持有股票的最大利润)
     * hold = -prices[i] （hold表示持有股票的最大利润）
     * <p>
     * func:
     * sell = max(sell, hold + prices[i]);   （第i天不持有股票的最大利润 = MAX（第i-1天不持有股票的最大利润，第i天卖出））
     * hold = max(hold, -prices[i]);  （第i天持有股票的最大利润 = MAX（第i-1天持有股票的最大利润，第i天买入））
     */
    public int maxProfit_1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int sell = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }

        return Math.max(sell, hold);
    }

    /**
     * 定义lowest price,存储prices[0..i]的最小值
     * maxProfit = Math.max(maxProfit, prices[i] - lowest price)
     */
    public int maxProfit_2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int lowestPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            maxProfit = Math.max(maxProfit, price - lowestPrice);
        }

        return maxProfit;
    }
}
