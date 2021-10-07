package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArticulationPoints {

    static Graph g;
    static int id;
    static int dfsCalledForRootNode = 0;
    static int[] ids;
    static int[] low;
    static boolean[] visited;
    static boolean[] ap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ver = Integer.parseInt(br.readLine());
        int edg = Integer.parseInt(br.readLine());

        g = new Graph(ver);

        for(int n = 0; n < edg; n++){
            String[] a = br.readLine().split(" ");
            int u = Integer.parseInt(a[0])-1;
            int v = Integer.parseInt(a[1])-1;

            g.adjList.get(u).add(v);
            g.adjList.get(v).add(u);
        }

        articulationPoints(ver);

        for(int i = 0; i < ver;i++){
            if(ap[i]){
                System.out.println(i);
            }
        }

    }

    static void articulationPoints(int n){

        id = 0;
        ids = new int[n];
        low = new int[n];
        visited = new boolean[n];
        ap = new boolean[n];

        for(int i = 0; i < n;i++){
            if(!visited[i]){
                dfsCalledForRootNode = 0;
                dfs(i,i,-1);

                ap[i] = (dfsCalledForRootNode > 1);
            }
        }
    }
    static void dfs(int root,int at,int parent){

        if(parent == root) dfsCalledForRootNode++;
        visited[at] = true;
        low[at] = ids[at] = id++;

        for(Integer to : g.adjList.get(at)){
            if(to == parent){
                continue;
            }else if(visited[to] == true){
                low[at] = Math.min(low[at],ids[to]);
            }else{
                dfs(root,to,at);
                low[at] = Math.min(low[at],low[to]);

                if(low[to] > ids[at]){
                    //if yes then 'to' has reach to smaller ids only through me('at')
                    //therefore 'at' is a articulation point
                    ap[at] = true;
                }
                if(low[to] == ids[at]){
                    ap[at] = true;
                }
            }
        }//main
    }

    static void dfsP(int root,int parent,int at){

        visited[at] = true;

        for(Integer to : g.adjList.get(at)){

            if(!visited[to]){

            }
        }
    }
}
