package com.jtang.alg.practices;

public class LevenshteinDistanceDynamicProgramming {
    private char[] sourceChars;
    private char[] destinationChars;
    private int sourceLength;
    private int destinationLenght;

    public LevenshteinDistanceDynamicProgramming(char[] source, char[] destination) {
        this.sourceChars = source;
        this.destinationChars = destination;
        this.sourceLength = this.sourceChars.length;
        this.destinationLenght = this.destinationChars.length;
    }

    public int distance() {
        int[][] disMatrix = new int[this.sourceLength][this.destinationLenght];
        //init the first 0 row
        for (int j = 0; j < destinationLenght; ++j) {
            if (sourceChars[0] == destinationChars[j]) {
                disMatrix[0][j] = j;
            } else if (j != 0) {
                disMatrix[0][j] = disMatrix[0][j - 1] + 1;
            } else {
                disMatrix[0][j] = 1; //in case the first element
            }
        }
        //init the first 0 column
        for (int i = 0; i < sourceLength; ++i) {
            if (destinationChars[0] == sourceChars[i]) {
                disMatrix[i][0] = i;
            } else if (i != 0) {
                disMatrix[i][0] = disMatrix[i - 1][0] + 1;
            } else {
                disMatrix[i][0] = 1;
            }
        }
        //dynamic programming
        for (int i = 1; i < sourceLength; ++i) {
            for (int j = 1; j < destinationLenght; ++j) {
                if (sourceChars[i] == destinationChars[j]) {
                    disMatrix[i][j] = min(disMatrix[i - 1][j - 1], disMatrix[i - 1][j] + 1, disMatrix[i][j - 1] + 1);
                } else {
                    disMatrix[i][j] = min(disMatrix[i - 1][j - 1] + 1, disMatrix[i - 1][j] + 1, disMatrix[i][j - 1] + 1);
                }
            }
        }

        return disMatrix[sourceLength - 1][destinationLenght - 1];
    }

    private int min(int x, int y, int z) {
        int minValue = Integer.MAX_VALUE;
        if (x < minValue) minValue = x;
        if (y < minValue) minValue = y;
        if (z < minValue) minValue = z;
        return minValue;
    }

    public static void main(String[] args){
        LevenshteinDistanceDynamicProgramming tester =
                new LevenshteinDistanceDynamicProgramming("mitcmu".toCharArray(), "mtacnu".toCharArray());
        System.out.println("The min value: " + tester.distance());
    }
}
