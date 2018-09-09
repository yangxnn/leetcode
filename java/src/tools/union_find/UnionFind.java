package tools.union_find;

public class UnionFind {
    // 并查集
    private int[] father = null;
    public UnionFind(int n){
        father = new int[n];
        // 每个节点的父元素就是他自己，初始化
        for (int i = 0; i < n; i++){
            father[i] = i;
        }
    }

    int find(int a){
        // 最初祖先的特征 value = father[value]
        while (a != father[a]){
            a = father[a];
        }
        return a;
    }

    void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb){
            father[fa] = fb;
        }
    }

    boolean isConnected(int a, int b){
        return find(a) == find(b);
    }
}
