package leetcode;

public class Exam746 {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1};
        System.out.println(minCostClimbingStairs(a));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        int len = cost.length;
        if (len == 2) return cost[0] > cost[1] ? cost[1] : cost[0];
        int[] temp = new int[len];
        temp[0] = cost[0];
        temp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            temp[i] = Math.min(temp[i - 2], temp[i - 1]) + cost[i];
        }
        return Math.min(temp[len - 1], temp[len - 2]);
    }
}
