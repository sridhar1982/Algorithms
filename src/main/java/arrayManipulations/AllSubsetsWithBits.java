package arrayManipulations;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * a variation using bits to print all subsets of array
 * generate bits from 0 to 2^n -1.
 * https://www.quora.com/Given-an-array-of-size-n-how-do-you-find-all-the-possible-subsets-of-the-array-of-size-k
 */
public class AllSubsetsWithBits {

    public static void main(String[] args){

        subsets(new int[]{1,2,3});

    }

    public static void subsets(int[] input) {

        int n = input.length;
        int end = (int) Math.pow(2, n) - 1;
        for (int i = 1; i <= end; i++) {
            BitSet set = convert(i);
            printSet(set, input);
        }
    }

    public static BitSet convert(int value) {
        BitSet bits = new BitSet(4);
        int index = 0;
        while (value > 0) {
            if (value % 2!= 0) {
                bits.set(index);
            }
            ++index;
            value = value >> 1;
        }
        //System.out.println(bits);
        return bits;
    }

    public static void printSet(BitSet set, int[] input){

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.length; i++){
            if (set.get(i)){
               output.add(input[i]);
            }
        }
        System.out.println(output);

    }
}
