package stringManipulations;

/**
 * given s1 and s2, find minimum length in s1 that has all chars in s2
 *eg: s1 -> "ddadobecutbatc", s2 -> "abc" result -> batc
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 */
public class MinimumSubStringWithAnotherSubString {

    public static void main(String[] args) {

        System.out.println(minString("ddadobecutbatc", "batc"));
        System.out.println(minString("aaaabbbtefcalb", "abc"));

    }

    public static String minString(String s1, String s2) {

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int count=0;
        int start = -1;

        int[] s1Hash = new int[256];
        int[] s2Hash = new int[256];

        for (Character c : s2.toCharArray()) {
             s2Hash[c]++;
        }

        for (int i = 0; i < s1.length(); i++) {
            char t = s1.charAt(i);
            s1Hash[t]++;

            if (s2Hash[t]>0 && s1Hash[t]<=s2Hash[t]) {
                count++;
            }

            if (count==s2.length()) {
                while(s2Hash[s1.charAt(startIdx)]==0 || s1Hash[s1.charAt(startIdx)]>s2Hash[s1.charAt(startIdx)]) {
                    s1Hash[s1.charAt(startIdx)]--;
                    startIdx++;
                }

                if (i-startIdx<minLen) {
                    minLen = i-startIdx;
                    start=startIdx;
                }
            }
        }
        return s1.substring(start, startIdx+minLen+1);
    }

}
