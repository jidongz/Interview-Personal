package leetcode.dynamicprogramming;

public class $70_ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */

    /**
     * dp[i] = dp[i-1] + dp[i-2]
     */
    public int climbStairs_1(int n) {
        if (n == 0) {
            return 1;
        }

        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * floor 0 = 0
     * floor 1 = 1
     * floor 2 = 2
     * floor 3 = floor 1 + floor 2 = 1 + 2 = 3
     * floor 4 = floor 2 + floor 3 = 2 + 3 = 5
     * ......
     * floor(n) = floor(n-1) + floor(n-2)
     */
    public int climbStairs_2(int n) {
        if (n < 0) {
            return -1;
        } else if (n <= 2) {
            return n;
        }

        int step1 = 1;
        int step2 = 2;
        int step3 = 0;

        for (int i = 3; i <= n; i++) {
            step3 = step1 + step2;
            step1 = step2;
            step2 = step3;
        }

        return step3;
    }
}
