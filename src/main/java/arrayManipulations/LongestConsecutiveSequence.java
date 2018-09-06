package arrayManipulations;

import java.util.HashSet;
import java.util.Set;

/**
 * [2,1,5,9,4,3] -> [1,2,3,4,5]
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        longest(new int[] {2,1,5,9,4,3});

    }

    public static int longest(int[] input) {

        int maxCount = 0;
        Set<Integer> result = new HashSet<>();

        Set<Integer> set = new HashSet<>();
        for (int i : input) {
            set.add(i);
        }

        for (int i : input) {
            int tempCount = 1;
            Set<Integer> temp = new HashSet<>();
            temp.add(i);
            int left = i-1;
            while (set.contains(left)) {
                temp.add(left);
                set.remove(left);
                tempCount++;
                left--;
            }

            int right = i+1;
            while (set.contains(right)) {
                temp.add(right);
                set.remove(right);
                tempCount++;
                right++;
            }

            if (tempCount > maxCount) {
                maxCount = tempCount;
                result = new HashSet<>(temp);
            }
        }

        System.out.println(result);
        return maxCount;


    }
}
