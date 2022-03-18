package com.demo;

public class FindInPartiallySortedMatrix {
    /**
     * 面试题4
     * 二维数组中的查找, 找到一个横竖都是由小到大排列的一个 matrix 中是否有某个数字
     *
     */

    public void runTest() {
        int[][] m1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] m2 = {{1,2,8,9,22,333,4444,55555}};
        int[][] m3 = {{888},{889},{890},{891},{892},{900},{1000}};
        int[][] m4 = {};
        test(m1, 15, true);
        test(m1, 5, false);
        test(m2, 5000, false);
        test(m3, 1000, true);
        test(m4, 0, false);

    }

    void test(int[][] matrix, int target, boolean expected) {
        if (findInPartiallySortedMatrix(matrix, target)==expected) {
            System.out.println("right answer");
        } else {
            System.err.println("!!!WRONG answer!!!");
        }
    }

    boolean findInPartiallySortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int i_col;
        for (i_col = 0; i_col < matrix[0].length; i_col++) { // 8
            if (matrix[0][i_col] == target) return true;
            if (matrix[0][i_col] > target) {
                i_col--; // 6
                break;
            }
        }
        if (i_col==matrix[0].length) i_col--;

        int i_row;
        for (i_row = 0; i_row < matrix.length; i_row++) {
            if (matrix[i_row][i_col] == target) return true;
            if (matrix[i_row][i_col] > target) {
                if (-1 == --i_col) break;
                i_row = 0;
            }
        }
        return false;
    }

}
