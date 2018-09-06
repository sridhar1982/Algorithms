package arrayManipulations;

import java.util.Arrays;

/**
 * given unsorted array : [8,4,3,1,2,5] -
 * k = 2
 * output = 8,5 (no defined order)
 */
public class TopKElements {

    public static void main(String[] args) {

        int[] input = {4,8,3,1,2,5};

//        partition(input, 0, input.length-1);
//
//        input = new int[]{4,8,3,1,2,5};
//        partition2(input, 0, input.length-1);
//        System.out.println("********");
//
//        input = new int[] {5,4,6,1,3};
//        partition(input, 0, input.length-1);
//        input = new int[] {5,4,6,1,3};
//        partition2(input, 0, input.length-1);




        System.out.println(quickSelect(input, 2, 0, input.length-1));
        System.out.println(Arrays.toString(input));

    }

    public static int quickSelect(int[] input, int k, int start, int end) {

        if (start == end) {
            return input[start];
        }

        if (k <= 0 || k > input.length) {
            return -1;
        }

        if (start >= input.length){
            return -1;
        }

        int pivot = partition(input, start, end);
        int size = pivot-start+1;

        if (size == k) {
            return input[pivot];
        }
        else if (size > k) {
            return quickSelect(input,k, start, pivot-1);
        }
        else return quickSelect(input, k-size, pivot+1, end);
    }


    public static int partition(int[] input, int start, int end) {

        int pivot = input[start];
        int temp = start;

        for (int i = start+1; i<=end; i++) {
            if (input[i] < pivot) {
                temp++;
                swap(input, i, temp);
            }
        }
        swap(input, temp, start);
//        System.out.println(temp);
//        System.out.println(Arrays.toString(input));
        return temp;
    }

    public static int partition2(int[] input, int start, int end) {
        int pivot = input[end];
        int pivotIdx = start;

        for (int i = start; i<=end-1; i++) {
            if (input[i] < pivot) {
                swap(input, i, pivotIdx);
                pivotIdx++;
            }
        }
        swap(input, end, pivotIdx);
//        System.out.println(pivotIdx);
//        System.out.println(Arrays.toString(input));
        return pivotIdx;
    }


    public static void swap(int[] input, int i1, int i2) {

        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;


    }
}
