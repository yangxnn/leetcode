package work.kuaishou;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        help(n, m, a);
    }

    private static void help(int n, int m, int[] a) {
        if (m > n){
            m = n;
        }
        int[][] dp = new int[n + 1][m + 1];
        int tmp = 0;
        for (int i = 1; i < n + 1; i++){
            if (i > m){
                tmp = m;
            } else {
                tmp = i;
            }
            System.out.println(tmp);
            for (int j = 1; j <= tmp; j++){
                dp[i][j] = Math.max(Math.max(dp[i-1][j] + a[i - 1], dp[i-1][j-1]), dp[i-1][j]);
                System.out.println(" " + i + ":" + j + "===" + dp[i][j]);
            }
        }
        System.out.println(dp[n][m]);

    }
}
