package stringManipulations;

import java.util.HashSet;
import java.util.Set;

/**
 *  LongestSubstringWithKUniqueChars
 *  input (aabbcdeeeeggi,3) = eeeeggi
 *
 */
public class SubStringWithKUniqueChars {

        public static void main(String[] args){

            System.out.println(longestSubStringWithUniqueK("aabbcdeeeeggi", 3));
            System.out.println(longestSubStringWithUniqueK("aabbcdeeeeggi", 2));

            System.out.println(bruteForce("aabbdeeeeggi", 3));
            System.out.println(bruteForce("aabbcdeeeeggi", 2));

        }

        public static String longestSubStringWithUniqueK(String input, int k){
            int len = input.length();
            Set<Character> unique = new HashSet<>();

            int i = 0;
            int j = 0;
            int count = 0;
            int maxStartIndex = 0;
            int maxEndIndex  = 0;
            int maxLen = 0;
            char[] inputArr = input.toCharArray();

            while (i<len){

                if (count==k && j -i > maxLen){
                    maxStartIndex = i;
                    maxEndIndex = j;
                    maxLen = maxEndIndex - maxStartIndex;
                }
                if (count<k && j<len){
                    if (unique.add(inputArr[j])){
                        count++;
                    }
                    j++;
                }
                else {
                    if (unique.remove(inputArr[i])){
                        count--;
                    }
                    i++;
                }
            }
            return input.substring(maxStartIndex,maxEndIndex);
        }


        public static String bruteForce(String input, int k){
            Set<Character> set = new HashSet<Character>();

            int maxSize = 0;
            int maxStart = 0;
            int maxEnd = 0;

            for (int i=0;i<input.length();i++){
                for (int j=i;j<input.length();j++){
                    if (set.size()>k){
                        if (j-i>maxSize){
                            maxSize=j-i;
                            maxStart=i;
                            maxEnd=j-1;
                        }
                        set.clear();
                        break;
                    }
                    set.add(input.charAt(j));
                }
            }
            return input.substring(maxStart,maxEnd);
        }

}

