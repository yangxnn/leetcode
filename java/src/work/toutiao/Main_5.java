package work.toutiao;

import java.util.Scanner;

public class Main_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] reachable = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                reachable[i][j] = i == j;
            }
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            reachable[a - 1][b - 1] = true;
        }
        help(n, reachable);
    }
    private static void help(int n, boolean[][] reachable){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    reachable[i][j] = reachable[i][j]
                            | (reachable[i][k] & reachable[k][j]);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            int j;
            for(j = 0; j < n; j++) {
                if(!reachable[j][i]) {
                    break;
                }
            }
            if(j == n) {
                count++;
            }
        }
        System.out.println(count);
    }
}
