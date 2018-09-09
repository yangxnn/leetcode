package jian_zhi_offer.P_1_RangeOfRobot;

public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        // 使用回溯法，（带有剪枝的dfs过程）
        int res = 0;
        int[][] visited = new int[rows][cols];
        res = countHelp(rows, cols, 0, 0, threshold, visited);
        return res;
    }
    private int countHelp(int rows, int cols, int r, int c, int k, int[][] visited){
        int count = 0;
        if (!canInto(r, c, rows, cols, k, visited)){
            return count;
        }
        visited[r][c] = 1;
        count = countHelp(rows,cols, r + 1, c, k, visited) + countHelp(rows,cols, r, c + 1, k, visited)
                + countHelp(rows,cols, r -1, c, k, visited) + countHelp(rows,cols, r, c - 1, k, visited)
                + 1;
        return count;

    }
    private boolean canInto(int r, int c, int rows, int cols, int k, int[][] visited){
        boolean res = true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] == 1 || (getSum(c) + getSum(r) > k)){
            return false;
        }
        return res;
    }
    private int getSum(int num){
        int res = 0;
        while (num != 0){
            res += (num % 10);
            num = num / 10;
        }
        return res;
    }
}
