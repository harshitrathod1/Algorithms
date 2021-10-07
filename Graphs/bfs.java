package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ver = Integer.parseInt(br.readLine());
        int edg = Integer.parseInt(br.readLine());

        Graph g = new Graph(ver);

        for(int n = 0; n < edg; n++){
            String[] a = br.readLine().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);

            g.adjList.get(u).add(v);
            g.adjList.get(v).add(u);
        }

        boolean[] vis = new boolean[ver];

        for(int i = 0; i < ver;i++){
            if(!vis[i]){
                Bfs(g,vis,i);
            }
        }

    }

    static void Bfs(Graph g,boolean[] vis,int node){
        Queue<Integer> q = new LinkedList<>();
        vis[node] = true;
        q.offer(node);


        while(!q.isEmpty()){
            int n = q.poll();
            System.out.print(n+" ");

            for(Integer adjNode: g.adjList.get(n)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
    }
}
