package stringManipulations;

import java.util.Arrays;

/**
 * input (cdefab, cfeb) = cfb
 */
public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "cfab";
        String s2 = "cfeb";
        System.out.println(lcsRecursive(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lcsDP(s1, s2));
    }

    public static String lcsDP(String s1, String s2){

        int[][] res = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i<=s1.length(); i++) {
            for (int j = 1; j<=s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    res[i][j] = 1 + res[i-1][j-1];
                }
                else {
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }
        }

        for (int[] arr : res){
            System.out.println(Arrays.toString(arr));
        }

        StringBuffer result = new StringBuffer();


        for (int x = s1.length(), y = s2.length(); x!=0 && y!=0;){
            if (res[x][y]==res[x-1][y])
                x--;
            else if (res[x][y]==res[x][y-1])
                y--;
            else
                assert(s1.charAt(x-1) == s2.charAt(y-1));
                result.append(s1.charAt(x-1));
                x--;
                y--;
        }

        return result.reverse().toString();


    }

    public static int lcsRecursive(char[] s1, char[] s2, int s1End, int s2End) {

        if (s1End == 0 || s2End == 0){
                return 0;
        }

        if (s1[s1End-1] == s2[s2End-1]) {
            return 1 + lcsRecursive(s1, s2, s1End-1, s2End-1);
        }
        else {
            return Math.max(lcsRecursive(s1, s2, s1End-1, s2End), lcsRecursive(s1,s2,s1End, s2End-1));
        }
    }
}
