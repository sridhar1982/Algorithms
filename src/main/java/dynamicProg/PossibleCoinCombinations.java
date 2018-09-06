package dynamicProg;


import java.util.Arrays;

/**
 * [1,2,5] - coins; sum - 7
 * output:  5 because these combinations are possible  [(1*7),(2,2,2,1), (2,2,1,1,1), (5,1,1), (5,2)]
 * https://www.youtube.com/watch?v=jaNZ83Q3QGc
 **/

public class PossibleCoinCombinations {

    public static void main(String[] args) {

        System.out.println("total combinations " + totalCombinations(new int[]{1, 2, 5}, 7));
    }

    public static int totalCombinations(int[] coins, int sum) {

        int[] combinations = new int[sum + 1];

        combinations[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= sum; i++) {
                if (i >= coins[j]) {
                    combinations[i] += combinations[i - coins[j]];
                }
            }
        }

        System.out.println(Arrays.toString(combinations));
        return combinations[sum];
    }
}
