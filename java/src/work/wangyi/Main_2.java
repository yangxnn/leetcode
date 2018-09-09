package work.wangyi;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();

        int[] ns = new int[n];
        for (int i = 0; i < n; i++){
            ns[i] = sc.nextInt();
        }
        int zhi = 0;
        int k = 0;
        int x = 0;
        int v = 0;
        for (int i = 2; i <= m + 1; i++){
            zhi = sc.nextInt();
            if (zhi == 1){
                k = sc.nextInt();
                System.out.println(ns[k -1]);
            } else {
                x = sc.nextInt();
                v = sc.nextInt();
                dao(ns, x, v);
            }

        }
    }
    private static void dao(int[] ns, int x, int v){
        x = x -1;
        while (v != 0){
            if (x > ns.length-1){
                break;
            }
            if (ns[x] != 0){
                if (v <= ns[x]){
                    ns[x] =ns[x] - v;
                    v= 0;
                } else {
                    ns[x] = 0;
                    v = v - ns[x];
                    x = x + 1;
                }
            }
        }
    }
}
