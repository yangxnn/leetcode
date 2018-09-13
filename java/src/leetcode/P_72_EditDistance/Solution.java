package leetcode.P_72_EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        /**
         * dp[i][j] 代表从头开始，指针指向word1的第i个字符，变成word2从头到第j个字符所需要的编辑数
         * 如 w1：ab; w2: aB 需要的编辑距离有三种：
         *  1. w1删除b字符后从a变成w2的aB编辑数             dp[i][j] = dp[i - 1][j] + 1
         *  2. w1的ab变成w2的a后再往后面添加一个字符B       dp[i][j] = dp[i][j - 1] + 1
         *  3. w1的ab直接把b替换为B                         dp[i][j] = dp[i - 1][j - 1] + 1
         */
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i < l2 + 1; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i < l1 + 1; i++){
            for (int j = 1; j < l2 + 1; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 取三个中最小的加一
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
