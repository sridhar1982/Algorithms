package stringManipulations;

import java.util.Arrays;

/**
 * given two strings, compute edit distance
 * eg : abc, abcd should give 1
 * eg: efl, abc should give 3
 * eg: abcd, ad should give 2
 */
public class EditDistance {

    public static void main(String[] args) {

        System.out.println(distance("abc", "abcd" ));
        System.out.println(distance("acdf", "bace"));
        System.out.println(distance("efl", "abc"));
        System.out.println(distance("bace", "a"));
        System.out.println(distance("a", "b"));

    }

    public static int distance(String input1, String input2) {

        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();

        int[][] distances = new int[chars1.length +1] [chars2.length +1];

        for (int i = 1; i <= chars1.length; i++) {
            distances[i][0] = 1;
        }
        for (int j = 1; j <= chars2.length; j++) {
            distances[0][j] = 1;
        }

        for (int i = 1; i <= chars1.length; i++ ){
            for (int j = 1; j <= chars2.length; j++) {

                if (chars1[i-1]==chars2[j-1]) {
                    distances[i][j] = distances[i-1][j-1];
                }
                else {
                    distances[i][j] = min(distances[i-1][j-1], distances[i][j-1], distances[i-1][j]) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(distances));
        return distances[chars1.length][chars2.length];

    }

    public static int min(int i1, int i2, int i3) {
        int temp  = Math.min(i1, i2);
        return Math.min(temp, i3);
    }



}
