package arrayManipulations;

/**
 * all subsets of given array (2^n)
 * {1,2}- > {}, {1}, {2}, {1,2}
 * {1,2,3} -> {}, {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, {1,2,3}
 */
public class AllSubsets {

    public static void main(String[] args){
        subsets(new int[]{1,2}, 0, new boolean[2]);
        System.out.println("**********");
        subsets(new int[]{1,2,3}, 0, new boolean[3]);


    }

    public static void subsets(int[] input, int index, boolean[] used){
        if (index == input.length) {
            printSubset(input, used);
            return;
        }
        used[index]=true;
        subsets(input, index+1, used);
        used[index]=false;
        subsets(input, index+1, used);
    }

    public static void printSubset(int[] input, boolean[] used){
        System.out.print("{ ");
        for (int i=0; i< used.length; i++) {
            if (used[i]){
                System.out.print(input[i] + " ");
            }
        }
        System.out.println("}");
    }
}
