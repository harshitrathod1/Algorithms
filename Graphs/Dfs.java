package Graphs;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

public class Dfs {

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
                dfs(g,vis,i);
            }
        }
    }

    static void dfs(Graph g,boolean[] vis,int currentNode){

        vis[currentNode] = true;
        System.out.print(currentNode+" ");
        for(Integer adjNode : g.adjList.get(currentNode)){
            if(vis[adjNode] == false){
                dfs(g,vis,adjNode);
            }
        }
    }
}
