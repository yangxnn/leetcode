package work.wangyi;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] nks = new int[t][2];
        for (int i = 0; i < t; i++){
            nks[i][0] = sc.nextInt();
            nks[i][1] = sc.nextInt();
        }
        int[] res = new int[2];
        for (int i = 0; i < t; i++){
            res = help(nks[i][0], nks[i][0] - nks[i][1]);
            System.out.println(res[0] + " " + res[1]);
        }
    }
    private static int[] help(int n, int k){
        int[] res = new int[2];
        res[0] = 0;
        if (k < 0 || k >= n){
            return res;
        }
        if (k <= (n - 1)/2){
            res[1] = k;
        } else {
            while (!(k <= (n - 1)/2)){
                k--;
                n--;
            }
            res[1] = k;
        }
        return res;
    }
}
