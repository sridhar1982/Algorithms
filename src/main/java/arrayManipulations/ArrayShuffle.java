package arrayManipulations;

import java.util.Arrays;
import java.util.Random;

/**
 * fischer yeats shuffle algorithm
 */
public class ArrayShuffle {

    public static void main(String[] args){
        Random r = new Random();
        int[] input = {1,2,3,4,5};
        shuffle(input);
        System.out.println(Arrays.toString(input));
    }

    public static void shuffle(int[] arr) {

        int len = arr.length-1;
        Random r = new Random();

        while (len > 0) {
           int index = (int)(Math.floor(r.nextDouble() * len));
           swap(arr,index, len);
           len--;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
