package Graphs;
import java.util.*;

class TestClass {
    static Graph g;
    static int id;
    static int dfsCalledForRoot;
    static int[] low;
    static int[] ids;
    static boolean[] visited;
    static boolean[] ap;
    static ArrayList<Edge> bridges;
    static class Graph{
        int v;
        int e;
        List<List<Integer>> adjList;
        Graph(int v,int e){
            this.v = v;
            this.e = e;
            adjList = new ArrayList<>();
            allocateSpace();
        }

        void allocateSpace(){
            for(int i = 0; i < v;i++){
                adjList.add(new ArrayList<Integer>());
            }
        }

        void addEdge(int u,int v){
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        Edge(int u,int v){
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o){
            if(this.u == o.u) return this.v - o.v;
            return this.u - o.u;
        }
    }

    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);

        int v1 = sc.nextInt();
        int e = sc.nextInt();

        g = new Graph(v1,e);

        for(int i = 0; i < e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u,v);
        }

        articulationPointsAndBridges(v1);
        int articulationPoints = 0;
        int bridgesCnt = bridges.size();

        for(int i = 0;i < v1;i++){
            if(ap[i])
                articulationPoints++;
        }

        System.out.println(articulationPoints);
        for(int i = 0;i < v1;i++){
            if(ap[i])
                System.out.print(i+" ");
        }
        System.out.println();

        Collections.sort(bridges);

        System.out.println(bridgesCnt);
        for(int i = 0; i < bridgesCnt;i++){
            Edge c = bridges.get(i);
            System.out.println(c.u+" "+c.v);
        }
    }

    static void articulationPointsAndBridges(int n){

        id = 0;
        ids = new int[n];
        low = new int[n];
        visited = new boolean[n];
        ap = new boolean[n];
        bridges = new ArrayList<>();

        for(int i = 0;i < n;i++){
            if(!visited[i]){
                dfsCalledForRoot = 0;
                dfs(i,i,-1);

                //articulation for roots handled
                ap[i] = dfsCalledForRoot > 1;
            }
        }
    }

    static void dfs(int root,int at,int parent){

        if(parent == root) dfsCalledForRoot++;

        visited[at] = true;
        ids[at] = low[at] = id++;

        for(Integer to: g.adjList.get(at)){

            if(to == parent){
                continue;
            }else if(visited[to] == true){
                low[at] = Math.min(low[at],ids[to]);
            }else{
                dfs(root,to,at);

                low[at] = Math.min(low[to],low[at]);

                if(low[to] > ids[at]){
                    bridges.add(new Edge(at,to));
                    ap[at] = true;
                }else if(low[to] == ids[at]){
                    ap[at] = true;
                }
            }
        }
    }
}
