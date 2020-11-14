package com.jtang.alg.practices;

/**
 * The simple solution: back tracking algorithm.
 *
 * 
 */
public class LevenshteinDistanceBackTracking {
    private char[] sourceChars;
    private char[] destinationChars;
    private int sourceLength;
    private int destinationLenght;
    private int minDistance = Integer.MAX_VALUE;

    public LevenshteinDistanceBackTracking(char[] source, char[] destination) {
        this.sourceChars = source;
        this.destinationChars = destination;
        sourceLength = this.sourceChars.length;
        destinationLenght = this.destinationChars.length;
    }

    public void calculateDistance() {
        minDistance(0, 0, 0);
    }

    private void minDistance(int sourceIndex, int destinationIndex, int distance) {
        //condition to end up.
        if (sourceIndex == sourceLength || destinationIndex == destinationLenght) {
            if (destinationIndex < sourceLength) {
                distance += (sourceLength - destinationIndex);
            }
            if (destinationIndex < destinationLenght) {
                distance += (destinationLenght - destinationIndex);
            }
            if (distance < minDistance) {
                minDistance = distance;
            }
            return;
        }
        if (sourceChars[sourceIndex] == destinationChars[destinationIndex]) {
            minDistance(sourceIndex + 1, destinationIndex + 1, distance);
        } else {
            minDistance(sourceIndex + 1, destinationIndex, distance + 1);
            minDistance(sourceIndex, destinationIndex + 1, distance + 1);
            minDistance(sourceIndex + 1, destinationIndex + 1, distance + 1);
        }
    }

    public void printDistance() {
        System.out.println("Min distance is: " + minDistance);
    }


    public static void main(String[] args){
        LevenshteinDistanceBackTracking tester = new LevenshteinDistanceBackTracking("mitcmu".toCharArray(), "mtacnu".toCharArray());
        tester.calculateDistance();
        tester.printDistance();
    }
}
