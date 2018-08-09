package dynamicProg;

import java.util.Arrays;

/**
 *
 * given a sum and list of coins, give all combinations
 * [1,2,3] and sum is 5.
 * result is {(1,1,1,1,1), (1,1,1,2), (3,1,1), (2,2,1}, (2,3)}
 */
public class PermutateCoins {

    public static void main(String[] args) {

        System.out.println(combinations(new int[] {1,2,3}, 5));

    }

    public static int combinations(int[] coins, int total) {

        int[] result = new int[total + 1];

        result[0] = 1;

        for (int j= 1; j<=total; j++) {
            for (int i = 0; i< coins.length; i++ ) {
                if (coins[i] <= j) {
                    result[j]=result[j] + result[j-coins[i]];
                }
            }
        }

        System.out.println(Arrays.toString(result));
        return result[total];




    }

}
