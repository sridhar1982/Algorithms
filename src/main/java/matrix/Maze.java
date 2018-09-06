package matrix;

import java.util.Arrays;

/**
 * https://www.cs.bu.edu/teaching/alg/maze/
 */
public class Maze {


    public static void main(String[] args) {

        int[][] input = {
                {1,0,0,1,0},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,0,1,0,1}
                    };

        System.out.println(findPath(input, 0,3, 4,4));
        for ( int i = 0; i< input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }

    }

    public static boolean findPath(int[][] input, int srcX, int srcY, int destX, int destY) {

        if (srcX >= input.length ||srcX < 0 || srcY >=input[0].length || srcY < 0) {
            return false;
        }

        if (srcX == destX && srcY == destY) {
            input[destX][destY] = 2;
            return true;
        }

        if (input[srcX][srcY] == 0 || input[srcX][srcY] == 2) {
            return false;
        }

        //mark part of solution graph
        input[srcX][srcY] = 2;
        //north
        if (findPath(input, srcX-1, srcY, destX, destY)) return true;
        //south
        if (findPath(input, srcX+1, srcY, destX, destY)) return true;
        //east
        if (findPath(input, srcX, srcY-1, destX, destY)) return true;
        //west
        if (findPath(input, srcX, srcY+1, destX, destY)) return true;
        //unmark
        input[srcX][srcY] = 1;
        return false;
    }
}
