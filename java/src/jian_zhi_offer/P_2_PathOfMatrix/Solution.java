package jian_zhi_offer.P_2_PathOfMatrix;

public class Solution {
    private final static int[][] nexts = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] a, int rows, int cols, char[] str)
    {
        /**
         * 回溯法
         * 注意走过了的就不能再走了，用一个状态数组保存
         */
        if (rows <= 0 || cols <= 0){
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] visited = new boolean[rows][cols];
        char[][] matrix = buildMatrix(a);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (canWalk(matrix, str, 0, visited, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean canWalk(char[][] matrix, char[] str, int curIndex, boolean[][] visited, int r, int c){
        if (curIndex == str.length){
            return true;
        }
        if (r < 0 || r >= this.rows || c < 0 || c >=this.cols || matrix[r][c] != str[curIndex] || visited[r][c]){
            return false;
        }
        // 能走的话把当前标成visit，继续往四周走；
        visited[r][c] = true;
        for (int[] next : nexts){
            if (canWalk(matrix, str, curIndex + 1, visited, r + next[0], c + next[1])){
                return true;
            }
        }
        // 发现四周走不通，退出当前格，visited标为FALSE；
        visited[r][c] = false;
        return false;
    }
    private char[][] buildMatrix(char[] a){
        char[][] res = new char[this.rows][this.cols];
        for (int i = 0; i < a.length; i++){
            res[i/cols][i%cols] = a[i];
        }
        return res;
    }
}
