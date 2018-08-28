package arrayManipulations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This was asked in google onsie interview in kirkland.
 * for American football, return all possible combinations of scores that can result in a given sum
 * eg: allowed scores are [6,1,2,3]
 * 6-touchdown, 1-one point, 2-two point conversion, 3 - field goal. ignore safety for this calculation
 * note, 1 and 2 is possible only after a touchdown is scored
 * so [1,6] or [2,6] is invalid for a score of 8.
 * This problem is slightly different than CombinationSum.
 * CombinationSum prints only one combination, eg: for a target of 15, only [6,6,3] is returned
 * however, there are three possibilities - [6,6,3], [6,3,6], [3,3,6]
 */

//reduce the problem by having 7 and 8 since a score of 7 or 8 implies [6,1],[6,2]
public class AllCombinationSumUsingMemo {

    public static void main(String[] args){
        int[] scores = {6,3,7,8};
        Map<Integer, List<List<Integer>>> memo = new HashMap<>();
        generateAllCombinationSum(scores, 15, memo);
        System.out.println(memo);

    }

    public static void generateAllCombinationSum(int[] scores, int target, Map<Integer, List<List<Integer>>> memo){

        List<Integer> result = new ArrayList();

        for (int i=1; i<=target; i++){
            for (int j=0; j<scores.length; j++){
                List<List<Integer>> temp = memo.get(i);
                if (scores[j]>i)
                    continue;
                if (temp == null) {
                    temp = new ArrayList<>();
                }
                if (scores[j]==i){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(scores[j]);
                    temp.add(curr);
                    memo.put(i, temp);
                }
                else if(scores[j]<i) {
                    int diff = i-scores[j];
                    if (memo.get(diff)!=null) {
                        List<List<Integer>> t2 = memo.get(diff);
                        for (List<Integer> item : t2){
                            List<Integer> newIem = new ArrayList<>(item);
                            newIem.add(scores[j]);
                            temp.add(newIem);
                            memo.put(i, temp);
                        }
                    }
                }
            }
        }

    }
}
