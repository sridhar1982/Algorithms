package arrayManipulations;

import java.util.ArrayList;
import java.util.List;

/**
 * input {1,2,3,4} and k = 2
 * output is {1,2}, {1,3}, {1,4}, {2,3}, {2,4}, {3,4}
 * combination formula (n!/(r! * (n-r)!)
 */
public class SizeKSubset {

    public static void main(String[] args){
        List<List<Integer>> resulSet = new ArrayList<>();
        int[] input = new int[]{1,2,3,4};
        boolean[] used = new boolean[4];
        sizeKSubset(input, 2, 0,0, used, resulSet);
        System.out.println(resulSet.size());
        System.out.println(resulSet);

        used = new boolean[4];
        resulSet.clear();
        sizeKSubset(input, 3, 0,0, used, resulSet);
        System.out.println(resulSet.size());
        System.out.println(resulSet);



    }

    public static void sizeKSubset(int[] input, int k, int currentSize, int startIndex, boolean[] used, List<List<Integer>> resultSet){

        if (currentSize==k){
            resultSet.add(printSubset(input, used));
            return;
        }

        if (startIndex>=input.length){
            return;
        }

        used[startIndex]=true;
        sizeKSubset(input, k, currentSize+1, startIndex+1, used, resultSet);
        used[startIndex]=false;
        sizeKSubset(input, k, currentSize, startIndex+1, used, resultSet);
    }

    public static List<Integer> printSubset(int[] input, boolean[] used){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< used.length; i++) {
            if (used[i]){
                result.add(input[i]);
            }
        }
        return result;
    }
}
