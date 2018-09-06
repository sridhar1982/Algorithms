package arrayManipulations;

import java.util.Arrays;
import java.util.Stack;

/**
 * given an array [11,43,2,6,45,1]
 * the next highestElement array would ne [43, 45,6,45, null, null]
 * (when there is no highestElement to the right, return null for that index
 */
public class NextHighestElement {

    public static void main(String[] args){

        System.out.println(Arrays.toString(nextHighestArray(new int[]{11,43,2,6,45,1})));
        System.out.println(Arrays.toString(nextHighestArray(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(nextHighestArray(new int[]{5,4,3,2,1})));
        System.out.println(Arrays.toString(nextHighestArray(new int[]{5,4,3,2,6})));
    }

    //create a stack and keep the elements in ascending order
    //in the end, if any elements left in stack, they all have null higher values
    //i am using indices of input array in stack. you can use elements too
    public static Integer[] nextHighestArray(int[] input){
        Integer[] result = new Integer[input.length];

        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i< input.length; i++) {

            if (input[i] <= input[s.peek()]) {
                s.push(i);
            }
            else {
                while (!s.isEmpty() && input[s.peek()] < input[i]){
                    result[s.pop()]=input[i];
                }
                s.push(i);
            }
        }

        while (!s.isEmpty()) {
            result[s.pop()]=null;
        }
        return result;
    }
}
