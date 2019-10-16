package leetcode;

public class Exam188 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(maxProfit(1, a));
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int len = prices.length;
        if (k > len / 2)
            return maxProfix(prices);
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++)
            for (int j = k; j > 0; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        return dp[len - 1][k][0];
    }

    public static int maxProfix(int[] prices) {
        int maxMoney = 0;
        for (int i = 1, len = prices.length; i < len; i++) {
            if (prices[i - 1] < prices[i])
                maxMoney += prices[i] - prices[i - 1];
        }
        return maxMoney;
    }
}
