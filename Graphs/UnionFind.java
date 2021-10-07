package Graphs;

public class UnionFind {

    // Number of elements in this Union Find
    private int size;

    private int[] rank;

    private int[] parent;

    //Number of components in Union find
    private int numComponents;

    UnionFind(int size){
        this.size = size;
        this.numComponents = size;
        rank = new int[size];
        parent = new int[size];

        for(int i = 0;i < size;i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    // finds the leader or root of x
    public int find(int x){
        if(parent[x] == x) return x;

        int temp = find(parent[x]);

        //path Compression
        parent[x] = temp;

        return temp;
    }

    public void union(int x,int y){
        int px = this.find(x);
        int py = this.find(y);

        //union by rank
        if(px != py){
            if(rank[px] > rank[py]){
                rank[px] += rank[py];
                parent[py] = px;
            }else if(rank[px] < rank[py]){
                rank[py] += rank[px];
                parent[px] = py;
            }else{
                parent[py] = px;
                rank[px] += rank[py];
            }
            numComponents--;
        }
    }

    // to find whether x and y have same leader or they belong to same component
    public boolean connected(int x,int y){
        return find(x) == find(y);
    }

    // total number of 'elements' in Union find
    public int getSize(){
        return size;
    }

    //returns number of elements in a component
    public int getSize(int p){return rank[p];}

    // total number of 'components' in Union find
    public int getNumComponents(){
        return numComponents;
    }

    public int[] getParent(){
        return parent;
    }

    public int[] getRank(){
        return rank;
    }

}
