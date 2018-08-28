package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This question was asked in fb first screen.
 * calculate how much time is spent exclusively for a function
 * eg Method A starts 0
 *      -Method B start 2
 *          -Method C starts 2
 *          -Method C ends at 4
 *      -Method B ends at 6
 *      -Method D starts at 8
 *      -Method D ends at 10
 *      -Method A ends at 12
 *
 *  This can be given by following input ([0,12],[2,6],[2,4],[8,10])
 *  output should be [6,2,2,2]
 *
 */
public class MethodTimeSpent {

    public static void main(String[] args) {
        List<Integer[]> input = new ArrayList<>();
        input.add(new Integer[]{0,12});
        input.add(new Integer[]{2,6});
        input.add(new Integer[]{2,4});
        input.add(new Integer[]{8,10});
        int[] output = calculateMethodTimes(input);
        System.out.println(Arrays.toString(output));

    }

    //input is sorted per start time
    public static int[] calculateMethodTimes(List<Integer[]> input) {
        Set<Integer> set = new HashSet<>();
        Integer[] boundary = input.get(0);
        //populate set with all elements
        for (int i=boundary[0];i<=boundary[1];i++){
            set.add(i);
        }

        int[] result = new int[input.size()];

        for (int i = input.size()-1; i>=0; i--) {

            int start = input.get(i)[0];
            int end = input.get(i)[1];

             int count=0;
             for (int k = start; k<end; k++) {
                 if (set.contains(k)){
                     count++;
                     set.remove(k);
                 }
             }
             result[i]=count;
        }
        return result;
    }
}
