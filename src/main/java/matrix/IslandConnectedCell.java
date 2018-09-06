package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 1 0 0 0 1
 * 1 1 1 1 1
 * 0 0 1 0 0
 * 1 1 0 1 1
 *
 * total no of islands = 2
 * longest island = 10
 */
public class IslandConnectedCell {

    public static void main(String[] args) {

        int[][] input = {
                {1,0,0,0,1},
                {1,1,1,1,1},
                {0,0,0,0,0},
                {1,1,0,1,1}
        };

        dfsIsland(input);

    }


    public static void dfsIsland(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        List<Integer> countList = new ArrayList<>();

        boolean visited[][] = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (input[row][col] == 1 && !visited[row][col]) {
                    int count = mark(row, col, input, visited, rows, cols);
                    countList.add(count);
                }
            }
        }
        System.out.println(countList);

    }

    public static int mark(int row, int col, int[][] input, boolean[][] visited, int rows, int cols) {

        if (row >= rows || row < 0 || col >= cols || col < 0) {
            return 0;
        }

        if (input[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int count=1;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i != row || j != col) {
                 count+=mark(i, j, input, visited, rows, cols);
                }
            }
        }
        return count;
    }



}
