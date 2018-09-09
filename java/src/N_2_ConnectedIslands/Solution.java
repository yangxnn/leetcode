package N_2_ConnectedIslands;


import tools.union_find.UnionFind;

import java.util.ArrayList;
import java.util.List;

class Node{
    int id;
    List<Node> nexts;
    Node(int id){
        this.id = id;
        nexts = new ArrayList<>();
    }
}
public class Solution {
    public boolean isConnected(Node departure, Node destination, int n){
        // 使用并查集

        UnionFind uf = new UnionFind(n);


        return false;
    }
}
