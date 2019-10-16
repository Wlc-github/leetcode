package leetcode;

public class Exam62 {
    public static void main(String[] args) {
        System.out.println(combination(1, 1));
    }

    public static int uniquePaths(int m, int n) {
        return combination(m - 1, m + n - 2);
    }

    public static int combination(int m, int n) {
        int[][] temp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            temp[1][i] = i;
            temp[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i && j < m + 1; j++) {
                if (i == j) temp[i][j] = 1;
                temp[j][i] = temp[j - 1][i - 1] + temp[j][i - 1];
            }
        }
        return temp[m][n];
    }
}
