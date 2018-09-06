package interviewQuestions;

import java.util.Arrays;

/**
 * This was asked in microsoft onsite interview
 * given a String ("maefloet") and a character ("e"), find the closest distance between the character and each characters in string
 * output should be [2,1,0,1,2,1,0,1]
 */
public class ClosestDistance {

    public static void main(String[] args) {

        int[] result = distance("maefloet", 'e');
        System.out.println(Arrays.toString(result));
        result = distance("amaefloiet", 'e');
        System.out.println(Arrays.toString(result));
        result = distance("eeeeee", 'e');
        System.out.println(Arrays.toString(result));

    }

    public static int[] distance(String input, char c) {

        int[] result = new int[input.length()];
        Arrays.fill(result, -1);
        boolean found = false;
        int count = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c) {
                found = true;
                result[i] = 0;
                count=0;
                fillArray(result, i - 1);
            }
            else if(found && input.charAt(i)!=c) {
                count++;
                result[i]=count;
            }
        }
        return result;
    }

    public static void fillArray(int[] result, int i) {
            int temp = 1;
            while (i>=0 && (result[i]==-1 || result[i]>temp)) {
                result[i]=temp;
                temp++;
                i--;
            }
    }
}
