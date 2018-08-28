package interviewQuestions;

import java.util.Arrays;

/**
 * given an integer array such as [55,81,5,10] the result should be 8155510
 */
public class findMaxNumberfromArray {

    public static void main(String[] args) {
        Integer[] input = {55,81,5,10};
        //insertionSort(input);
        shuffleToformMax(input);
//        Arrays.sort(input, new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                String x = String.valueOf(i1);
//                String y = String.valueOf(i2);
//                String xy=x + y;
//                String yx=y + x;
//                return xy.compareTo(yx) > 0 ? -1:1;
//            }
//        });

        System.out.println(Arrays.toString(input));
    }

    //do like insertion sort
    public static void shuffleToformMax(Integer[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j=i; j>0 && customCompare(input[j],input[j-1]);j--) {
                int temp = input[j-1];
                input[j-1]=input[j];
                input[j]= temp;
            }
        }

    }

    //do like insertion sort
    public static void insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j=i; j>0 && input[j]<input[j-1];j--) {
                int temp = input[j-1];
                input[j-1]=input[j];
                input[j]= temp;
            }
        }
    }

    public static boolean customCompare(int i1, int i2) {
        String x = String.valueOf(i1);
        String y = String.valueOf(i2);
        String xy=x + y;
        String yx=y + x;

        int val =  xy.compareTo(yx);

        if (val>0) {
            return true;
        }
        return false;

    }


}





