package arrayManipulations;


import java.util.Arrays;

/**
 *
 * Input  = {12, 34, 45, 9, 8, 90, 3}
 Output = {12, 34, 8, 90, 45, 9, 3}
 */
public class GroupEvenAndOddNumbers {

    public static void main(String[] args) {
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        group(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void group(int[] input) {
        int left = 0;
        int right = input.length-1;

        while (left<right) {
            while (input[left]%2==0 && left<right) {
                left++;
            }
            while (input[right]%2==1 && left<right) {
                right--;
            }
            if (left<right) {
                swap(input, left, right);
            }
        }
    }


    public static void swap(int[] input, int left, int right) {
        int temp = input[right];
        input[right]=input[left];
        input[left]=temp;
    }
}
