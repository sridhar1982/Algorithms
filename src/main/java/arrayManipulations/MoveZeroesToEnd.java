package arrayManipulations;

import java.util.Arrays;

/**
 * [1,0,2,0,4,5,0,0,6] = [1,2,4,5,6,0,0,0,0]
 */
public class MoveZeroesToEnd {

    public static void main(String[] args) {

        moveZeroes(new int[] {1,0,2,0,4,5,0,0,6});
        moveZeroes(new int[] {0,0,0,0,4,5,6,0,0});
        moveZeroes(new int[] {4,5,6,0,0,0,0,0,0});

    }

    public static void moveZeroes(int[] input) {

        int count=0;
        for (int i =0;i < input.length;i++) {
            if (input[i]!=0){
                input[count]=input[i];
                count++;
            }
        }

        //System.out.println(Arrays.toString(input));

        for (int i=count;i<input.length;i++) {
            input[i]=0;
        }

        System.out.println(Arrays.toString(input));

    }

}
