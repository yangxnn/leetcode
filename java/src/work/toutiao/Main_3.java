package work.toutiao;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] table = new int[m][m];
        int[] parents = new int[m * m];
        Set<Integer> clusters = new TreeSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                table[i][j] = sc.nextInt();
                if(table[i][j] > 0) {
                    parents[i* m + j] = i * m + j;
                    clusters.add(i * m + j);
                }
            }
        }
        help(m, table, parents, clusters);

    }

    private static int get(int[][] table, int i, int j) {
        if(i < 0 || i >= table.length || j < 0 || j >= table.length) {
            return 0;
        }
        return table[i][j];
    }

    private static int root(int[] parents, int i) {
        int root = parents[i];
        while(root != parents[root]) {
            root = parents[root];
        }
        return root;
    }

    private static void merge(Set<Integer> clusters, int[] parents, int a, int b) {
        int rootA = root(parents, a);
        int rootB = root(parents, b);
        if(rootA != rootB) {
            clusters.remove(rootB);
            parents[rootB] = rootA;
        }

    }
    private static void help(int m, int[][] table, int[] parents, Set<Integer> clusters){
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(table[i][j] == 0) {
                    continue;
                }
                if(get(table, i - 1, j) > 0) {
                    merge(clusters, parents, i * m + j, (i - 1) * m + j);
                }
                if(get(table, i, j - 1) > 0) {
                    merge(clusters, parents, i * m + j, i * m + j - 1);
                }
            }
        }
        System.out.println(clusters.size());
    }
}
