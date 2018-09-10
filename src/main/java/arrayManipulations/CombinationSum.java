package arrayManipulations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * input [1, 2, 3, 5, 6, 7, 10]
 *target is 8; resultList is [[1, 2, 5], [1, 7], [2, 6], [3, 5]]
 *
 * input list must be sorted
 */
public class CombinationSum {

    public static void main(String[] args) {

        //int[] input = {10,1,7,2,5,3,6};
        //int[] input = {1,2,3,5,6,7,10};
        int[] input = {8,7,6,3};
        int target = 15;
        Set<Set<Integer>> set = new HashSet<>();
        combinations(input, target, 0, set, new ArrayList<>());
        System.out.println(set);
        printCoinChangingSolution(target, input);
        input = new int[]{1, 2, 3, 5, 6, 7, 10};
        target = 8;
        printCoinChangingSolution(target, input);

    }

    public static void combinations(int[] input, int total, int start, Set<Set<Integer>> resultSet, List<Integer> temp) {

        for (int i = start; i< input.length; i++) {

            if (input[i] == total) {
                temp.add(input[i]);
                Set<Integer> set = new HashSet<>(temp);
                if (!resultSet.contains(set)){
                    resultSet.add(set);
                }
            }
            else if (input[i] < total) {
                temp.add(input[i]);
                combinations(input, total-input[i], i+1, resultSet, temp);
            }
            else
                return;
            if (temp.size() > 0) {
                temp.remove(temp.size() -1);
            }
        }
    }

    public static void printCoinChangingSolution(int total,int coins[]){
        List<Integer> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        printActualSolution(result, total, coins, 0, set);
        System.out.println(set);
    }

    private static void printActualSolution(List<Integer> result,int total,int coins[],int pos, Set<List<Integer>> resultSet ){
        if(total == 0){
            //Set<Integer> set = new HashSet<>(result);
            List<Integer> r = new ArrayList<>(result);
                resultSet.add(r);
                return;
        }
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
                printActualSolution(result,total-coins[i],coins,i, resultSet);
                result.remove(result.size()-1);
            }
        }
    }

}

