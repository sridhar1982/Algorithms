package stringManipulations;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by I855798 on 7/12/18.
 */
public class Permutations {

    public static void main(String[] args) {

        Set<String> result = new HashSet<>();
        permutate("abcd".toCharArray(), 0, result);
        System.out.println(result);

    }

    public static void permutate(char[] input, int start, Set<String> result) {

        if (start >= input.length) {
            result.add(new String(input));
        }
        else {
            for (int i = start; i < input.length; i++) {
                swap(input, start, i);
                permutate(input, start+1, result);
                swap(input, start, i);
            }
        }
    }

    public static void swap(char[] input, int start, int end) {
        char temp = input[start];
        input[start]=input[end];
        input[end] = temp;
    }
}
