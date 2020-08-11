package com.jtang.alg.practices.sn1;

/**
 * Problem description: count the countries in a matrix,
 * matrix example: <a href="file: /resources/sn1.png">sn1.png</a>
 *
 */
public class ColorCountries {
    public static void main(String[] args) {
        int[][] sourceMatrix = {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        System.out.println(sourceMatrix.length);
        System.out.println(sourceMatrix[1].length);
        int[][] matrixFlags = new int[sourceMatrix.length][sourceMatrix[0].length];

        int countIndex = 0;

        for (int i = 0; i < sourceMatrix.length; i++) {
            for (int j = 0; j < sourceMatrix[0].length; j++) {
                System.out.println("checking from center: " + i + ", " + j);
                System.out.println("flag value: " + matrixFlags[i][j] + ", now value: " + sourceMatrix[i][j]);
                int currentValue = sourceMatrix[i][j];
                if (matrixFlags[i][j] == 0) {
                    matrixFlags[i][j] = 1;
                    countIndex++;
                    doCenterCheck(currentValue, sourceMatrix, matrixFlags, i, j);
                } else {
                    System.out.println("already colored, skip.");
                }
            }
        }

        System.out.println("colors: " + countIndex);
    }

    private static void clearFlag(int[][] flags) {
        for (int i = 0; i < flags.length; i++) {
            for (int j = 0; j < flags[0].length; j++) {
                flags[i][j] = 0;
            }
        }
    }

    private static void doCenterCheck(int currentValue, int[][] a, int[][] flags, int i, int j) {
        System.out.println("scan checking: " + i + ", " + j);
//        try {
//            Thread.sleep( 500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        doNeighborCheckAndFlag(currentValue, a, flags, i, j - 1);
        doNeighborCheckAndFlag(currentValue, a, flags, i - 1, j);
        doNeighborCheckAndFlag(currentValue, a, flags, i, j + 1);
        doNeighborCheckAndFlag(currentValue, a, flags, i + 1, j);
    }

    private static void doNeighborCheckAndFlag(int nowValue, int[][] a, int[][] flags, int i, int j) {
        int rows = a.length;
        int columns = a[0].length;

        if (i < 0 || i >= rows) {
            return;
        }
        if (j < 0 || j >= columns) {
            return;
        }
        if (flags[i][j] == 1) {
            return;
        }

        if (nowValue == a[i][j] && flags[i][j] == 0) {
            flags[i][j] = 1;
            doCenterCheck(nowValue, a, flags, i, j);
        }

    }
}
