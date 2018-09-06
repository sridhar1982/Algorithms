package arrayManipulations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * input [1,4,2,1,3,4,4,3]
 * N=2;
 * Top 2 frequent elements are 4,3,1
 * 2nd frequent element is 3 (or 1)
 *
 */
public class NFrequencyAndNFrequentElements {

    public static void main(String[] args) {

        int[] input = new int[]{1,1,2,3,4};
        NFrequency(input,2);

    }

    public static void NFrequency(int[] input, int freq) {
        int count=0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        //keep index array
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i<= input.length; i++) {
            bucket.add(null);
        }

        for (int i : input) {
            if (freqMap.containsKey(i)){
                count = freqMap.get(i);
            }
            else {
                count = 0;
            }
            freqMap.put(i, count+1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                int frequency = entry.getValue();
                if (bucket.get(frequency) == null) {
                    bucket.set(frequency, new ArrayList<>());
                }
                bucket.get(frequency).add(entry.getKey());
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(0, null);
        int j=1;
        for (int i = bucket.size() -1; i>0; i--) {
            if (bucket.get(i) == null) {
                continue;
            }
            result.add(j, bucket.get(i));
            j++;
        }

        System.out.println("bucket is " + bucket);
        System.out.println("the " + freq + " most frequent element is " + bucket.get(freq));
        System.out.println(freq + " elements are ");
        for (int i = 1; i <=freq; i++) {
            System.out.println(bucket.get(i));
        }
    }
}
