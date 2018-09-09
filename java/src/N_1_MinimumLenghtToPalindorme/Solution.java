package N_1_MinimumLenghtToPalindorme;

public class Solution {
    public int toPalindorme(String str){
        /**
         * dp[i][j]代表第i个字符和第j个字符间的字符串变成回文需要多少步
         * 情况如下：
         *  i > j时，假设无限大
         *  i = j时，已经是回文
         *  i != j时：
         *      str[i] == str[j]   dp[i][j] = dp[i + 1][j - 1]
         *      str[i] != str[j]    dp[i][j] = min(dp[i + 1][j], dp[i][j - 1], dp[i + 1][j - 1]) + 1
         *  说明：
         *  dp[i][j - 1] + 1 代表删除最后一个字符 加上 删除后的字符串变成回文的步数
         *  dp[i + 1][j - 1] + 1 代表将最后一个字符替换为第一个字符 加上中间部分变成回文的步数
         *  dp[i + 1][j] + 1 代表增加一个字符，这个字符等于第一个字符，再加上除去第一个和新增的字符外的字符串变成回文的步数
         */
        int l1 = str.length();
        int[][] dp = new int[l1][l1];
        for (int i = 0; i < l1; i++){
            dp[i][i] = 0;
        }
        for (int j = 0; j < l1; j++){
            for (int i = l1 - 1; i >= 0; i--){
                if (i > j){
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (i == j){
                    dp[i][j] = 0;
                } else if (str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];

                } else if (str.charAt(i) != str.charAt(j)){
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j - 1]), dp[i + 1][j - 1]) + 1;

                }

            }
        }
        return dp[0][l1 - 1];
    }
}
