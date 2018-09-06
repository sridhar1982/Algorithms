package matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  1 0 0 0 1
 *  1 1 1 1 1    ==> total squares = 6
 *  1 1 1 1 1    ==> largest sqaure is 3 * 3
 *  1 1 1 0 1
 */
public class MaximumAndNoOfSquares {

    public static void main(String[] args) {
        int[][] input = {
                {1,0,0,0,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,0,1}
        };

        int[][] input2 = {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        System.out.println(squares(input2));
        //System.out.println(squares(input));

    }

    //two element list with first one being total and second being largest square
    public static List<Integer> squares(int[][] input) {

        int rows = input.length;
        int cols = input[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

       int[][] cloned =  copyfirstRowAndColumn(input);

       for (int i = 1 ;i < rows; i++ ) {
           for (int j = 1; j< cols; j++ ) {
               if (input[i][j] == 1) {
                   input[i][j] += Collections.min(Arrays.asList(input[i-1][j], input[i-1][j-1], input[i][j-1]));
               }
           }
       }

       for (int i= 1; i<rows; i++ ) {
           for (int j=1; j<cols; j++) {
               if (input[i][j] > 1) {
                   max = Math.max(max, input[i][j]);
                   int val = map.getOrDefault(input[i][j], 0);
                   val+=1;
                   map.put(input[i][j], val);
               }
           }
       }

       System.out.println(map);
       int total = map.values().stream().mapToInt(Number:: intValue).sum();
        return Arrays.asList(total, max);



    }

    private static int[][] copyfirstRowAndColumn(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;

        int[][] cloned = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                if (i == 0 || j == 0) {
                    cloned[i][j] = input[i][j];
                }
            }
        }
        return cloned;
    }
}
