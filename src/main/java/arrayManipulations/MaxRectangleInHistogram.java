package arrayManipulations;

import java.util.Stack;

/**
[1,2,6,3,1,7] represents height of bars in histogram, find the maximum area rectangle that can be formed
 */
class MaxRectangleInHistogram {

    public static void main(String[] args) {

        int[] input1 = {1,2,6,3,1,7};
        int[] input2 = {1,2,3};
        int[] input3 = {3,2,1};
        int[] input4 = {4,3,2,3,4};
        int[] input5 = {2,3,4,3,1};

        System.out.println(bruteForce(input1));
        System.out.println(bruteForce(input2));
        System.out.println(bruteForce(input3));
        System.out.println(bruteForce(input4));
        System.out.println(bruteForce(input5));

        System.out.println("*********");

//        System.out.println(maxAreaRectangle(input1));
//        System.out.println(maxAreaRectangle(input2));
//        System.out.println(maxAreaRectangle(input3));
//        System.out.println(maxAreaRectangle(input4));
        System.out.println(maxAreaRectangle(input5));
    }

    //o(n^2)
    public static int bruteForce(int[] input) {
        int max = 0;

        for (int i = 0; i<input.length; i++) {
            int temp = i-1;
            int bars = 1;
            while (temp >=0) {
                if (input[temp] < input[i] ) {
                    break;
                }
                bars++;
                temp--;
            }
            temp = i+1;
            while (temp < input.length) {
                if (input[temp] < input[i]) {
                    break;
                }
                bars++;
                temp++;
            }
            max = Math.max(max, input[i] * bars);
        }
        return max;

    }

    //o(n)
    public static int maxAreaRectangle(int[] input) {

        Stack<Integer> s = new Stack<>();
        int max = 0;
        int area = 0;
        int i = 0;
        while (i<input.length) {

            if (s.isEmpty() || input[s.peek()] <= input[i]) {
                s.push(i);
                i++;
            }
            else {
                int temp = s.pop();
                if (s.isEmpty()) {
                    area = input[temp] * i;
                }
                else {
                    area = Math.max(max, input[temp] * (i - s.peek() - 1));
                }
                max = Math.max(max, area);
            }
        }

        while (!s.isEmpty()) {
            System.out.println("stack is " + s);

            int temp = s.pop();
            if (s.isEmpty()) {
                area = input[temp] * i;
            }
            else {
                area = Math.max(max, input[temp] * (i - s.peek() - 1));
            }
            max = Math.max(max, area);
        }

        return max;

    }
}
