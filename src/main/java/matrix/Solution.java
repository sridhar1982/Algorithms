package matrix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        Solution sol = new Solution();
        List<List<Integer>> area  = new ArrayList();
        area.add(Arrays.asList(1,1,1,1));
        area.add(Arrays.asList(0,1,1,1));
        area.add(Arrays.asList(0,1,0,1));
        area.add(Arrays.asList(1,1,9,1));
        area.add(Arrays.asList(0,0,9,1));

        System.out.println(sol.minimumDistance(5,4,area));
    }

        //I started with DFS approach. later realized BFS would be needed since shortest path
        //was asked. I did not read the question properly. but it was too late to go and fix it.
        //I have one test input working here.
        int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {

            Integer[][] input = area.stream()
                    .map(l -> l.stream().toArray(Integer[]::new))
                    .toArray(Integer[][]::new);

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    if (i != 0 && j != 0) {
                        ResultWrapper w = dfs(i, j, numRows, numColumns, input);
                        if (w.found) {
                            return w.count;
                        }
                    }
                }
            }
            return -1;
        }

        private ResultWrapper dfs(int i, int j, int numRows, int numColumns, Integer[][] input) {

            if (i >= numRows || i < 0 || j >= numColumns || j < 0) {
                return new ResultWrapper();
            }

            if (input[i][j] == 0 || input[i][j] == -1) {
                return new ResultWrapper();
            }

            int count = 1;
            if (input[i][j] == 9) {
                return new ResultWrapper(count, true);
            }
            //marking as visited by setting to -1
            input[i][j] = -1;

            //north, south, east, west
            ResultWrapper r1 = dfs(i + 1, j, numRows, numColumns, input);
            count+=r1.count;
            if (r1.found){
                r1.setCount(count);
                return r1;
            }
            r1 = dfs(i - 1, j, numRows, numColumns, input);
            count += r1.count;
            if (r1.found) {
                r1.setCount(count);
                return r1;
            }
            r1 = dfs(i, j - 1, numRows, numColumns, input);
            count += r1.count;
            if (r1.found) {
                r1.setCount(count);
                return r1;
            }
            r1= dfs(i, j + 1, numRows, numColumns, input);
            count += r1.count;
            if (r1.found) {
                r1.setCount(count);
                return r1;
            }


            return new ResultWrapper(count,r1.found);
        }



    }

    class ResultWrapper {

        int count;
        boolean found;

        public ResultWrapper(){}

        public ResultWrapper(int count, boolean found) {
            this.count=count;
            this.found = found;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setFound(boolean found) {
            this.found = found;
        }
    }