package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * given a grid of size n * m,
 * find the shortest distance from (0,0) to (i,j) such at grd[i][j] = 9
 * this was asked in amazon
 */
public class FindShortestPath {

    public static void main(String[] args) {

        int[][] arr1 = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 9, 1}
        };

        int[][] arr2 = {
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 9, 1},
                {0, 0, 9, 1}
        };

        System.out.println(minimumDist(arr2, new Range()));
    }

    public static int minimumDist(int[][] input, Range start) {

        Queue<Range> queue = new LinkedList<>();
        queue.add(start);
        int rows = input.length;
        int cols = input[0].length;
        int count=0;

        while (!queue.isEmpty()) {
            Range r = queue.remove();
            int x = r.x;
            int y = r.y;
            count=r.count;
            if (input[x][y]==9) {
                return count;
            }
            input[x][y]=-1;
            if (x+1<rows && input[x+1][y]>0 )
                queue.add(new Range(x+1,y,count+1));
             if (x-1>=0 && input[x-1][y]>0)
                queue.add(new Range(x-1,y,count+1));
            if (y+1<cols && input[x][y+1]>0)
                queue.add(new Range(x,y+1,count+1));
            if (y-1>=0 && input[x][y-1]>0)
                queue.add(new Range(x,y-1,count+1));
        }

        return -1;

    }


    }


class Range {
    int x;
    int y;
    int count;

    public Range(){}

    public Range(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }


}
