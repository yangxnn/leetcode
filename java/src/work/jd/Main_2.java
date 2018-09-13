package work.jd;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main_2 {

    private static int root(int[] parents, int i) {
        int root = parents[i];
        while(root != parents[root]) {
            root = parents[root];
        }
        return root;
    }

    private static boolean solve(boolean[][] adjacency, int N, int M) {
        int[] parents = new int[N];
        // init
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
        // iterate all nodes
        for(int i = 0; i < N; i++) {
            int myRoot = root(parents, i);
            // firstly iterate unreachable nodes
            for(int j = 0; j < N; j++) {
                if(adjacency[i][j]) {
                    continue;
                }
                parents[root(parents, j)] = myRoot;
            }
            // secondly iterate reachable nodes
            for(int j = 0; j < N; j++) {
                if(!adjacency[i][j] || i == j) {
                    continue;
                }
                if(root(parents, j) == myRoot) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        while(T-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            boolean[][] adjacency = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    adjacency[i][j] = i == j;
                }
            }
            for(int i = 0; i < M; i++) {
                int a = scan.nextInt() - 1;
                int b = scan.nextInt() - 1;
                adjacency[a][b] = adjacency[b][a] = true;
            }
            System.out.println(solve(adjacency, N, M) ? "Yes" : "No");
        }

        scan.close();
    }
}
