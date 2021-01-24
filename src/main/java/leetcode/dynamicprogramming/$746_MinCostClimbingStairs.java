package leetcode.dynamicprogramming;

public class $746_MinCostClimbingStairs {

    /**
     * dp[0] = cost[0];
     * dp[1] = cost[1];
     * dp[2] = min(dp[0] + cost[2], dp[1] + cost[2]);
     * ...
     * dp[n] = min(dp[n-2],dp[n-1]) + cost[n]
     */

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
