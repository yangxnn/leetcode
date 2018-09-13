package work.toutiao;

import java.util.Scanner;

public class Main_55 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] reachable = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                reachable[i][j] = i == j;
            }
        }
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            reachable[a][b] = true;
            for(int j = 0; j < n; j++) {
                if(!reachable[j][a]) {
                    continue;
                }
                for(int k = 0; k < n; k++) {
                    reachable[j][k] |= reachable[b][k];
                }
            }
        }
        help(n, reachable);
    }
    private static void help(int n, boolean[][] reachable){
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
