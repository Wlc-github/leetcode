package leetcode;

import java.util.Arrays;

public class Exam498 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(a)));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        int index = 0;
        int[] temp = new int[xlen * ylen];
        int i, j;
        boolean isUp = true;
        i = j = 0;
        while (index < xlen * ylen) {
            if (isUp) {
                temp[index++] = matrix[i][j];
                if (j == ylen - 1) {
                    i++;
                    isUp = !isUp;
                } else if (i == 0) {
                    j++;
                    isUp = !isUp;
                } else {
                    i--;
                    j++;
                }
            } else {
                temp[index++] = matrix[i][j];
                if (i == xlen - 1) {
                    j++;
                    isUp = !isUp;
                } else if (j == 0) {
                    i++;
                    isUp = !isUp;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return temp;
    }

}
