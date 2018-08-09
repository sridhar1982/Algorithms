package arrayManipulations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * given array find max number for a sliding window k
 * eg: 7,2,5,-1,11,12 for k = 3 should give 7,5,11,12
 * (total possibilities = n-k+1)
 */

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] input = {7,2,5,-1,11,12};
        int[] result = bruteForce(input, 3);
        System.out.println(Arrays.toString(result));
        result = maxSlidingUsingDeque(input, 3);
        System.out.println(Arrays.toString(result));
    }


    public static int[] maxSlidingUsingDeque(int[] input, int k) {
        int[] result =new int[input.length -k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i< k; i++) {
            while(!deque.isEmpty() && input[deque.getLast()] < input[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i<input.length; i++) {
            result[i-k]=input[deque.getFirst()];

            //remove any elements that are not less the current element
            while(!deque.isEmpty() && input[deque.getLast()] < input[i]) {
                deque.pollLast();
            }

            //remove any indices that are not part of current window
            while(!deque.isEmpty() && deque.getFirst() <= i-k) {
                deque.pollFirst();
            }

            deque.addLast(i);
        }

        result[input.length - k] = input[deque.pollFirst()];
        return result;
    }

    public static int[] bruteForce(int[] input, int k) {
        int count=0;
        int[] result =new int[input.length -k + 1];


        for (int i = 0; i< input.length-k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                if (input[j] > max) {
                    max = input[j];
                }
            }
            result[count++]=max;
        }
        return result;
    }

}
