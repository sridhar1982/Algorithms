package stringManipulations;

import java.util.HashMap;
import java.util.Map;

/**
 * given a string, return the longest substring with unique characters
 * eg: abbcdefgglp - > bcdefg
 */
public class LongestStringwithNoDuplicates {

    public static void main(String[] args) {

        System.out.println(longestString("abbcdefgglp"));
        System.out.println(longestString("aaaabcccbbaa"));
        System.out.println(longestString("aaaaa"));
        System.out.println(longestString("abcabcabcabc"));
        System.out.println(longestString("abcdeabcdabca"));

    }

    public static String longestString(String input) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int startIdx = 0;
        int endIdx = 0;
        int maxLen = 0;
        int tempStartIdx = 0;
        int tempEndIdx = 0;
        for (int i =0; i<input.length(); i++) {
            if (!charIndexMap.containsKey(input.charAt(i))) {
                charIndexMap.put(input.charAt(i), i);
            }
            else {
                int idx = charIndexMap.get(input.charAt(i));
                tempEndIdx = i;
                if (tempEndIdx-tempStartIdx > maxLen) {
                    maxLen = tempStartIdx - tempEndIdx;
                    startIdx = tempStartIdx;
                    endIdx = tempEndIdx;
                }
                 tempStartIdx=idx+1;
                idx--;
                while(idx>=0) {
                    charIndexMap.remove(input.charAt(idx));
                    idx--;
                }
            }
        }
        return input.substring(startIdx, endIdx);
    }
}
