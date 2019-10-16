package leetcode;

/**
 * 最佳买卖股票问题3，两次买卖
 * 解题思路，分为两次一次买卖股票问题；
 * 暴力法：将数组遍历一遍求最大值
 * 避免重复计算法：每一次计算前先找出买卖的位置，以买卖的位置进行分割计算
 * 然后再在买卖的位置中进行二次运算，直至买卖的位置不再改变
 */
public class Exam123 {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int len = prices.length;
        int start = 0, end = len;//定义每一次计算买卖位置的起点和终点
        int minIndex, //定义买股票的位置
                maxMoney = 0,//定义最大收益
                maxIndex,//定义卖股票的位置
                minPriceIndex;//定义股票票价最小值
        while (start < end) {
            int money = 0;//定义当前收益最大值
            minIndex = minPriceIndex = start;
            maxIndex = end;
            for (int i = start; i < end; i++) {//找出买卖股票的位置
                if (money <= prices[i] - prices[minPriceIndex]) {
                    money = prices[i] - prices[minPriceIndex];
                    maxIndex = i;
                    minIndex = minPriceIndex;
                }
                if (prices[i] < prices[minPriceIndex])
                    minPriceIndex = i;
            }
            if (money > maxMoney) maxMoney = money;
            maxMoney = Math.max(maxMoney, Math.max(mereMaxProfit(prices, 0, minIndex, len), mereMaxProfit(prices, 0, maxIndex, len)));
            if (start == minIndex && end == maxIndex)
                break;
            start = ++minIndex;
            end = --maxIndex;
        }
        return maxMoney;
    }

    /**
     * 求出以mid为断点的两次股票收益和
     *
     * @param prices 股票票价
     * @param start  起始位
     * @param mid    断点
     * @param end    终止位
     * @return 收益和
     */
    private static int mereMaxProfit(int[] prices, int start, int mid, int end) {
        if (mid < end && mid > start)
            return maxProfit(prices, start, mid) + maxProfit(prices, mid, end - 1);
        return 0;//如果没有断点则无意义
    }

    private static int maxProfit(int[] prices, int start, int end) {
        int maxMoney, minPrice;
        minPrice = prices[start];
        maxMoney = 0;
        for (int i = start; i <= end; i++) {
            if (maxMoney < prices[i] - minPrice) {
                maxMoney = prices[i] - minPrice;
            }
            if (prices[i] < minPrice)
                minPrice = prices[i];
        }
        return maxMoney;
    }
}
