package arrayManipulations;

import java.util.Arrays;

/**
 *  [2,4,6,-3,2,15] output should be [2,15]
 */
public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {

        increasingSumSequence(new int[]{2,4,6,-3,2,15});

    }

    public static void increasingSumSequence(int[] input) {

        int[] tempSum = new int[input.length];
        int[] indices = new int[input.length];

        for (int i = 0; i< input.length; i++) {
            tempSum[i] = input[i];
            indices[i] = i;
        }

        int maxSum = input[0];
        int maxIndex = 0;

        for (int i = 1; i< input.length; i++) {
            for (int j = 0; j< i; j++) {
                if (input[j] < input[i]){
                    int temp = tempSum[j] + input[i];
                    if (temp > tempSum[i]) {
                        tempSum[i] = temp;
                        indices[i] = j;
                    }

                    if (temp > maxSum) {
                        maxSum = temp;
                        maxIndex = i;

                    }

                }
            }
        }

        System.out.print(input[maxIndex] + " ");
        int next = indices[maxIndex];
        while (next!=maxIndex) {
            maxIndex = next;
            next=indices[maxIndex];
            System.out.print(input[maxIndex] + " ");
        }
        //System.out.print(input[maxIndex]);

        System.out.println();

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(indices));
        System.out.println(Arrays.toString(tempSum));

        System.out.println(maxSum);
    }

}
