package arrayManipulations;

/**
 * histogram size [5,4,1,6,2]
 * each numbers represent size of histogram bar
 * https://www.youtube.com/watch?v=UzeL2GcLx3Y
 */
public class WaterBarGraph {

    public static void main(String[] args){
        System.out.println(waterFill(new int[]{5,1,3,4}));
        System.out.println(waterFill(new int[]{1,5,2,3,1,7,2,4}));

    }

    public static int waterFill(int[] input){
        //Height of water column = Min(tallest bar on left, tallest bar on right) - bar height
        Integer[] leftTallestBars = new Integer[input.length];
        Integer[] rightTallestBars = new Integer[input.length];

        leftTallestBars[0]=-1;
        rightTallestBars[input.length-1]=-1;

        int maxLeft = input[0];
        int maxRight = input[input.length-1];

        for (int i=1; i<input.length;i++){
            if (input[i] > maxLeft){
                maxLeft=input[i];
            }
            leftTallestBars[i]=maxLeft;
        }

        for (int i= input.length-2;i>=0;i--){
            if (input[i] > maxRight){
                maxRight = input[i];
            }
            rightTallestBars[i]=maxRight;
        }

        int val = 0;
        for (int i=1; i< input.length-1;i++){
            val += Math.min(leftTallestBars[i], rightTallestBars[i]) - input[i];
        }
        return val;
    }

}
